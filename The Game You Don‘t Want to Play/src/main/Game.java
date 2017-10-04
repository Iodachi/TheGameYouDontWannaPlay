package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Scanner;

import Board.*;

import character.Player;
import gui.View;
import item.*;


/**
 * This class contains the game logic with methods that can be used for controller
 * @author stella
 *
 */
public class Game extends Observable{
	private Player player;
	private Board board;

	//if player is attacking monster, he should not be able to do other things until either of them is dead.
	private boolean attacking = false;
	private boolean isInShop = false;
	private boolean isInTemple = false;
	private boolean gameOver = false;

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

	/**
	 * player moves one grid to the given direction, can only move on ground.
	 * @param direction
	 * @throws InvalidMove
	 */
	public void move(String direction) throws InvalidMove {
		//facing direction is changed even if player didn't actually move 
		player.setFacingDirection(direction);
		changeView();
		
		player.move(direction);
		changeView();
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

		changeView();
	}

	/**
	 * try use bomb when presses e, if player happens to face a breakable wall, the bomb is successfully used.
	 * @throws InvalidMove
	 */
	public void tryBomb() throws InvalidMove {
		Entity[][] currentBoard = getBoard().getCurrentLevel().getEntities();
		Entity e = player.findFacingEntity(currentBoard);
		if(e instanceof Wall && ((Wall)e).isBreakable()) {
			player.useBomb();
			setToEmpty(e);
			changeView();
		}else {
			throw new InvalidMove("No breakable wall in front, cannot use bomb.");
		}
	}

	/**
	 * picks up the equipment on the ground by pressing q, put down current one on floor.
	 * @throws InvalidMove 
	 */
	public void tryPickEquipment() throws InvalidMove {
		Entity[][] currentBoard = getBoard().getCurrentLevel().getEntities();
		Entity e = currentBoard[player.getYPos()][player.getXPos()];
		if(e instanceof Ground && ((Ground) e).getWhatContain() instanceof WearableItem) {
			Ground g = (Ground)e;
			WearableItem old = player.equip(((WearableItem)g.getWhatContain()));
			if(old != null) {
				g.setItem(old);
			}else{
				g.SetContainNothing();
			}
		}else {
			throw new InvalidMove("No equipment on ground to pick up.");
		}
		changeView();
	}

	/**
	 * player restores health using the health potion
	 * @param type
	 * @throws InvalidMove
	 */
	public void tryRestoreHealth(String type) throws InvalidMove {
		player.useHealthPotion(type);
		changeView();
	}
	
	/**
	 * player gains or loses health using the fate coin
	 * @throws InvalidMove
	 */
	public void tryUseFateCoin() throws InvalidMove {
		player.useFateCoin();
		changeView();
	}

	//========================================================= setters and getters ===========================================================================
	public Player getPlayer() {return player;}
	
	public Board getBoard() {return board;}
	
	public void setAttacking(boolean attack) {
		attacking = attack;
		changeView();
	}
	
	public void setInShop(boolean inShop) {
		isInShop = inShop;
	}
	
	public void setInTemple(boolean inTemple) {
		isInTemple = inTemple;
	}
	
	public void gameOver() {
		gameOver = true;
	}


	//========================================================= Help Method ===========================================================================
	/**
	 * set the entity to a normal ground, for example after a wall is broke or a door is open
	 * this is here instead of Level or Board class is because the entities[][] can be accessed easily
	 * @param e
	 */
	public void setToEmpty(Entity e) {
		int x = e.getPosX();
		int y = e.getPosY();
		board.getCurrentLevel().getEntities()[x][y] = new Ground(00,x,y,View.TILESIZE);
	}
	
	/**
	 * Notify the view to change
	 */
	public void changeView() {
		this.setChanged();
		this.notifyObservers();
	}

	public boolean isInShop() {
		return isInShop;
	}
	
	public boolean isInTemple() {
		return isInTemple;
	}


	public boolean isAttacking() {
		// TODO Auto-generated method stub
		return this.attacking;
	}
}