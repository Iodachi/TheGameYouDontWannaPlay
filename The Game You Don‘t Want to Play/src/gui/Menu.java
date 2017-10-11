package gui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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

	public Menu() {

		// SoundResources.Meun.sound.loop();
		JButton NewGame = new JButton("New Game");
		JButton Load = new JButton("Load");
		JButton Info = new JButton("Info");
		JButton Quit = new JButton("Quit");
		NewGame.addActionListener((e) -> {
			new Game();
			f.setVisible(false); // hidden the menu frame
			SoundResources.Meun.sound.stop();
		});
		Load.addActionListener((e) -> {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt");
			chooser.setFileFilter(filter);
			//chooser.setCurrentDirectory(dir);
			FileReader savefile;
			int result = chooser.showOpenDialog(new JFrame());
			if (result == JFileChooser.APPROVE_OPTION) {
			try {
				savefile = new FileReader(chooser.getSelectedFile());
				new Game(savefile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			f.setVisible(false); // hidden the menu frame
			SoundResources.Meun.sound.stop();
		}});

		Quit.addActionListener((e) -> {
			System.exit(0);
		});
		Info.addActionListener((e) -> {
			// not implement yet
		});

		// set layout for the buttons
		this.setLayout(new GridLayout(0, 1, 0, 100));
		this.setBorder(new EmptyBorder(150, 450, 150, 450));


		this.add(NewGame);
		this.add(Load);
		this.add(Info);
		this.add(Quit);

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
