package character;

import item.Item;

public abstract class Monster {
	private int health, damage, defence;
	private int xPos, yPos;
	private boolean isDefeated = false;
	//the potential item drop when the monster dies
	private Item drop;
	
	public void attack(Player player) {
		//FIXME probably dont need this, just need a method in player class 
		//like player.attack(monster)
	}
	
	public void defeated() {
		isDefeated = true;
	}
	
	public boolean isDefeated() {
		return isDefeated;
	}
}
