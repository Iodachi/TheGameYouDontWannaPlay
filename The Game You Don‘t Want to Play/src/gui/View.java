package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import character.Player;
import controllers.*;


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
	public static final int TILESIZE = 64;
	
	private JPanel equipmentsPanel;
	private JPanel characterPanel;

	private GUI gui;
	
	public View(GUI gui) {
		// setting attribute for this view
		this.gui=gui;
		this.gui.addObserver(this);
	    this.setFocusable(true); 
	    this.setPreferredSize(getPreferredSize());
	    
	    // create UI for the main 
	    equipmentsPanel = new EquipmentsPanel();
	    equipmentsPanel.setSize(new Dimension(getPreferredSize()));
	    //equipmentsPanel.setBackground();
	    characterPanel = new CharacterPanel();
	    characterPanel.setSize(new Dimension(getPreferredSize()));
	     
	    JPanel fl = new JPanel(new GridLayout(2,1));
		
	    fl.add(characterPanel);
	    fl.add(equipmentsPanel);
	    fl.setVisible(true);
	   
	    
	    JFrame f = new JFrame("The Game You Don't Want to Play");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(fl,BorderLayout.WEST);
		f.add(this,BorderLayout.EAST);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	
		addKeyListener(new KeyController(gui));
		addMouseListener(new MouseController(gui));
	}
	 public Dimension getPreferredSize() {return new Dimension((TILESIZE*12), TILESIZE*12);}

	@Override
	public void update(Observable o, Object arg) {
		//repaint();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		//drawMap(gui.map);
		//drawPlayer(gui.game,g);
		
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




