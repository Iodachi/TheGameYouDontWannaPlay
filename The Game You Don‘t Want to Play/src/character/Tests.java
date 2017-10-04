package character;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import item.Armor;
import item.BloodVial;
import item.Bomb;
import item.Key;
import item.Weapon;
import item.Wing;
import main.InvalidMove;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	private Player player;
	private Bomb bomb = new Bomb();
	private Key key = new Key("yellow");
	private Armor armor = new Armor(1);
	private Weapon weapon = new Weapon(1);
	private Wing wing = new Wing(1);
	private BloodVial health = new BloodVial("small");
	private Monster monster = new Monster(1);
	
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
		player.useHealthPotion("small");
		assertEquals(healthBefore + amount, player.getHealth());
	}
	
	@Test
	public void test04_playerUseHealthPotionNotHave() {
		player = new Player();
		try {
			player.useHealthPotion("small");
			fail("Should not be able to use health potion.");
		} catch (InvalidMove e) {
			//ok
		}
	}
	
	@Test
	public void test05_playerUseBomb() {
		player = new Player();
		try {
			player.addItem(bomb);
			player.useBomb();
			assertFalse(player.getInventory().contains(bomb));
			//ok
		} catch (InvalidMove e) {
			fail("fail to use bomb");
		}
	}
	
	@Test
	public void test06_playerUseBombNotHave() {
		player = new Player();
		try {
			player.useBomb();
			fail("Should not be able to use bomb.");
		} catch (InvalidMove e) {
			//ok
		}
	}
	
	@Test
	public void test07_playerUseKey() {
		player = new Player();
		try {
			player.addItem(key);
			player.useKey("yellow");
			assertFalse(player.getInventory().contains(key));
			//ok
		} catch (InvalidMove e) {
			fail("fail to use key");
		}
	}
	
	@Test
	public void test08_playerUseKeyColorNotMatch() {
		player = new Player();
		try {
			player.addItem(key);
			player.useKey("cyan");
			fail("Should not be able to use key");
		} catch (InvalidMove e) {
			//ok
		}
	}
	
	@Test
	public void test09_playerEquipArmor() {
		player = new Player();
		int prevDefence = player.getDefence();
		int boostDefence = armor.getDefence();
		player.equip(armor);
		assertEquals(player.getDefence(), prevDefence + boostDefence);
		assertTrue(player.getCurrentArmor() == armor);
	}
	
	@Test
	public void test10_playerChangeArmor() {
		player = new Player();
		player.equip(armor);
		int prevDefence = player.getDefence();
		int boostDefence = armor.getDefence();
		int basicDefence = prevDefence - boostDefence;
		Armor newArmor = new Armor(2);
		int newBoostDefence = newArmor.getDefence();
		player.equip(newArmor);
		assertEquals(player.getDefence(), basicDefence + newBoostDefence);
		assertTrue(player.getCurrentArmor() == newArmor);
	}
	
	@Test
	public void test11_playerEquipWeapon() {
		player = new Player();
		int prevDamage = player.getDamage();
		int boostDamage = weapon.getAttack();
		player.equip(weapon);
		assertEquals(player.getDamage(), prevDamage + boostDamage);
		assertTrue(player.getCurrentWeapon() == weapon);
	}
	
	@Test
	public void test12_playerChangeWeapon() {
		player = new Player();
		player.equip(weapon);
		int prevDamage = player.getDamage();
		int boostDamage = weapon.getAttack();
		int basicDamage = prevDamage - boostDamage;
		Weapon newWeapon = new Weapon(2);
		int newBoostDamage = newWeapon.getAttack();
		player.equip(newWeapon);
		assertEquals(player.getDamage(), basicDamage + newBoostDamage);
		assertTrue(player.getCurrentWeapon() == newWeapon);
	}
	
	@Test
	public void test13_playerEquipWing() {
		player = new Player();
		int prevDamage = player.getDamage();
		int prevDefence = player.getDefence();
		int boostDamage = wing.getIncreasedDamage();
		int boostDefence = wing.getIncreasedDefense();
		player.equip(wing);
		assertEquals(player.getDamage(), prevDamage + boostDamage);
		assertEquals(player.getDefence(), prevDefence + boostDefence);
		assertTrue(player.getCurrentWing() == wing);
	}
	
	@Test
	public void test14_playerChangeWing() {
		player = new Player();
		player.equip(wing);
		int prevDamage = player.getDamage();
		int boostDamage = wing.getIncreasedDamage();
		int basicDamage = prevDamage - boostDamage;
		
		int prevDefence = player.getDefence();
		int boostDefence = wing.getIncreasedDefense();
		int basicDefence = prevDefence - boostDefence;
		
		Wing newWing = new Wing(2);
		int newBoostDamage = newWing.getIncreasedDamage();
		int newBoostDefence = newWing.getIncreasedDefense();
		player.equip(newWing);
		assertEquals(player.getDamage(), basicDamage + newBoostDamage);
		assertEquals(player.getDefence(), basicDefence + newBoostDefence);
		assertTrue(player.getCurrentWing() == newWing);
	}
	
	@Test
	public void test15_playerAttackMonster() {
		
	}
	
	@Test
	public void test16_playerBuyItem() {
		
	}
	
	@Test
	public void test17_playerUseTemple() {
		
	}
}
