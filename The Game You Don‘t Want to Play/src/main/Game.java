package main;

import character.Player;

/**
 * This class contains the game logic with methods that can be used for controller
 * @author stella
 *
 */
public class Game {
	private Player player;
	
	public Game() {
		//FIXME replace this with a info box in gui to ask player's name
		String name = "";
		player = new Player("Cui Hua");
	}
	
	public void move(String direction) throws InvalidMove {
		player.move(direction);
	}
	
//	/**
//	 * when player presses e, apply interaction with the grid that player is currently facing, 
//	 * including opening doors, bombing walls, as well as inteactions with shop and other NPC.
//	 * @param grid
//	 */
//	public void interaction(Grid grid) {
//		if(grid instanceof Door) {
//			Key key = door.getKeyType();
//			//when player doesn't have the key, the door cannot be opened
//			if(!player.getInventory().contains(key))
//				throw new InvalidMove("No such key in inventory, cannot open the door");
//
//			player.useItem(key);
//			(Door)grid.open();
//		}else if(grid instanceof BreakableWall) {
//			Bomb bomb = new Bomb();
//			if(!player.getInventory().contains(bomb))
//				throw new InvalidMove("No bomb in inventory, cannot break the wall");
//
//			player.useItem(bomb);
//			(Bomb)grid.break();
//		}
//	}
}
