package character;

import java.util.Map;

import item.ConsumableItem;
import item.Item;
import item.WearableItem;
import main.InvalidMove;

/**
 * A shop that sells a variety of items including both equipments and consumables.
 * @author stella
 *
 */
public class Shop {
	//a list of items that the shop sells, with their corresponding prices
	private Map<? extends Item, Integer> items;
	
	public Shop(Map<? extends Item, Integer> items) {
		this.items = items;
	}
	
	/**
	 * player buys an item from shop, throws an exception if doesn't have enough money.
	 * @param item
	 * @param player
	 * @throws InvalidMove
	 */
	public <T> void buyItem(T item, Player player) throws InvalidMove {
		int price = items.get(item);
		
		if(player.getGold() >= price) {
			//player buys the item, deduct money and equip/add item to inventory.
			player.setGold(player.getGold() - price);
			
			if(item instanceof ConsumableItem) {
				player.addItem((ConsumableItem) item);
			}else if(item instanceof WearableItem) {
				player.equip((WearableItem) item);
			}
		}else {
			throw new InvalidMove("Cannot buy this item, you don't have enough gold.");
		}
	}
}
