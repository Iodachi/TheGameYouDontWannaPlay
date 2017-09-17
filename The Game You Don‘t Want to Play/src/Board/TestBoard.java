package Board;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoard {

	@Test
	public void test() {
		Board temp = new Board();
		temp.GetCurrentLevel().Print();
	}

}
