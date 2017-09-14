package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	}
}
