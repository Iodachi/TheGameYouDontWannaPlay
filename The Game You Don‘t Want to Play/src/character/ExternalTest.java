package character;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import item.FateCoin;
import item.Item;
import item.Key;
import item.MockPlayer;
import main.Game;
import main.InvalidMove;

/***
 * @author minpingyang
 */
public class ExternalTest {

	@Test
	public void testInitialisation() {
		Monster monster = new Monster(1);
		double factor = monster.getFactor();
		assertEquals((int) (11 * factor), monster.getDamage());
		assertEquals((int) (100 * factor), monster.getHealth());
		assertEquals((int) (3 * factor), monster.getDefence());
	}

	@Test
	public void testDefeated() {
		Player player = new Player();
		Monster monster = new Monster(1);
		int initialGold = player.getGold();
		monster.defeated(player);
		assertEquals(initialGold + monster.getDrop(), player.getGold());
	}

	@Test
	public void testUseFateCoin() throws InvalidMove {
		Player player = new Player();
		player.addItem(new FateCoin(0, 0));
		int initialHealth = player.getHealth();
		int initialSize = player.getInventory().size();
		player.useFateCoin();
		assertEquals(initialSize - 1, player.getInventory().size());
		assertEquals(false, initialHealth != player.getHealth());

	}

	@Test
	public void testInvalidUseFateCoin() throws InvalidMove {
		Player player = new Player();
		player.addItem(new FateCoin(0, 0));
		int initialHealth = player.getHealth();
		int initialSize = player.getInventory().size();
		player.useFateCoin();
		assertEquals(initialSize, player.getInventory().size());
		assertEquals(true, initialHealth != player.getHealth());
	}

	@Test
	public void testMove() throws InvalidMove {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialX = player.getXPos();
		player.move("right");
		assertEquals(initialX + 1, player.getXPos());
		player.move("left");
		player.move("left");
		assertEquals(initialX - 1, player.getXPos());
		int initialY = player.getYPos();
		player.move("up");
		assertEquals(initialY - 1, player.getYPos());
		player.move("down");
		player.move("down");
		assertEquals(initialY + 1, player.getYPos());
	}
	@Test
	public void testBuyItem() throws InvalidMove {
		Player player=new Player();
		player.setGold(10000);
		Shop shop = new Shop();
		Set<Item> items = shop.getItems().keySet();
		for(Item item:items) {
			shop.buyItem(item, player);
		}
		assertEquals(0, items.size());
		assertEquals(false, player.getGold()==10000);
	
	}
	
}
