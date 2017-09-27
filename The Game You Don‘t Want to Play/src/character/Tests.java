package character;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import item.BloodVial;
import item.Bomb;
import main.InvalidMove;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	private Player player;
	private Bomb bomb = new Bomb();
	private BloodVial health = new BloodVial("small");
	
	@Test
	public void test01_playerPicksConsumables() {
		player = new Player();
		try {
			player.addItem(bomb);
			assertTrue(player.getInventory().contains(bomb));
		} catch (InvalidMove e) {
			fail("Should be able to pick up bomb.");
		}
	}
	
	@Test
	public void test02_playerPicksConsumbalesInventoryFull() {
		player = new Player();
		try {
			for(int i = 0; i < Player.INVENTORY_CAPACITY; i++) {
				player.addItem(new Bomb(0,0));
			}
			
			player.addItem(bomb);
			fail("Should not be able to pick up bomb since inventory is full.");
			assertFalse(player.getInventory().contains(bomb));
		} catch (InvalidMove e) {
			//ok
		}
	}
	
	@Test
	public void test03_playerUseHealthPotion() throws InvalidMove {
		player = new Player();
		player.addItem(health);
		int healthBefore = player.getHealth();
		int amount = health.getAmount();
		player.useHealth("small");
		assertEquals(healthBefore + amount, player.getHealth());
	}
}
