package character;

import java.util.HashMap;
import java.util.Map;

import item.*;
import main.InvalidMove;

/**
 * A shop that sells a variety of items including both equipments and consumables.
 * @author stella
 *
 */
public class Shop {
	//a list of items that the shop sells, with their corresponding prices
	private Map<Item, Integer> items;
	
	public Shop() {
		items = new HashMap<>();
		generateItem();
		generateItem();
		generateItem();
	}
	
	/**
	 * player buys an item from shop, throws an exception if doesn't have enough money.
	 * @param item
	 * @param player
	 * @throws InvalidMove
	 */
	public void buyItem(Item item, Player player) throws InvalidMove {
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
	
	public void generateItem() {
		int item = (int) (Math.random()*10);
		int price = (int) (Math.random()*10);
		if(item == 0) {
			items.put(new Key("gold"), (int) (price*1.5));
		}else if(item == 1) {
			items.put(new Key("silver"), (int) (price*1.2));
		}else if(item == 2) {
			items.put(new Key("purple"), (int) (price*2));
		}else if(item == 3) {
			items.put(new Key("cyan"), (int) (price*1.8));
		}else if(item == 4) {
			items.put(new Key("bronze"), price);
		}else if(item == 5) {
			items.put(new Bomb(), (int) (price*1.5));
		}
		//TODO: not finished yet, add equipments
	}
}
