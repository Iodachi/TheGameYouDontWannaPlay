package item;

import Board.Level;
import character.Player;

/***
 * increase the player's damage
 */
public class Weapon extends WearableItem {
	private int attack = 500;
	private int x, y;
	private boolean isOn = false;
	private String name = "44";
	private int cost = 600;
	private int level = 0;
	boolean getIsoN() {
		return isOn;
	}
	@Override
	public String toString() {
		return name;
	}
	public int getAttack() {
		return attack;
	}
	@Override
	public void putOn(Player player) {
		if (!isOn) {
			player.setDamage(player.getDamage() + attack);
			isOn = true;
		}

	}

	// level could be 0,1,2
	// when level is 0, the name and defence keep as default
	// Otherwise, they will be changed in setAttribute method
	public Weapon(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
		setAttribute(level);
	}

	// level could be 0,1,2
	// when level is 0, the name and defence keep as default
	// Otherwise, they will be changed in setAttribute method
	public void setAttribute(int level) {
		switch (level) {
		case 1:
			attack = 1000;
			name = "35";
			break;
		case 2:
			attack = 2000;
			name = "36";
			break;
		}

	}

	public String getName() {
		return name;
	}

	@Override
	public void takeOff(Player player) {
		if (isOn) {
			player.setDamage(player.getDamage() - attack);
			isOn = false;
		}
	}

	@Override
	public void fix(int amount) {

	}

	@Override
	public boolean on(int x, int y) {
		return this.x==x&&this.y==y;
	}

	@Override
	public int getCost() {
		return cost;
	}
}
