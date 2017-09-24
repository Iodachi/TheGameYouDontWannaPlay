package main;


import java.util.Observable;

import Board.Board;
import Board.Door;
import Board.Entity;
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
	
	public void tryOpenDoor(Door door) throws InvalidMove {
		String keyColor = door.getColor();

		player.useKey(keyColor);
		door.setOpen(true);

		this.setChanged();
		this.notifyObservers();
	}
	
	public void tryBomb() throws InvalidMove {
		Entity[][] currentBoard = getBoard().GetCurrentLevel().getEntities();
		Entity e = player.findFacingEntity(currentBoard);
		if(e instanceof Wall && ((Wall)e).isBreakable()) {
			player.useBomb();
		}else {
			throw new InvalidMove("This wall is not breakable, cannot use bomb.");
		}
	}

	public Player getPlayer() {
		return player;
	}
	
	public Board getBoard() {
		return board;
	}
}
