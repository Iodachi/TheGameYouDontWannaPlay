package item;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	

}
