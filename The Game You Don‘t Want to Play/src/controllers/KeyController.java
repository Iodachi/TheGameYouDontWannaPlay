package controllers;

import gui.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to implement the key listener
 * */
public class KeyController implements KeyListener {

	GUI gui;

	public KeyController(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		try {
			switch (e.getKeyChar()) {
			case 'w':
				gui.getGame().getPlayer().move("up");
				gui.getGame().getPlayer().setFaceDirection("up");
				break;
			case 'a':
				gui.getGame().getPlayer().move("right");
				gui.getGame().getPlayer().setFaceDirection("right");
				break;
			case 's':
				gui.getGame().getPlayer().move("down");
				gui.getGame().getPlayer().setFaceDirection("down");
				break;
			case 'd':
				gui.getGame().getPlayer().move("left");
				gui.getGame().getPlayer().setFaceDirection("left");
				break;
			}
		} catch (main.InvalidMove invalidMove) {
			invalidMove.printStackTrace();
		}
	}

}
