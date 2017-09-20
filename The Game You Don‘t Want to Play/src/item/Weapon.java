package item;

import character.Player;
/***
 * increase the player's damage
 * */
public class Weapon extends WearableItem {
	private int attack =500;
	private int x,y;
	private boolean isOn=false;
	private String name="WE";
	private int cost = 600;
	@Override
	public void putOn(Player player) {
		if(!isOn){
			player.setDamage(player.getDamage()+attack);
			isOn=true;
		}

	}
	public Weapon(int x, int y) {
		this.x = x;
		this.y =y;
	}
	public String getName(){
		return name;
	}
	@Override
	public void takeOff(Player player) {
		if(isOn){
			player.setDamage(player.getDamage()+attack);
			isOn=true;
		}
	}

	@Override
	public void fix(int amount) {

	}

	@Override
	public boolean on(int x, int y) {
		return false;
	}
	@Override
	public int getCost() {
		return cost;
	}
}
