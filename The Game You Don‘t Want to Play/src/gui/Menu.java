package gui;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import main.Game;

/**
 * 
 * @author Zhancheng Gan
 *  
 *  The game menu for this game, it contains New Game, Load, Info , Quit button and background images 
 *
 */
public class Menu extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final JFrame f = new JFrame("The Game You Don't Want To Play");

	public Menu() {

		JButton NewGame = new JButton("New Game");
		JButton Load = new JButton("Load");
		JButton Info = new JButton("Info");
		JButton Quit = new JButton("Quit");
		NewGame.addActionListener((e) -> {
			new Game();
			f.setVisible(false); //hidden the menu frame
		});
		Load.addActionListener((e) -> {
			// not implement yet
		});

		Quit.addActionListener((e) -> {
			System.exit(0);
		});
		Info.addActionListener((e) -> {
			// not implement yet
		});
		
		//set layout for the buttons 
		this.setLayout(new GridLayout(0, 1, 0, 100)); 
		this.setBorder(new EmptyBorder(150, 450, 150, 450));
		Insets margin = new Insets(20, 150, 20, 150);

		NewGame.setMargin(margin);
		Load.setMargin(margin);
		Info.setMargin(margin);
		Quit.setMargin(margin);

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
		f.setSize(View.TILESIZE*17, View.TILESIZE*12);	
		
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
		
		int size = View.TILESIZE;
		for(int x=0; x<this.getWidth()/size; x++) {
			for(int y=0; y<=this.getHeight()/size; y++) {
				int number = (int) (Math.random()*80)+1;
				String code ="";
				if(number<10) {code= "0"+number;}
				else {code=""+number;}
				try {
					String path = "/tiles/tiles_"+code+".png";
					Icon icon = new ImageIcon ( ImageIO.read(Menu.class.getResource(path)));
					icon.paintIcon(null, g, x*size, y*size);;
				} catch (Exception e) {
					throw new Error(e);
				}
				
			}
		}
	}

}
