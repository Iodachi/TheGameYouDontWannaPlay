package main;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import Board.Board;
import Board.Door;
import Board.Entity;
import Board.Ground;
import Board.Wall;
import character.Player;
import gui.View;
import item.BloodVial;
import item.ConsumableItem;
import item.Weapon;
import item.WearableItem;
import resources.SoundResources;

/**
 * This class contains the game logic with methods that can be used for controller
 * @author stella
 *
 */
public class Game extends Observable{
	private Player player;
	public Board board;

	public Game() {
		//	SoundResources.Fight.sound.loop();
		player = new Player();
		player.setCurrentGame(this);
		board = new Board();
		new View(this);
	}

	/**
	 * Constructor for save and load
	 * @param p
	 * @param b
	 */
	public Game(String filename) {
		//	SoundResources.Fight.sound.loop();
		try {
			FileReader savefile =  new FileReader(filename);
			BufferedReader save = new BufferedReader(savefile);
			Scanner sc = new Scanner(save);
			this.player = new Player();
			StringBuilder b = new StringBuilder();
			this.player.ParserPlayer(sc);
			this.board = new Board(sc);   
            this.player.setCurrentGame(this);
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		new View(this);
	}
	//========================================================= Control Method ===========================================================================

	public void save(){
		try{
			PrintWriter writer = new PrintWriter("save.txt", "UTF-8");
			String saveBoard = this.board.toString(); 
			String savePlayer = this.player.toString();
			writer.write(savePlayer);
			writer.write(saveBoard);

			writer.close();
		} catch (IOException e) {
			// do something
		}

	}

	public void move(String direction) throws InvalidMove {
		//facing direction is changed even if player didn't actually move 
		player.setFacingDirection(direction);
		this.setChanged();
		this.notifyObservers();

		player.move(direction);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * try open the door when encounters one
	 * @param door
	 * @throws InvalidMove
	 */
	public void tryOpenDoor(Door door) throws InvalidMove {
		String keyColor = door.getColor();

		player.useKey(keyColor);
		setToEmpty(door);

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * try use bomb when presses e, if player happens to face a breakable wall, the bomb is successfully used.
	 * @throws InvalidMove
	 */
	public void tryBomb() throws InvalidMove {
		Entity[][] currentBoard = getBoard().GetCurrentLevel().getEntities();
		Entity e = player.findFacingEntity(currentBoard);
		if(e instanceof Wall && ((Wall)e).isBreakable()) {
			player.useBomb();
			setToEmpty(e);

			this.setChanged();
			this.notifyObservers();
		}else {
			throw new InvalidMove("No breakable wall in front, cannot use bomb.");
		}
	}

	/**
	 * picks up the equipment on the ground by pressing q, put down current one on floor.
	 */
	public void tryPickEquipment() {
		Entity[][] currentBoard = getBoard().GetCurrentLevel().getEntities();
		Entity e = currentBoard[player.getYPos()][player.getXPos()];
		if(e instanceof Ground) {
			Ground g = (Ground)e;
			if(g.getWhatContain() instanceof WearableItem){
				player.equip((WearableItem)g.getWhatContain());
				//TODO put down current one
				setToEmpty(e);
				this.setChanged();
				this.notifyObservers();
			}
		}
	}

	/**
	 * player restores health using the health potion
	 * @param type
	 * @throws InvalidMove
	 */
	public void tryRestoreHealth(String type) throws InvalidMove {
		player.useHealth(type);
	}
	
	//========================================================= Return Method ===========================================================================
	public Player getPlayer() {return player;}
	public Board getBoard() {return board;}

	//========================================================= Help Method ===========================================================================
	/**
	 * set the entity to a normal ground, for example after a wall is broke or a door is open
	 * this is here instead of Level or Board class is because the entities[][] can be accessed easily
	 * @param e
	 */
	public void setToEmpty(Entity e) {
		int x = e.GetPosX();
		int y = e.GetPosY();
		board.GetCurrentLevel().getEntities()[x][y] = new Ground(00,x,y,View.TILESIZE);
	}
}