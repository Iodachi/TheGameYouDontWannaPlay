package item;

import Board.Level;
import character.Player;

/***
 * This class is represent the wing. it will appear somewhere in the game map.
 * Meantime, the player can pick up the item The player can put on or take off
 * the wing. Once the player wear the wing, the speed of movement will be
 * changed
 */
public class Wing extends WearableItem {

	private int speedFactor = 2;
	private int health = (int) Math.pow(10, 3);
	private boolean isOn = false;
	private String name = "45";
	private int x, y;
	private int cost = 1000;
	private int level = 0;

	/*
	 * level could be 0,1,2 when level is 0, the name and defence keep as default
	 * Otherwise, they will be changed in setAttribute method
	 * @param x
	 * @param y
	 * @param level
	 */
	public Wing(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
		setAttribute(level);
	}

	/*
	 * This method is used to put on the wing, then player's attributes would be
	 * changed
	 *
	 * @param player
	 **/
	@Override
	public void putOn(Player player) {
		if (!isOn) {
			player.setSpeed(player.getSpeed() * speedFactor);
			player.setHealth(player.getHealth() + health);
			isOn = true;
		}

	}

	/*
	 * This method is used to take off the wing, then player's attributes would be
	 * changed
	 *
	 * @parmater player
	 **/
	@Override
	public void takeOff(Player player) {
		if (isOn) {
			player.setSpeed(player.getSpeed() / speedFactor);
			isOn = false;
		}

	}

	/*
	 * level could be 0,1,2 when level is 0, the name and defence keep as default
	 * Otherwise, they will be changed in setAttribute method
	 * @param level
	 */
	public void setAttribute(int level) {
		switch (level) {
		case 1:
			speedFactor = 3;
			health = health = (int) Math.pow(10, 6);
			name = "46";
			break;
		case 2:
			speedFactor = 4;
			health = health = (int) Math.pow(10, 7);
			name = "47";
			break;
		}

	}
	/**
	 * all getter and setter
	 * */
	public int getSpeedFactor() {
		return speedFactor;
	}

	@Override
	public void fix(int amount) {

	}

	@Override
	public String toString() {
		return name;
	}

	public boolean getIsOn() {
		return isOn;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public boolean on(int x, int y) {
		return this.x == x && this.y == y;
	}

	public String getName() {
		return name;
	}

}
