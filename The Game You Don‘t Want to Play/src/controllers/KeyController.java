package controllers;

import main.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to implement the key listener
 * */
public class KeyController implements KeyListener {

	private Game game;

	public KeyController(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	    {
			//TODO - BACK TO MENU
	       System.out.println("back to menu");
	    }
		try {
			switch (e.getKeyChar()) {
			case 'w':
				game.move("up");
				break;
			case 'a':
				game.move("left");
				break;
			case 's':
				game.move("down");
				break;
			case 'd':
				game.move("right");
				break;
			case 'e':
				game.tryBomb();
				break;
			case 'q':
				game.tryPickEquipment();
				break;
			case 'k':
			   game.save();
			break;
			
			default:
				break;
			}
		} catch (main.InvalidMove invalidMove) {
			//invalidMove.printStackTrace();
			System.out.println(invalidMove.getMessage());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
