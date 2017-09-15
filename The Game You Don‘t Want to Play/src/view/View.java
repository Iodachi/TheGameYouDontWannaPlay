package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.*;
import gui.GUI;

public class View extends JComponent implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GUI gui;
	public View(GUI gui) {
		this.gui=gui;
		this.gui.addObserver(this);
	    this.setFocusable(true); 
	    JFrame f = new JFrame("The Game You Don't Want to Play");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.add(this);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(1400, 850);
		addKeyListener(new KeyController(gui));
		addMouseListener(new MouseController(gui));
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {
		
	}
	

}
