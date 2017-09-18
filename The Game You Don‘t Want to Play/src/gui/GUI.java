package gui;

import java.util.Observable;

import main.Game;
import view.View;


public class GUI extends Observable{

	
	public Game game = new Game();

	
	public GUI() {
		
		
		new View(this);
		
	}

	public void update() {
		
	}
	
}
