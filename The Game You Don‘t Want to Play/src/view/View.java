package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import character.Player;
import controllers.*;
import gui.GUI;
import resources.PlayerResources;

/**
 * 
 * This is View class for the GUI
 * To do rendering, to paint our all the components, includes Players, Maps ect 
 * 
 * @author ZhanCheng Gan
 *
 */

public class View extends JComponent implements Observer{

	
	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;

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
		//drawMap(gui.map);
		drawPlayer(gui.player,g);
		
	}

	private void drawPlayer(Player player, Graphics g) {
		int x = player.getXPos()*TILESIZE+16;
		int y = player.getYPos()*TILESIZE+16;
		
		/*
		switch(player.face) {
		case "up": PlayerResources.Up.image.paintIcon(null, g, x, y); break;
		case "down": PlayerResources.Down.image.paintIcon(null, g, x, y); break;
		case "right": PlayerResources.Right.image.paintIcon(null, g, x, y); break;
		case "left": PlayerResources.Left.image.paintIcon(null, g, x, y); break;
		default: break;
		}
		*/
		
	}
	

}
