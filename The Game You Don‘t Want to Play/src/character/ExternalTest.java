package character;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import item.Armor;
import item.BloodVial;
import item.FateCoin;
import item.Item;
import item.Key;
import item.MockPlayer;
import main.Game;
import main.InvalidMove;

/***
 * @author minping yang
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
	//Test defeated method 
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
		assertEquals(true, initialHealth != player.getHealth());

	}
	

	@Test
	public void testInvalidUseFateCoin() {
		Player player = new Player();
		int initialHealth = player.getHealth();
		int initialSize = player.getInventory().size();
		try {
			player.useFateCoin();
		} catch (InvalidMove e) {
		}
		assertEquals(initialSize, player.getInventory().size());
		assertEquals(false, initialHealth != player.getHealth());
	}

	@Test
	public void testMoveLeftRight() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialX = player.getXPos();

		try {
			player.move("right");
			assertEquals(initialX + 1, player.getXPos());
			player.move("left");
			player.move("left");
			assertEquals(initialX - 1, player.getXPos());
		} catch (InvalidMove e) {

		}
	}
	@Test
	public void testInvalidMoveLeft() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialX = player.getXPos();
		try {
			for (int i = 0; i < 20; i++) {
				player.move("left");
			}
			assertEquals(initialX - 5, player.getXPos());
		} catch (InvalidMove e) {

		}
	}
	@Test
	public void testInvalidMoveUp() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialX = player.getXPos();
		try {
			for (int i = 0; i < 20; i++) {
				player.move("right");
			}
			assertEquals(initialX + 5, player.getXPos());
		} catch (InvalidMove e) {

		}
	}
	@Test
	public void testValidMoveUp() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialY = player.getYPos();

		try {
			player.move("down");
			assertEquals(initialY + 1, player.getYPos());
			player.move("up");
			assertEquals(initialY, player.getYPos());
		} catch (InvalidMove e) {

		}
	}

	@Test
	public void testInValidMoveUp() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialY = player.getYPos();
		try {
			player.move("up");
			assertEquals(initialY, player.getYPos());
		} catch (InvalidMove e) {

		}
	}

	@Test
	public void testInValidMoveDown() {
		Game game = new Game();
		Player player = game.getPlayer();
		int initialY = player.getYPos();
		try {
			for (int i = 0; i < 10; i++) {
				player.move("down");
			}

			assertEquals(initialY + 4, player.getYPos());
		} catch (InvalidMove e) {

		}
	}

	@Test
	public void testBuyItem() throws InvalidMove {
		Player player = new Player();
		player.setGold(10000);
		Shop shop = new Shop();
		Set<Item> items = shop.getItems().keySet();
		Item tempitem = null;
		for (Item item : items) {
			tempitem = item;
		}
		shop.buyItem(tempitem, player);
		assertEquals(2, items.size());
		assertEquals(false, player.getGold() == 10000);

	}

	@Test
	public void testInvalidBuyItem() {
		Player player = new Player();
		player.setGold(0);
		Shop shop = new Shop();
		Set<Item> items = shop.getItems().keySet();
		for (Item item : items) {
			try {
				shop.buyItem(item, player);
			} catch (InvalidMove e) {

			}
		}
		assertEquals(3, items.size());
		assertEquals(true, player.getGold() == 0);

	}

	@Test
	public void testGiveEquipment() {
		Armor armor = new Armor(1);
		WiseMan wiseMan = new WiseMan(armor);
		Player player = new Player();
		try {
			assertEquals(false, armor.getIsOn());
			wiseMan.give(player);
			assertEquals(true, armor.getIsOn());

		} catch (InvalidMove e) {
		}
	}

	@Test
	public void testGiveBlood() {
		BloodVial bloodVial = new BloodVial("big");
		WiseMan wiseMan = new WiseMan(bloodVial);
		Player player = new Player();
		try {
			wiseMan.give(player);
			assertEquals(1, player.getInventory().size());
		} catch (InvalidMove e) {
		}
	}
	@Test
	public void testBoostHealth() {
		Temple temple=new Temple();
		Player player =new Player();
		int health = player.getHealth();
		temple.boost("health", player);
		assertEquals(health+temple.getBoosts().get("health"), player.getHealth());
		
	}
	@Test
	public void testBoostDamage() {
		Temple temple=new Temple();
		Player player =new Player();
		int dmg = player.getDamage();
		temple.boost("damage", player);
		assertEquals(dmg+temple.getBoosts().get("damage"), player.getDamage());
	}
	
	@Test
	public void testBoostDefence() {
		Temple temple=new Temple();
		Player player =new Player();
		int def = player.getDefence();
		temple.boost("defence", player);
		assertEquals(def+temple.getBoosts().get("defence"), player.getDefence());
	}
	
	
}
