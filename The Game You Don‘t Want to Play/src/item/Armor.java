package item;

import character.Player;

/**
 * This class is used to represent the armor equipment which the player can put
 * on to increase defence of player
 *
 * @author minpingyang
 */
public class Armor extends WearableItem {
	private int defence = 10;
	private int x, y;
	private boolean isOn = false; // the flag is used to indicate if player has wear the Armor
	private String name = "42";
	private int level = 0;
	private int cost = 800;

	@Override
	public String toString() {
		return name;
	}

	/**
	 *
	 * level could be 0,1,2 when level is 0, the name and defence keep as default
	 * Otherwise, they will be changed in setAttribute method
	 * @param x, y, level
	 **/
	public Armor(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
		setAttribute(level);
	}

	/**
	 * According to the level of armor, set up the armor code name and defence
	 *@param level
	 **/
	public void setAttribute(int level) {
		switch (level) {
		case 1:
			defence = 200;
			name = "25";
			break;
		case 2:
			defence = 300;
			name = "26";
			break;
		}

	}
	/**
	 * This method is used to put on the armor, then player's attributes would be changed
	 * @param player
	 * **/
	@Override
	public void putOn(Player player) {
		if (!isOn) {
			player.setDefence(player.getDefence() + defence);
			isOn = true;
		}

	}
	/**
	 * This method is used to take off the armor, then player's attributes would be changed
	 * @param player
	 * **/
	@Override
	public void takeOff(Player player) {
		if (isOn) {
			player.setDefence(player.getDefence() - defence);
			isOn = false;
		}

	}

	public String getName() {
		return name;
	}

	@Override
	public boolean on(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getCost() {
		return cost;
	}

	boolean getIsOn() {
		return isOn;
	}

	public int getDefence() {
		return defence;
	}

	@Override
	public void fix(int amount) {

	}
}
