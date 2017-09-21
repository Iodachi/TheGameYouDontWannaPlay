package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Board.Board;
import Board.Level;
import character.Player;
import controllers.*;
import main.Game;
import resources.PlayerResources;

/**
 * 
 * This is View class for the GUI To do rendering, to paint our all the
 * components, includes Players, Maps ect
 * 
 * @author ZhanCheng Gan
 *
 */

public class View extends JComponent implements Observer {

	private static final long serialVersionUID = 1L;
	public static final int TILESIZE = 64;

	private JPanel bagPanelPanel;
	private JPanel characterPanel;

	private Game game;

	public View(Game game) {
		// setting attribute for this view
		this.game = game;
		game.addObserver(this);
		this.setFocusable(true);
		this.setPreferredSize(getPreferredSize());

		// create UI for the main
		bagPanelPanel = new BagPanel();
	
		bagPanelPanel.addMouseListener(new MouseController(game));
		bagPanelPanel.setSize(new Dimension(getPreferredSize()));
			
		characterPanel = new CharacterPanel();
		characterPanel.addMouseListener(new MouseController(game));
		characterPanel.setSize(new Dimension(getPreferredSize()));

		// set GridLayout for fl
		JPanel fl = new JPanel(new GridLayout(2, 1));
		fl.add(characterPanel);
		fl.add(bagPanelPanel);
		fl.setVisible(true);

		JFrame f = new JFrame("The Game You Don't Want to Play");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(fl, BorderLayout.WEST);
		f.add(this, BorderLayout.EAST);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);

		addKeyListener(new KeyController(game));
		addMouseListener(new MouseController(game));
	}

	public Dimension getPreferredSize() {
		return new Dimension((TILESIZE * 12), TILESIZE * 12);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		drawMap(game.board, g);
		drawPlayer(game.getPlayer(), g);

	}

	private void drawMap(Board board, Graphics g) {
		drawFloor(g);

		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {
				
				if(board.GetCurrentLevel().GetEntityAt(x, y)!=null) {
				String name = board.GetCurrentLevel().GetEntityAt(x, y).getName();
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/"+name+".png"));
				//System.out.printf("X: %s Y: %s Name: ",x,y,name);
				img.paintIcon(null, g, y * TILESIZE, x * TILESIZE);
				}
			}
		}
		// board.GetCurrentLevel().GetEntityAt(0,0)

	}

	private void drawFloor(Graphics g) {
		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/WL.png"));
				img.paintIcon(null, g, y * TILESIZE, x * TILESIZE);
			}
		}

	}

	private void drawPlayer(Player player, Graphics g) {
		int x = player.getXPos() * TILESIZE + 16;
		int y = player.getYPos() * TILESIZE + 16;

		switch (game.getPlayer().getFacingDirection()) {
		case "up":
			PlayerResources.Up.image.paintIcon(null, g, x, y);
			break;
		case "down":
			PlayerResources.Down.image.paintIcon(null, g, x, y);
			break;
		case "right":
			PlayerResources.Right.image.paintIcon(null, g, x, y);
			break;
		case "left":
			PlayerResources.Left.image.paintIcon(null, g, x, y);
			break;
		default:
			break;
		}

	}
}
