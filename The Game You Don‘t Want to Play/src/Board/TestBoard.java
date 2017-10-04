package Board;
import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;
import character.*;
import item.*;


public class TestBoard {

	@Test
	public void testPrintCurrentLevel() {
		Board temp = new Board();
		//System.out.println(temp.GetCurrentLevel().toString());
	}


	@Test
	public void testLoadLevel() {
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 01 01 01 01 30 01 01 01 01 01 00\n"
				+	" 00 01 01 01 01 30 01 01 00 00 00 00\n"
				+	" 00 01 01 01 01 30 01 01 00 01 01 01\n"
				+	" 00 01 01 01 00 30 00 01 00 00 00 00\n"
				+	" 00 01 01 01 00 01 00 01 01 01 01 00\n"
				+	" 00 01 01 01 00 01 00 01 00 00 00 00\n"
				+	" 00 01 01 01 00 00 00 01 00 01 01 01\n"
				+	" 00 01 01 01 01 93 01 01 00 00 00 00\n"
				+	" 00 01 01 01 01 30 01 01 01 01 01 00\n"
				+	" 00 01 01 01 01 43 01 00 00 00 00 00\n"
				+	" 00 00 00 00 00 51 01 00 01 01 01 01\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test02 = new Board(sc);
			String save = test02.toString();
			load = load + "\n";
			assertEquals(load,save);
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}

	
		
	}


	/**
	 * test cast item contain item and pick item
	 */
	@SuppressWarnings({ "rawtypes" })
	@Test
	public <T> void testCast01(){
		Ground k1 = new Ground(30,0,0,0);
		assertTrue(k1.getWhatContain() instanceof Key);
		k1.pickItem();
		assertNull(k1.getWhatContain());
		assertEquals(k1.getCode(), 00);
		Ground k2 = new Ground(31,0,0,0);
		assertTrue(k2.getWhatContain() instanceof Key);
		Ground k3 = new Ground(32,0,0,0);
		assertTrue(k3.getWhatContain() instanceof Key);
		Ground k4 = new Ground(33,0,0,0);
		assertTrue(k4.getWhatContain() instanceof Key);
		Ground k5 = new Ground(34,0,0,0);
		assertTrue(k5.getWhatContain() instanceof Key);

		Ground BB = new Ground(40,0,0,0);
		assertTrue(BB.getWhatContain() instanceof BloodVial);
		BB.pickItem();
		assertNull(BB.getWhatContain());
		assertEquals(BB.getCode(), 00);
		Ground SB = new Ground(41,0,0,0);
		assertTrue(SB.getWhatContain() instanceof BloodVial);
		Ground AR = new Ground(42,0,0,0);
		assertTrue(AR.getWhatContain() instanceof Armor);
		Ground BM = new Ground(43,0,0,0);
		assertTrue(BM.getWhatContain() instanceof Bomb);
		Ground WP = new Ground(44,0,0,0);
		assertTrue(WP.getWhatContain() instanceof Weapon);
		Ground WG = new Ground(45,0,0,0);
		assertTrue(WG.getWhatContain() instanceof Wing);

		Ground gg = new Ground(00,0,0,0);
		assertNull(gg.getWhatContain());
		Ground gl = new Ground(01,0,0,0);
		assertNull(gl.getWhatContain());


	}

	/**
	 * test create wiseman cast wiseman and kill wiseman
	 */
	@SuppressWarnings({ "rawtypes"})
	@Test
	public <T> void testCast02(){
		Ground w0 = new Ground(03,0,0,0);
		assertTrue(w0.getWhatContain() instanceof WiseMan);
		w0.killWiseMan();
		assertNull(w0.getWhatContain());
		assertEquals(w0.getCode(), 00);
		Ground w1 = new Ground(04,0,0,0);
		assertTrue(w1.getWhatContain() instanceof WiseMan);
		Ground w2 = new Ground(05,0,0,0);
		assertTrue(w2.getWhatContain() instanceof WiseMan);
	}

	/**
	 * test create monster cast monster kill monster
	 */
	@SuppressWarnings({ "rawtypes" })
	@Test
	public <T> void testCast03(){
		Ground t1 = new Ground(91,0,0,0);
		assertTrue(t1.getWhatContain() instanceof Monster);
		t1.cleanBattleground();
		assertNull(t1.getWhatContain());
		assertEquals(t1.getCode(), 00);
		Ground t2 = new Ground(92,0,0,0);
		assertTrue(t2.getWhatContain() instanceof Monster);
		Ground t3 = new Ground(93,0,0,0);
		assertTrue(t3.getWhatContain() instanceof Monster);
		Ground t4 = new Ground(94,0,0,0);
		assertTrue(t4.getWhatContain() instanceof Monster);
		Ground t5 = new Ground(95,0,0,0);
		assertTrue(t5.getWhatContain() instanceof Monster);
		Ground t6 = new Ground(96,0,0,0);
		assertTrue(t6.getWhatContain() instanceof Monster);
		Ground t7 = new Ground(97,0,0,0);
		assertTrue(t7.getWhatContain() instanceof Monster);
		Ground t8 = new Ground(98,0,0,0);
		assertTrue(t8.getWhatContain() instanceof Monster);
	}

	/**
	 * test create shop/temple cast shop/temple close shop/temple
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public <T> void testCast04(){
		Level l = new Level(0);
		Ground ST0 = new Ground(60,0,0,0);
		assertTrue(ST0.getWhatContain() instanceof Shop);

		Ground TT0 = new Ground(65,0,0,0);
		TT0.setShopOrTemple((T) new Temple());
		assertTrue(TT0.getWhatContain() instanceof Temple);
		TT0.closeTemple();
		assertNull(TT0.getWhatContain());
		assertEquals(TT0.getCode(), 00);
		Ground TT1 = new Ground(66,0,0,0);
		TT1.setShopOrTemple((T) new Temple());
		assertTrue(TT1.getWhatContain() instanceof Temple);
		Ground TT2 = new Ground(67,0,0,0);
		TT2.setShopOrTemple((T) new Temple());
		assertTrue(TT2.getWhatContain() instanceof Temple);
	}
	
	/**
	 * to test can pick any items in any position of the board
	 */
	@Test
	public <T> void testCast05(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	" 30 31 32 33 34 40 41 72 43 48 74 73\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					//System.out.printf("i: %d,j: %d: ",i,j);
					assertTrue(l.pickItem(i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}
	
	/**
	 * to test can pick any items in any position of the board
	 */
	@Test
	public <T> void testCast06(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	" 00 01 02 03 04 05 06 10 11 20 21 67\n"
				+	" 22 23 24 98 91 92 93 94 51 52 65 66\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					//System.out.printf("i: %d,j: %d: \n",i,j);
					assertTrue(!l.pickItem(i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}
	
	@Test
	public <T> void testCast07(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	" 11 11 11 11 11 11 11 11 11 11 11 11\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					
					assertTrue(l.breakWall(i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}
	
	@Test
	public <T> void testCast10(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	" 10 10 10 10 10 10 10 10 10 10 10 10\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					assertTrue(!l.breakWall(i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}
	
	@Test
	public <T> void testCast11(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					assertTrue(!l.openTheDoor( i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}
	
	@Test
	public <T> void testCast12(){
		String load = "( 1 )\n"
				+   "l 1 (\n" 
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	" 20 21 23 24 22 20 21 23 24 22 20 21\n"
				+	")\n";
		try{
			Scanner sc = new Scanner(load);
			Board test = new Board(sc);
			Level l = test.getCurrentLevel();
			for(int i =0; i<12; i++) {
				for(int j = 0; j<12; j++) {
					assertTrue(l.openTheDoor( i, j));
				}
			}
		}catch (java.util.InputMismatchException e){
			System.out.println(e);
		}
	}


}
