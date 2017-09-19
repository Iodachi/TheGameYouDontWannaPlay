package gui;

import main.Game;

import java.util.Observable;


public class GUI extends Observable{

	
	private Game game = new Game();

	public Game getGame() {
		return game;
	}


	public GUI() {

		
		new View(this);
		
	}

	public void update() {
		
	}
	
}
