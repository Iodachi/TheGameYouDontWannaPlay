package character;

import java.util.Stack;

import Board.Entity;
import Board.Level;
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
		}
	}

	/**
	 * use a key in the corresponding color from inventory to open door，
	 * @param color
	 * 					the color of the key needed to open the door
	 * @throws InvalidMove
	 * 					throws an invalid move exception if doesn't have a key in that color
	 */
	public void useKey(String color) throws InvalidMove {
		boolean hasKey = false;
		for(ConsumableItem item: inventory) {
//			if(item instanceof Key && ((Key)item).getColor().equals(color)) {
//				inventory.remove(item);
//				hasKey = true;
//				break;
//			}
		}

		//when all items in inventory has been checked and
		//player doesn't have the key, the door cannot be opened
		if(!hasKey)
			throw new InvalidMove("No such key in inventory, cannot open the door");
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

		//TODO: door, wall interaction, as well as monsters
		if(direction.equals("right")) {
			if(xPos + 1 > boardSize - 1) 
				throw new InvalidMove("Cannot move out of board");
			
			Entity e = board[xPos+1][yPos];
			if(e != null && e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall");
			
			xPos++;
		}else if(direction.equals("left")) {
			if(xPos - 1 < 0) 
				throw new InvalidMove("Cannot move out of board");
			
			Entity e = board[xPos-1][yPos];
			if(e != null && e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall");
			
			xPos--;
		}else if(direction.equals("up")) {
			if(yPos - 1 < 0) 
				throw new InvalidMove("Cannot move out of board");
			
			Entity e = board[xPos][yPos-1];
			if(e != null && e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall");
			
			yPos--;
		}else if(direction.equals("down")) {
			if(yPos + 1 > boardSize - 1) 
				throw new InvalidMove("Cannot move out of board");
			
			Entity e = board[xPos][yPos+1];
			if(e != null && e instanceof Wall)
				throw new InvalidMove("Cannot move towards wall");
			
			yPos++;
		}
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
	
	public Stack<ConsumableItem> getInventory() {
		return inventory;
	}
	
	public void setCurrentGame(Game game) {
		this.game = game;
	}
}
