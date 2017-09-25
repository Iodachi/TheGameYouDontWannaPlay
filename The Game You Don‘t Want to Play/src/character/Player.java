package character;

import java.util.Stack;

import Board.Door;
import Board.Entity;
import Board.Ground;
import Board.Level;
import Board.Stairs;
import Board.Wall;
import item.*;
import main.Game;
import main.InvalidMove;

/**
 * This class represents the character that player controls, player can do all sorts of things such as move, attack, use items and so on.
 * Player can also equip items, and have certain health, damage and defence, when his health reaches 0, he dies and the game is over.
 * @author stella
 *
 */
public class Player{
	//the maximum amount of items can be stored in the inventory
	public static final int INVENTORY_CAPACITY = 30;
	private Game game;
	//a stack of items that player collected and can be used later.
	private Stack<ConsumableItem> inventory;
	//the current position of player on board
	private int xPos, yPos;
	private int health, damage, defence;
	private int gold;
	private int speed = 1;
	private String facingDirection;

	//equipments
	private Armor armor;
	private Weapon weapon;
	private Wing wing;

	public Player() {
		facingDirection = "down";
		inventory = new Stack<>();
		health = 100;
		damage = 10;
		defence = 10;
		gold = 0;
		xPos = 1;	
		yPos = 1;
	}

	/**
	 * pick up an item and add to inventory
	 * @param item
	 * @throws InvalidMove
	 */
	public void addItem(ConsumableItem item) throws InvalidMove {
		if(inventory.size() == INVENTORY_CAPACITY)
			throw new InvalidMove("Inventory is full.");

		inventory.add(item);
	}

	public void equip(WearableItem item) {
		//TODO: update on player's stats when an equipment is equiped
		if(item instanceof Armor) {
			armor = (Armor)item;
		}else if(item instanceof Weapon) {
			weapon = (Weapon)item;
		}else if(item instanceof Wing) {
			wing = (Wing)item;
		}
	}

	/**
	 * use a key in the corresponding color from inventory to open door
	 * @param color
	 * 					the color of the key needed to open the door
	 * @throws InvalidMove
	 * 					throws an invalid move exception if doesn't have a key in that color
	 */
	public void useKey(String color) throws InvalidMove {
		boolean hasKey = false;
		for(ConsumableItem item: inventory) {
			if(item instanceof Key && ((Key)item).getColor().equals(color)) {
				inventory.remove(item);
				hasKey = true;
				break;
			}
		}

		//when all items in inventory has been checked and
		//player doesn't have the key, the door cannot be opened
		if(!hasKey)
			throw new InvalidMove("You don't have a <" + color + "> key in inventory, cannot open the door");
	}

	/**
	 * use a bomb from inventory to break a breakable wall.
	 * @throws InvalidMove
	 * 					throws an invalid move excepction if doesn't have a bomb
	 */
	public void useBomb() throws InvalidMove {
		//FIXME: note, need to test if the wall breaks if dont' have bomb
		boolean hasBomb = false;
		for(ConsumableItem item: inventory) {
			if(item instanceof Bomb) {
				//bomb used, 
				inventory.remove(item);
				hasBomb = true;
				break;
			}
		}

		if(!hasBomb)
			throw new InvalidMove("No bomb in inventory, cannot break the wall");
	}

	//================ movement methods =====================
	public void move(String direction) throws InvalidMove {
		int boardSize = Level.BOARDSIZE;
		Entity[][] board = game.getBoard().GetCurrentLevel().getEntities();

		//TODO: door interaction, as well as monsters
		if(direction.equals("right")) {
			moveRight(board, boardSize);
		}else if(direction.equals("left")) {
			moveLeft(board, boardSize);
		}else if(direction.equals("up")) {
			moveUp(board, boardSize);
		}else if(direction.equals("down")) {
			moveDown(board, boardSize);
		}
		
		newGridInteraction(board);
	}
	
	public void moveRight(Entity[][] board, int boardSize) throws InvalidMove {
		if(xPos + 1 > boardSize - 1) 
			throw new InvalidMove("Cannot move out of board");
		
		Entity e = board[yPos][xPos+1];
		if(e != null) {
			if(e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall on right");
			else if(e instanceof Door)
				game.tryOpenDoor((Door) e);
		}
		
		if(!(e instanceof Ground && ((Ground) e).isLava()))
			xPos++;
	}

	public void moveLeft(Entity[][] board, int boardSize) throws InvalidMove {
		if(xPos - 1 < 0) 
			throw new InvalidMove("Cannot move out of board");
		
		Entity e = board[yPos][xPos-1];
		if(e != null) {
			if(e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall on left");
			else if(e instanceof Door)
				game.tryOpenDoor((Door) e);
		}
		
		if(!(e instanceof Ground && ((Ground) e).isLava()))
			xPos--;
	}

	public void moveUp(Entity[][] board, int boardSize) throws InvalidMove {
		if(yPos - 1 < 0) 
			throw new InvalidMove("Cannot move out of board");
		
		Entity e = board[yPos-1][xPos];
		if(e != null) {
			if(e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall on top");
			else if(e instanceof Door)
				game.tryOpenDoor((Door) e);
		}
		
		if(!(e instanceof Ground && ((Ground) e).isLava()))
			yPos--;
	}

	public void moveDown(Entity[][] board, int boardSize) throws InvalidMove {
		if(yPos + 1 > boardSize - 1) 
			throw new InvalidMove("Cannot move out of board");
		
		Entity e = board[yPos+1][xPos];
		if(e != null) {
			if(e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall on bottom");
			else if(e instanceof Door)
				game.tryOpenDoor((Door) e);
		}
		
		if(!(e instanceof Ground && ((Ground) e).isLava()))
			yPos++;
	}
	
	/**
	 * if there is an item that can be picked up in the new position, pick it up,
	 * if there is a stair, teleport player to corresponding level
	 * @param board
	 * @throws InvalidMove
	 */
	public void newGridInteraction(Entity[][] board) throws InvalidMove {
		Entity e = board[yPos][xPos];
		if(e != null) {
			if(e instanceof Ground) {
				Ground g = ((Ground) e);
				if(g.getWhatContain() instanceof Item) {
					if(g.getWhatContain() instanceof ConsumableItem) {
						addItem((ConsumableItem)(g.getWhatContain()));
						game.setToEmpty(g);
					}
				}
			}else if(e instanceof Stairs) {
				if(((Stairs)e).upOrDownStair())
					game.board.setCurrentLevel(game.board.getCurrentLevelNumber() + 1);
				else
					game.board.setCurrentLevel(game.board.getCurrentLevelNumber() - 1);
			}
		}
	}
	
	/**
	 * finds the next grid on player's current facing direction. for example if player is in pisition (2, 2) and facing right,
	 * 	the position of this grid will be (2, 3)
	 * @param currentBoard
	 * @return
	 */
	public Entity findFacingEntity(Entity[][] currentBoard) {
		//TODO: test me!
		Entity e = null;
		int boardSize = Level.BOARDSIZE;
		if(facingDirection.equals("right")) {
			if(xPos + 1 <= boardSize - 1) 
				e = currentBoard[yPos][xPos+1];
		}else if(facingDirection.equals("left")) {
			if(xPos - 1 >= 0) 
				e = currentBoard[yPos][xPos-1];
		}else if(facingDirection.equals("up")) {
			if(yPos - 1 >= 0) 
				e = currentBoard[yPos-1][xPos];
		}else if(facingDirection.equals("down")) {
			if(yPos + 1 <= boardSize - 1) 
				e = currentBoard[yPos+1][xPos];
		}
		return e;
	}
	
	//=============== counting inventory ====================
	/**
	 * count the number of keys in given color in inventory
	 * @param color
	 * @return
	 */
	public int getNumKeys(String color) {
		int num = 0;
		for(ConsumableItem item: inventory) {
			if(item instanceof Key) {
				if(((Key)item).getColor().equals(color)) {
					num++;
				}
			}
		}
		return num;
	}
	
	public int getNumBombs() {
		int num = 0;
		for(ConsumableItem item: inventory) {
			if(item instanceof Bomb) {
				num++;
			}
		}
		return num;
	}
	
	public int getNumBlood(String type) {
		int num = 0;
		for(ConsumableItem item: inventory) {
			if(item instanceof BloodVial) {
				if(((BloodVial)item).getType().equals(type)){
					num++;
				}
			}
		}
		return num;
	}

	//================= setter and getters ===================

	/**
	 * set a change on current health, either because of using items (health potion/equipments) 
	 * or attacted by a monster
	 * @param amount
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getDefence() {
		return defence;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}

	public String getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(String direction) {
		this.facingDirection = direction;
	}

	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public Armor getCurrentArmor() {
		return armor;
	}

	public Weapon getCurrentWeapon() {
		return weapon;
	}
	
	public Wing getCurrentWing() {
		return wing;
	}

	public Stack<ConsumableItem> getInventory() {
		return inventory;
	}

	public void setCurrentGame(Game game) {
		this.game = game;
	}

	public Player setPos(int x, int y){
		this.xPos = x;
		this.yPos = y;
		return this;
	}
}