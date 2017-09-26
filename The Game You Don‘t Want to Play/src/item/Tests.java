package item;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.validator.TestClassValidator;

import character.Player;

//@author minping
public class Tests {

	// This test case is used to check the method of setAttributes for armor class
	@Test
	public void testSetAttributes1() {
		Armor armor = new Armor(0, 0, 0);
		assertEquals(armor.getName(), "42");
		assertEquals(armor.getDefence(), 500);
		armor = new Armor(0, 0, 1);
		assertEquals(armor.getName(), "25");
		assertEquals(armor.getDefence(), 1000);
		armor = new Armor(0, 0, 2);
		assertEquals(armor.getName(), "26");
		assertEquals(armor.getDefence(), 2000);
	}

	// This test case is used to check the method of setAttributes for Weapon class
	@Test
	public void testSetAttributes2() {
		Weapon weapon = new Weapon(0, 0, 0);
		assertEquals(weapon.getName(), "44");
		assertEquals(weapon.getAttack(), 500);
		weapon = new Weapon(0, 0, 1);
		assertEquals(weapon.getName(), "35");
		assertEquals(weapon.getAttack(), 1000);
		weapon = new Weapon(0, 0, 2);
		assertEquals(weapon.getName(), "36");
		assertEquals(weapon.getAttack(), 2000);
	}

	// This test case is used to check the method of setAttributes for Wing class
	@Test
	public void testSetAttributes3() {
		Wing wing = new Wing(0, 0, 0);
		assertEquals(wing.getName(), "45");
		assertEquals(wing.getSpeedFactor(), 2);
		wing = new Wing(0, 0, 1);
		assertEquals(wing.getName(), "46");
		assertEquals(wing.getSpeedFactor(), 3);
		wing = new Wing(0, 0, 2);
		assertEquals(wing.getSpeedFactor(), 4);
		assertEquals(wing.getName(), "47");
	}

	// This test case is used to check the method of use for BloodVial class
	@Test
	public void testUse1() {
		BloodVial bloodVial = new BloodVial(0, 0, "small");
		Player player = new Player();
		int amount = bloodVial.getAmount() / 2;
		int initialHealth = player.getHealth();
		bloodVial.use(player);
		assertEquals(initialHealth + amount, player.getHealth());
	}

	// This test case is used to check the method of use for BloodVial class
	@Test
	public void testUse2() {
		BloodVial bloodVial = new BloodVial(0, 0, "big");
		Player player = new Player();
		int amount = bloodVial.getAmount();
		int initialHealth = player.getHealth();
		bloodVial.use(player);
		assertEquals(initialHealth + amount, player.getHealth());
	}

	// This test case is used to check the genreateName method for key class
	@Test
	public void testGenerateName() {
		Key key = new Key("gold");
		assertEquals("30", key.getName());
		key = new Key("silver");
		assertEquals("34", key.getName());
		key = new Key("purple");
		assertEquals("33", key.getName());
		key = new Key("cyan");
		assertEquals("31", key.getName());
		key = new Key("bronze");
		assertEquals("32", key.getName());
	}

	// This test case is used to test if the player try to put on the weapon, then
	// the player's attribute should be changed
	@Test
	public void testValidPutOn() {
		Player player = new Player();
		int initalDamage = player.getDamage();
		Weapon weapon = new Weapon(0, 0, 0);
		weapon.putOn(player);
		assertEquals(true, weapon.getIsoN());
		assertEquals(initalDamage + weapon.getAttack(), player.getDamage());
	}

	// This case case is used test if the player already wear a weapon, the the
	// player try to take off the weapon.After
	// the player take off the weapon, the player' damages should also be decreased
	@Test
	public void testValidTakeOff() {
		Player player = new Player();
		int initalDamage = player.getDamage();
		Weapon weapon = new Weapon(0, 0, 0);
		weapon.putOn(player);
		assertEquals(true, weapon.getIsoN());
		assertEquals(initalDamage + weapon.getAttack(), player.getDamage());
		weapon.takeOff(player);
		assertEquals(false, weapon.getIsoN());
		assertEquals(initalDamage, player.getDamage());
	}

	// This test case is used to test if the player have not wear the weapon, then
	// the player can not take off the weapon
	@Test
	public void testInvalidTakeOff() {
		Player player = new Player();
		int initalDamage = player.getDamage();
		Weapon weapon = new Weapon(0, 0, 0);
		weapon.takeOff(player);
		assertEquals(false, weapon.getIsoN());
		assertEquals(initalDamage, player.getDamage());
	}

	// this test case is used to test if the player already wear weapon, the player
	// cannot wear two weapons at same time
	@Test
	public void testInvalidPutOn() {
		Player player = new Player();
		Weapon weapon = new Weapon(0, 0, 0);
		weapon.putOn(player);
		assertEquals(true, weapon.getIsoN());
		int initalDamage = player.getDamage();
		weapon.putOn(player);
		assertEquals(true, weapon.getIsoN());
		assertEquals(initalDamage, player.getDamage());
	}

	// this test case is used to test the "use" method for FateCoin class
	@Test
	public void testUse3() {
		Player player = new Player();
		FateCoin fateCoin = new FateCoin(0, 0);
		int initialHealth = player.getHealth();
		fateCoin.use(player);
		int randomNumber = fateCoin.getRandomNumber();
		if (randomNumber < 5) {
			assertEquals(initialHealth - fateCoin.getAmount(), player.getHealth());
		} else {
			assertEquals(initialHealth + fateCoin.getAmount(), player.getHealth());
		}
	}

	// this test case is used to test if putOn method for Wing class
	@Test
	public void testValidPutOn2() {
		Player player = new Player();
		int initalSpeed = player.getSpeed();
		Wing wing = new Wing(0, 0, 0);
		wing.putOn(player);
		assertEquals(true, wing.getIsOn());
		assertEquals(initalSpeed * wing.getSpeedFactor(), player.getSpeed());
	}
	//this test case is used to test if the player has not wear the wing, then just directly want to take off the wing.Which is invalid
	//take off
	@Test
	public void testInValidTakeOff2() {
		Player player = new Player();
		int initialSpeed = player.getSpeed();
		Wing wing = new Wing(0, 0, 0);
		wing.takeOff(player);
		assertEquals(false, wing.getIsOn());
		assertEquals(initialSpeed, player.getSpeed());
	}

	// This case case is used to test if the player already wear a wing, then the
	// player try to take off the wing.After
	// the player take off the wing, the player's speed should also be decreased
	@Test
	public void testValidTakeOff2() {
		Player player = new Player();
		Wing wing = new Wing(0, 0, 0);
		int initialSpeed = player.getSpeed();
		wing.putOn(player);
		assertEquals(true,wing.getIsOn());
		wing.takeOff(player);
		assertEquals(initialSpeed, player.getSpeed());
	}
	
	//This test case is used to test if the player has already wear wing, then the speed can not increase anymore.
	@Test
	public void testInValidPutOn2() {
		Player player = new Player();
		Wing wing  = new Wing(0, 0, 0);
		int initialSpeed= player.getSpeed();
		wing.putOn(player);
		wing.putOn(player);
		assertEquals(true,wing.getIsOn());
		assertEquals(initialSpeed*wing.getSpeedFactor(), player.getSpeed());
	}
	
	
}
