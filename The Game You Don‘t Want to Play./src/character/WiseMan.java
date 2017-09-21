package character;

import item.WearableItem;

/**
 * A wise old man that teaches our hero lessons as well as gives him good stuff.
 * @author stella
 *
 */
public class WiseMan {
	private WearableItem item;
	
	public WiseMan(WearableItem item) {
		this.item = item;
	}
	
	public void give(Player player) {
		//FIXME: player doesn't want this equipment?
		player.equip(item);
	}
}
