package Board;

import org.junit.Test;

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

}
