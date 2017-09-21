package main;


import java.util.Observable;

import Board.Board;
import character.Player;
import gui.View;

/**
 * This class contains the game logic with methods that can be used for controller
 * @author stella
 *
 */
public class Game extends Observable{
	private Player player;
	public Board board;

	public Player getPlayer() {
		return player;
	}

	public Game() {
		player = new Player();
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
	 * when player presses e, apply interaction with the grid that player is currently facing, 
	 * including opening doors, bombing walls, as well as inteactions with shop and other NPC.
	 * Do nothing if no block can interact with, or no item in inventory to interact.
	 * @param grid
	 * 				the next grid on player's current facing direction. for example if player is in pisition (2, 2) and facing right,
	 * 				the position of this grid will be (2, 3)
	 */
//	public void interaction(Grid grid) {
//		if(grid instanceof Door) {
//			String keyColor = ((Door)grid).GetColor();
//			player.useKey(keyColor);
//			(Door)grid.open();
//		}else if(grid instanceof BreakableWall) {
//			player.useBomb();
//			(BreakableWall)grid.collapse();
//		}
//	}
}
