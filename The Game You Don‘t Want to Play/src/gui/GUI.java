package gui;

import java.util.Observable;

import main.Game;


public class GUI extends Observable{

	
	public Game game = new Game();

	
	public GUI() {
		
		
		new View(this);
		
	}

	public void update() {
		
	}
	
}
