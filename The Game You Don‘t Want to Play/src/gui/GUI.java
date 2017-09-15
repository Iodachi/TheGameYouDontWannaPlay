package gui;

import java.util.Observable;
import view.View;


public class GUI extends Observable{

	//Player;
	//Map;
	
	
	public GUI() {
		
		new View(this);
	
		
	}
	
}
