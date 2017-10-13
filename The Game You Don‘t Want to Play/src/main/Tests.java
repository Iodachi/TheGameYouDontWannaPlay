package main;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import character.Player;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	@Test
	public void test01_gameCreated() {
		Game game = new Game();
	}
	
	@Test
	public void test02_playerMovement() throws InvalidMove {
		Game game = new Game();
		Player player = game.getPlayer();
		int xPos = player.getXPos();
		int yPos = player.getYPos();
		game.getPlayer().move("right");
		int newXPos = player.getXPos();
		int newYPos = player.getYPos();
		
		assertEquals(xPos+1, newXPos);
		assertEquals(yPos, newYPos);
	}
}
