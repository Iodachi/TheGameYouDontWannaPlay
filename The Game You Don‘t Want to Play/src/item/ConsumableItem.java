package item;

import character.Player;

/**
 * This abstract class is used to represent a kind of items. If consumable item was used, then it was just simply disappear.
 *
 * */
public abstract class ConsumableItem implements Item {
	
	public abstract void use(Player player);
	
}
