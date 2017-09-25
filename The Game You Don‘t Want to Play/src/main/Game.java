package main;


import java.util.Observable;

import Board.Board;
import Board.Door;
import Board.Entity;
import Board.Ground;
import Board.Wall;
import character.Player;
import gui.View;
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
		SoundResources.Fight.sound.loop();
		player = new Player();
		player.setCurrentGame(this);
		board = new Board();
		new View(this);
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

	public Player getPlayer() {
		return player;
	}
	
	public Board getBoard() {
		return board;
	}
	
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
