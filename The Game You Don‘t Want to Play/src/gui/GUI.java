package gui;

import java.util.Observable;
import view.View;


public class GUI extends Observable{

	
	public GUI() {
		
		new View(this);
	
		
	}
	
}
