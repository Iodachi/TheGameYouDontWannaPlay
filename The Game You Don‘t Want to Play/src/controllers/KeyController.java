package controllers;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import character.InvalidMove;
import gui.GUI;


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
/*
		try {
			switch (e.getKeyChar()) {
			case 'w':gui.player.move("up"); break;
			case 'a':gui.player.move("right"); break;
			case 's':gui.player.move("down"); break;
			case 'd':gui.player.move("left"); break;
			}
		} catch (InvalidMove e1) {
			//e1.printStackTrace();
		}
		*/
	}

}
