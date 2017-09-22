package Board;

import org.junit.Test;

public class TestBoard {

	@Test
	public void test() {
		Board temp = new Board();
		temp.GetCurrentLevel().Print();
		System.out.println("");
		temp.GetCurrentLevel().Print1();
	}

}
