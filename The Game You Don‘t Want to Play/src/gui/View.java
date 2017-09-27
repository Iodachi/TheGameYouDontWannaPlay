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

	private JPanel bagPanel;
	private JPanel characterPanel;
	private JPanel dialogPanel;
	

	private Game game;

	public View(Game game) {
		// setting attribute for this view
		game.addObserver(this);
		this.game = game;
		this.setFocusable(true);
		this.setPreferredSize(getPreferredSize());
		this.addKeyListener(new KeyController(game));
		this.addMouseListener(new MouseController(this));

		// create UI for the main
		bagPanel = new BagPanel(this.game);
		bagPanel.addMouseListener(new MouseController(this));
		bagPanel.setSize(new Dimension(getPreferredSize()));
			
		characterPanel = new CharacterPanel(this.game);
		characterPanel.addMouseListener(new MouseController(this));
		characterPanel.setSize(new Dimension(getPreferredSize()));
		
		dialogPanel = new DialogPanel();
		dialogPanel.setSize(new Dimension(getPreferredSize()));

		// set GridLayout for fl
		JPanel fl = new JPanel(new GridLayout(2, 1));
		fl.add(characterPanel);
		fl.add(bagPanel);
		fl.setVisible(true);

		JFrame f = new JFrame("The Game You Don't Want to Play");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(fl, BorderLayout.WEST);
		f.add(this, BorderLayout.CENTER);
		f.add(dialogPanel,BorderLayout.EAST);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);

		
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
		drawFloor(g);
		drawMap(game.getBoard(), g);
		drawPlayer(game.getPlayer(), g);

	}

	private void drawMap(Board board, Graphics g) {
		

		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {
				
				int py =y * TILESIZE;
				int px =x * TILESIZE;
				int code=0;
				
				try {
				if(board.GetCurrentLevel().GetEntityAt(x, y)!=null) {
					code = board.GetCurrentLevel().GetEntityAt(x, y).GetCode();
					if(code>=90&&code<100) {
						py+=16;
						px+=16;
					}
				
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/"+code+".png"));
				img.paintIcon(null, g, py,px);
				}
				if(code==60)y+=1;
				}catch(NullPointerException e) {
					
					System.err.println("NullPointerException: image unfind" + code);
				}
			}
		}

	}

	private void drawFloor(Graphics g) {
		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/0.png"));
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
	public JPanel getBagPanel() {
		return bagPanel;
	}

	public JPanel getCharacterPanel() {
		return characterPanel;
	}

	public JPanel getDialogPanel() {
		return dialogPanel;
	}

	public Game getGame() {
		return game;
	}

}
