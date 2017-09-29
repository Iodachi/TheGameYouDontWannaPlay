package controllers;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.View;

/**
 * This class is used to implement the key listener
 * */
public class KeyController implements KeyListener {

	private View view;

	public KeyController(View view) {
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		try {
			switch (e.getKeyChar()) {
			case 'w':
				view.getGame().move("up");
				break;
			case 'a':
				view.getGame().move("left");
				break;
			case 's':
				view.getGame().move("down");
				break;
			case 'd':
				view.getGame().move("right");
				break;
			case 'e':
				view.getGame().tryBomb();
				break;
			case 'q':
				view.getGame().tryPickEquipment();
				break;
			case 'k':
				view.getGame().save();
			break;
			default:
				break;
			}
		} catch (main.InvalidMove invalidMove) {
			System.out.println(invalidMove.getMessage());
		}
		if(e.getKeyCode()==27) {
			this.view.gameStop();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
