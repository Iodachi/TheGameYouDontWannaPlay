package item;

import character.Player;
/***
 * This class is represent the wing. it will appear somewhere in the game map. Meantime, the player can pick up the item
 * The player can put on or take off the wing. Once the player wear the wing, the speed of movement will be doubled 
 * */
public class Wing extends WearableItem {

   private int speedFactor = 2;
   private boolean isOn=false;
   private String name="45";
   private int x,y;
   private int cost = 1000;
   @Override
	public String toString() {
		return name;
	}
   @Override
	public int getCost() {
		return cost;
	}
   	
	@Override
	public void putOn(Player player) {
		if(!isOn){
			player.setSpeed(player.getSpeed()*speedFactor);
			isOn=true;
		}
		
	}
	public String getName(){
		return name;
	}
	@Override
	public void takeOff(Player player) {
		if(isOn){
			player.setSpeed(player.getSpeed()/speedFactor);
			isOn =false;
		}
		
	}
	public Wing(int x,int y) {
		this.x =x ;
		this.y =y;
	}
	@Override
	public void fix(int amount) {
		
	}

	@Override
	public boolean on(int x, int y) {
		return false;
	}
}
