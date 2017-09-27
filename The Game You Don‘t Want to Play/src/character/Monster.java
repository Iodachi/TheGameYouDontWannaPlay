
package character;

import Board.Entity;
import item.Item;

public class Monster {

	private int health = 10;
	private int damage =2;
	private int defence = 2;
	private boolean isDefeated = false;
	//the potential drop of coins when the monster dies
	private int drop;
	private int level=1;
	private String name = "M1";

	public Monster(int level){
		this.level = level;
		setName(level);
		setAttribute(level);
		computeDrop();
	}



	public void setAttribute(int level) {
		this.health= (int) Math.pow(health,level );
		this.damage= (int)Math.pow(damage, level);
		this.defence =(int)Math.pow(defence, level);
	}

	public void setName(int level) {
		switch (level) {
		case 1:
			this.name = "91";
			break;
		case 2:
			this.name = "92";
			break;
		case 3:
			this.name = "93";
			break;
		case 4:
			this.name = "94";
			break;
		case 5:
			this.name = "95";
			break;
		case 6:
			this.name = "96";
			break;
		case 7:
			this.name = "97";
			break;
		case 8:
			this.name = "98";
			break;

		}
	}

	/**
	 * generates a random number of coins drop when monster is defeated
	 */
	public void computeDrop() {
		//FIXME probably need to balance this
		int randomNumber = (int)Math.random()*10;
		drop = level * randomNumber;
	}

	public void attack(Player player) {

	}

	public void defeated(Player player) {
		isDefeated = true;
		player.setGold(player.getGold() + drop);
	}

	public int getDamage() {
		return damage;
	}

	public int getDefence() {
		return defence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDefeated() {
		return isDefeated;
	}
	public String getName() {
		return name;
	}
}

