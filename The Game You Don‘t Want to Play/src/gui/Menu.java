package gui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import main.Game;
import resources.ImgResources;
import resources.SoundResources;

/**
 * 
 * @author Zhancheng Gan
 * 
 *         The game menu for this game, it contains New Game, Load, Info , Quit
 *         button and background images
 *
 */
public class Menu extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final JFrame f = new JFrame("The Game You Don't Want To Play");
	private JButton newGame, load, info, quit;

	public Menu() {
		// SoundResources.Meun.sound.loop();
		newGame = new JButton("New Game");
		load = new JButton("Load");
		info = new JButton("Info");
		quit = new JButton("Quit");

		setButtons();
		
		// set layout for the buttons
		this.setLayout(new GridLayout(0, 1, 0, 100));
		this.setBorder(new EmptyBorder(150, 450, 150, 450));
		
		setFocusable(true);
		setVisible(true);

		// add this menu to the frame
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.add(this);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(View.TILESIZE * 17, View.TILESIZE * 12);
	}

	public static void main(String[] args) {
		new Menu();
	}
	
	public void setButtons() {
		newGame.addActionListener((e) -> {
			new Game();
			f.setVisible(false); // hidden the menu frame
			SoundResources.Meun.sound.stop();
		});
		load.addActionListener((e) -> {
			// not implement yet
			String load = "save.txt";
			new Game(load);

			f.setVisible(false); // hidden the menu frame
			SoundResources.Meun.sound.stop();
		});

		quit.addActionListener((e) -> {
			System.exit(0);
		});
		
		info.addActionListener((e) -> {
			// not implement yet
		});
		
		Insets margin = new Insets(20, 150, 20, 150);
		newGame.setMargin(margin);
		load.setMargin(margin);
		info.setMargin(margin);
		quit.setMargin(margin);

		this.add(newGame);
		this.add(load);
		this.add(info);
		this.add(quit);
	}

	/**
	 * paint out the background images
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = ImgResources.BackGround.img;
		g.drawImage(img, 0,0,this.getWidth(), this.getHeight(), null);
		// int size = View.TILESIZE;
		// for(int x=0; x<this.getWidth()/size; x++) {
		// for(int y=0; y<=this.getHeight()/size; y++) {
		// int number = (int) (Math.random()*80)+1;
		// String code ="";
		// if(number<10) {code= "0"+number;}
		// else {code=""+number;}
		// try {
		// String path = "/tiles/tiles_"+code+".png";
		// Icon icon = new ImageIcon ( ImageIO.read(Menu.class.getResource(path)));
		// icon.paintIcon(null, g, x*size, y*size);;
		// } catch (Exception e) {
		// throw new Error(e);
		// }
		//
		// }
		// }
	}
}
