package item;


import character.Player;

public abstract class WearableItem implements Item {

	public abstract void putOn(Player player);
	public abstract void takeOff(Player player);
	public abstract void fix(int amount);
	
}
