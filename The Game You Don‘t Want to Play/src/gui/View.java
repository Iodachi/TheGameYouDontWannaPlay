package gui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Board.*;
import character.Player;
import controllers.*;
import main.Game;
import resources.ImgResources;
import resources.PlayerResources;
import resources.SoundResources;

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
	private java.util.Timer timer = new java.util.Timer();
	private int ac = 0;

	private BagPanel bagPanel;
	private CharacterPanel characterPanel;
	private DialogPanel dialogPanel;

	private JButton Save;
	private JButton Load;
	private JButton Music;
	private JButton Quit;

	private boolean gameStop = false;
	private boolean MusicOn = false;

	private Game game;

	/**
	 * The Constructor of this view class to lay out the game frame add bag Panel
	 * characterPanel and dialogPanel add mouse listener and key listener for all
	 * panels
	 * 
	 * @param game
	 */

	public View(Game game) {
		// setting attribute for this view
		game.addObserver(this);
		this.game = game;
		this.setFocusable(true);
		this.setPreferredSize(getPreferredSize());
		this.addKeyListener(new KeyController(this));
		this.addMouseListener(new MouseController(this));

		// create UI for the main, add panels
		bagPanel = new BagPanel(this.game);
		bagPanel.addMouseListener(new MouseController(this));
		bagPanel.setSize(new Dimension(getPreferredSize()));

		characterPanel = new CharacterPanel(this.game);
		characterPanel.addMouseListener(new MouseController(this));
		characterPanel.setSize(new Dimension(getPreferredSize()));

		dialogPanel = new DialogPanel(this.game);
		dialogPanel.addMouseListener(new MouseController(this));
		dialogPanel.setSize(new Dimension(getPreferredSize()));

		// set GridLayout for fl
		JPanel fl = new JPanel(new GridLayout(2, 1));
		fl.add(characterPanel);
		fl.add(bagPanel);
		fl.setVisible(true);

		// add to the frame
		JFrame f = new JFrame("The Game You Don't Want to Play");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(fl, BorderLayout.WEST);
		f.add(this, BorderLayout.CENTER);
		f.add(dialogPanel, BorderLayout.EAST);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);

		addButton();

		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				if (ac == 200) {
					ac = 100;
				} else {
					ac = 200;
				}
				repaint();
			}

		}, 0, 500);

	}
	/**
	 * added all the buttons for this View panel
	 */

	private void addButton() {
		Save = new JButton("Save");
		Load = new JButton("Load");
		Music = new JButton("Music");
		Quit = new JButton("Quit");

		Save.addActionListener((e) -> {
			game.save();
		});
		Load.addActionListener((e) -> {
			// not implement yet
			String load = "save.txt";
			new Game(load);
			SoundResources.Meun.sound.stop();
		});

		Quit.addActionListener((e) -> {
			// gameContinue();
			System.exit(0);
		});
		Music.addActionListener((e) -> {
			MusicOn = !MusicOn;
			if (MusicOn) {
				SoundResources.FightBGM.sound.loop();
			} else {
				SoundResources.FightBGM.sound.stop();
			}

		});

		// set layout for the buttons
		this.setLayout(new GridLayout(0, 1, 0, 100));
		this.setBorder(new EmptyBorder(160, 300, 160, 300));
		Insets margin = new Insets(20, 150, 20, 150);

		Save.setMargin(margin);
		Load.setMargin(margin);
		Music.setMargin(margin);
		Quit.setMargin(margin);
		
		Save.setFocusable(false);
		Load.setFocusable(false);
		Music.setFocusable(false);
		Quit.setFocusable(false);
		
		Save.setVisible(gameStop);
		Load.setVisible(gameStop);
		Music.setVisible(gameStop);
		Quit.setVisible(gameStop);

		this.add(Save);
		this.add(Load);
		this.add(Music);
		this.add(Quit);
	}
	/**
	 * When user purses ESC button, the game will stop
	 * set the button to Visible
	 * and will repaint the current Frame
	 */

	public void gameStop() {

		gameStop = !gameStop;
		Save.setVisible(gameStop);
		Load.setVisible(gameStop);
		Music.setVisible(gameStop);
		Quit.setVisible(gameStop);
		repaint();
		
		

	}

	public Dimension getPreferredSize() {
		return new Dimension((TILESIZE * 12), TILESIZE * 12);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

	/**
	 * To paint out the game board
	 */

	@Override
	public void paintComponent(Graphics g) {

		drawFloor(g);
		drawMap(game.getBoard(), g);
		drawPlayer(game.getPlayer(), g);

		
		
		if(game.isAttacking()){
			drawAttacking(g);
		}
		if (gameStop) { // if the game is stop paint out the stop frame
			Graphics2D _g = (Graphics2D) g.create();
			_g.setComposite(AlphaComposite.SrcOver.derive(0.8f));

			_g.setColor(Color.darkGray.darker());
			_g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}
	
	/**
	 * to show the attacking panel when player fighting with monsters 
	 * it shows the 
	 * @param g
	 */
	private void drawAttacking(Graphics g) {
		
		int x = TILESIZE*3;
		int y = TILESIZE*4;
		
		Image img = ImgResources.fightingBackGroud.img;
		g.drawImage(img, x, y, x+TILESIZE*6, y+TILESIZE*4, 0, 0,img.getWidth(null), img.getHeight(null), null);
		
		x+=TILESIZE;
		y+=TILESIZE*0.6;
		ImageIcon icon = PlayerResources.Down.image;
		icon.paintIcon(null, g, x, y);
		
		g.drawString("HP: "+game.getPlayer().getHealth(), x, y+64);
		g.drawString("Attack: "+game.getPlayer().getDamage(), x, y+94);
		g.drawString("Deffence: "+game.getPlayer().getDefence(), x, y+124);
		
		x+=TILESIZE*3;
		String path = "/Entities/" + game.getPlayer().getVSmonster().getName() + ".png";
		icon = new ImageIcon(View.class.getResource(path));
		icon.paintIcon(null, g, x, y);
		g.drawString("HP: "+game.getPlayer().getVSmonster().getHealth(), x, y+64);
		g.drawString("Attack: "+game.getPlayer().getVSmonster().getDamage(), x, y+94);
		g.drawString("Deffence: "+game.getPlayer().getVSmonster().getDefence(), x, y+124);
		
	}

	/**
	 * To draw all the entity in the game board
	 * 
	 * @param board
	 *            the game board in the game
	 * @param g
	 *            Graphics
	 */

	private void drawMap(Board board, Graphics g) {

		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {

				int py = y * TILESIZE;
				int px = x * TILESIZE;
				int code = 0;

				try {
					if (board.getCurrentLevel().getEntityAt(x, y) != null) {
						code = board.getCurrentLevel().getEntityAt(x, y).getCode();
						if (code >= 90 && code < 100) {// set the monster image in the middle
							code+=ac;
							py += 16;
							px += 16;
						}
						ImageIcon img = new ImageIcon(View.class.getResource("/Entities/" + code + ".png"));
						img.paintIcon(null, g, py, px);
					}
					if (code == 60) y += 1;
				} catch (NullPointerException e) {
					System.err.println("NullPointerException: DrawMap image unfind: " + code);
					
				}
			}
		}

	}

	/**
	 * To draw the floor of the current map, it Equivalent to background image
	 * 
	 * @param g
	 *            Graphics
	 */

	private void drawFloor(Graphics g) {
		for (int x = 0; x < Level.BOARDSIZE; x++) {
			for (int y = 0; y < Level.BOARDSIZE; y++) {
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/0.png"));
				img.paintIcon(null, g, y * TILESIZE, x * TILESIZE);
			}
		}

	}

	/**
	 * To draw the image for current direction of player facing.
	 * 
	 * @param player
	 * @param g
	 */

	private void drawPlayer(Player player, Graphics g) {
		int x = player.getXPos() * TILESIZE + 16;
		int y = player.getYPos() * TILESIZE + 16;

		switch (game.getPlayer().getFacingDirection()) {// use the image depends on witch direction the player using
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
	//==========getters==========

	public BagPanel getBagPanel() {
		return bagPanel;
	}

	public JPanel getCharacterPanel() {
		return characterPanel;
	}

	public DialogPanel getDialogPanel() {
		return dialogPanel;
	}

	public Game getGame() {
		return game;
	}

	public boolean getGameStop() {
		// TODO Auto-generated method stub
		return this.gameStop;
	}

}
