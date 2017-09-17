package gui;

import java.util.Observable;

import character.Player;
import view.View;


public class GUI extends Observable{

	public Player player;
	//Map;
	
	
	public GUI() {
		player = new Player("Warrior");
		
		new View(this);
	
		
	}
	
}
