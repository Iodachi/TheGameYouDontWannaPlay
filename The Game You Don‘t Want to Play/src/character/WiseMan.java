package character;

import item.Item;
import item.WearableItem;

/**
 * A wise old man that teaches our hero lessons as well as gives him good stuff.
 * @author stella
 *
 */
public class WiseMan {
	private Item item;
	
	public WiseMan(Item item) {
		this.item = item;
	}
	
	public void give(Player player) {
		//FIXME: player doesn't want this equipment?
		if(item instanceof WearableItem)
			player.equip((WearableItem)item);
	}
}
