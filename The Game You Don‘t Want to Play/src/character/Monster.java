
package character;

import Board.Entity;
import item.Item;

public class Monster {
		
	private int health = 50;
	private int damage =50;
	private int defenece = 50;
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
	
	public void setAttrHelper(int amount) {
		this.health=amount*2;
		this.damage=amount;
		this.defenece=amount;
	}
	
	public void setAttribute(int level) {
        setAttrHelper(50*level);
	}
	
	public void setName(int level) {
		switch (level) {
		case 1:
			this.name = "M1";
			break;
		case 2:
			this.name = "M2";
			break;
		case 3:
			this.name = "M3";
			break;
		case 4:
			this.name = "M4";
			break;
		case 5:
			this.name = "M5";
			break;
		case 7:
			this.name = "M7";
			break;
		case 8:
			this.name = "M8";
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
		//FIXME probably dont need this, just need a method in player class 
		//like player.attack(monster)
	}
	
	public void defeated(Player player) {
		isDefeated = true;
		player.setGold(player.getGold() + drop);
	}
	
	public boolean isDefeated() {
		return isDefeated;
	}
}

