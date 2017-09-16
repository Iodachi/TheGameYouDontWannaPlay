package character;

import java.util.Stack;

import item.ConsumableItem;

/**
 * This class represents the character that player controls, player can do all sorts of things such as move, attack, use items and so on.
 * Player can also equip items, and have certain health, damage and defence, when his health reaches 0, he dies and the game is over.
 * @author stella
 *
 */
public class Player {
	private String name;
	//a stack of items that player collected and can be used later.
	private Stack<ConsumableItem> inventory;
	//the maximum amount of items can be stored in the inventory
	private static final int INVENTORY_CAPACITY = 30;
	//the current position of player on board
	private int xPos, yPos;
	private int health, damage, defence;
	private int gold;
	
	public Player(String name) {
		this.name = name;
		health = 100;
		damage = 10;
		defence = 10;
		gold = 0;
	}
	
	/**
	 * player uses an consumable item from his inventory, for example a key to unlock a door,
	 * or a potion to restore health.
	 * @param item
	 */
	public void useItem(ConsumableItem item) {
		//TODO: different effects when using different items
		
		inventory.remove(item);
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
	
	//================ movement methods =====================
	public void move(String direction) throws InvalidMove {
		//TODO: replace this with board size
		int boardSize = 10;
		
		//TODO: door, wall interaction, as well as monsters
		if(direction.equals("right")) {
			if(xPos + 1 > boardSize - 1) {
				throw new InvalidMove("Cannot move out of board");
			}
			xPos++;
		}else if(direction.equals("left")) {
			if(xPos - 1 < 0) {
				throw new InvalidMove("Cannot move out of board");
			}
			xPos--;
		}else if(direction.equals("up")) {
			if(yPos - 1 < 0) {
				throw new InvalidMove("Cannot move out of board");
			}
			xPos--;
		}else if(direction.equals("down")) {
			if(yPos + 1 > boardSize - 1) {
				throw new InvalidMove("Cannot move out of board");
			}
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
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
}
