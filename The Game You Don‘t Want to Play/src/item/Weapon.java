package item;

import character.Player;
/***
 * increase the player's damage
 * */
public class Weapon extends WearableItem {
	private int attack =500;
	private int x,y;
	private boolean isOn=false;

	@Override
	public void putOn(Player player) {
		if(!isOn){
			player.setDamage(player.getDamage()+attack);
			isOn=true;
		}

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
}
