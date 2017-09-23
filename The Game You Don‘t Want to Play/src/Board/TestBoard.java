package Board;
import static org.junit.Assert.*;
import org.junit.Test;
import character.*;
import item.*;


public class TestBoard {

	@Test
	public void testPrintCurrentLevel() {
		Board temp = new Board();
		temp.GetCurrentLevel().Print();
		System.out.println("");
		temp.GetCurrentLevel().Print1();
	}

	@Test
	public void testPrintAllLevel() {
		Board temp = new Board();
		for(Level tLevel : temp.GetAllLevel()){
			System.out.println("");
			tLevel.Print();
			System.out.println("");
			tLevel.Print1();
		}
	}

	/**
	 * test cast item contain item and pick item
	 */
	@SuppressWarnings({ "rawtypes" })
	@Test
	public <T> void testCast01(){
		Ground k1 = new Ground(30,0,0,0);
		assertTrue(k1.GetWhatContain() instanceof Key);
		k1.PickItem();
		assertNull(k1.GetWhatContain());
		assertEquals(k1.GetCode(), 00);
		Ground k2 = new Ground(31,0,0,0);
		assertTrue(k2.GetWhatContain() instanceof Key);
		Ground k3 = new Ground(32,0,0,0);
		assertTrue(k3.GetWhatContain() instanceof Key);
		Ground k4 = new Ground(33,0,0,0);
		assertTrue(k4.GetWhatContain() instanceof Key);
		Ground k5 = new Ground(34,0,0,0);
		assertTrue(k5.GetWhatContain() instanceof Key);
		
		Ground BB = new Ground(40,0,0,0);
		assertTrue(BB.GetWhatContain() instanceof BloodVial);
		BB.PickItem();
		assertNull(BB.GetWhatContain());
		assertEquals(BB.GetCode(), 00);
		Ground SB = new Ground(41,0,0,0);
		assertTrue(SB.GetWhatContain() instanceof BloodVial);
		Ground AR = new Ground(42,0,0,0);
		assertTrue(AR.GetWhatContain() instanceof Armor);
		Ground BM = new Ground(43,0,0,0);
		assertTrue(BM.GetWhatContain() instanceof Bomb);
		Ground WP = new Ground(44,0,0,0);
		assertTrue(WP.GetWhatContain() instanceof Weapon);
		Ground WG = new Ground(45,0,0,0);
		assertTrue(WG.GetWhatContain() instanceof Wing);
		
		Ground gg = new Ground(00,0,0,0);
		assertNull(gg.GetWhatContain());
		Ground gl = new Ground(01,0,0,0);
		assertNull(gl.GetWhatContain());
		
	
	}

	/**
	 * test create wiseman cast wiseman and kill wiseman
	 */
	@SuppressWarnings({ "rawtypes"})
	@Test
	public <T> void testCast02(){
		Ground w0 = new Ground(03,0,0,0);
		assertTrue(w0.GetWhatContain() instanceof WiseMan);
		w0.KillWiseMan();
		assertNull(w0.GetWhatContain());
		assertEquals(w0.GetCode(), 00);
		Ground w1 = new Ground(04,0,0,0);
		assertTrue(w1.GetWhatContain() instanceof WiseMan);
		Ground w2 = new Ground(05,0,0,0);
		assertTrue(w2.GetWhatContain() instanceof WiseMan);
	}
	
	/**
	 * test create monster cast monster kill monster
	 */
	@SuppressWarnings({ "rawtypes" })
	@Test
	public <T> void testCast03(){
		Ground t1 = new Ground(91,0,0,0);
		assertTrue(t1.GetWhatContain() instanceof Monster);
		t1.CleanBattleground();
		assertNull(t1.GetWhatContain());
		assertEquals(t1.GetCode(), 00);
		Ground t2 = new Ground(92,0,0,0);
		assertTrue(t2.GetWhatContain() instanceof Monster);
		Ground t3 = new Ground(93,0,0,0);
		assertTrue(t3.GetWhatContain() instanceof Monster);
		Ground t4 = new Ground(94,0,0,0);
		assertTrue(t4.GetWhatContain() instanceof Monster);
		Ground t5 = new Ground(95,0,0,0);
		assertTrue(t5.GetWhatContain() instanceof Monster);
		Ground t6 = new Ground(96,0,0,0);
		assertTrue(t6.GetWhatContain() instanceof Monster);
		Ground t7 = new Ground(97,0,0,0);
		assertTrue(t7.GetWhatContain() instanceof Monster);
		Ground t8 = new Ground(98,0,0,0);
		assertTrue(t8.GetWhatContain() instanceof Monster);
	}
	
	/**
	 * test create shop/temple cast shop/temple close shop/temple
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public <T> void testCast04(){
		Level l = new Level(0);
		Ground ST0 = new Ground(60,0,0,0);
		ST0.SetShopOrTemple((T) l.getShop0());
		assertTrue(ST0.GetWhatContain() instanceof Shop);
		ST0.CloseShop();
		assertNull(ST0.GetWhatContain());
		assertEquals(ST0.GetCode(), 00);
		Ground ST1 = new Ground(61,0,0,0);
		ST1.SetShopOrTemple((T) l.getShop1());
		assertTrue(ST1.GetWhatContain() instanceof Shop);
		Ground ST2 = new Ground(62,0,0,0);
		ST2.SetShopOrTemple((T) l.getShop2());
		assertTrue(ST2.GetWhatContain() instanceof Shop);
		
		Ground TT0 = new Ground(65,0,0,0);
		TT0.SetShopOrTemple((T) l.getTemple0());
		assertTrue(TT0.GetWhatContain() instanceof Temple);
		TT0.CloseTemple();
		assertNull(TT0.GetWhatContain());
		assertEquals(TT0.GetCode(), 00);
		Ground TT1 = new Ground(66,0,0,0);
		TT1.SetShopOrTemple((T) l.getTemple1());
		assertTrue(TT1.GetWhatContain() instanceof Temple);
		Ground TT2 = new Ground(67,0,0,0);
		TT2.SetShopOrTemple((T) l.getTemple2());
		assertTrue(TT2.GetWhatContain() instanceof Temple);
	}
	
}
