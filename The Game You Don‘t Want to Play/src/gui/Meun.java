package gui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import resources.ImgResources;


public class Meun extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final JFrame f = new JFrame("The Game You Don't Want to Play");

	public Meun() {

		JButton NewGame = new JButton("New Game");
		JButton Load = new JButton("Load");
		JButton Info = new JButton("Info");
		JButton Quit = new JButton("Quit");
		NewGame.addActionListener((e) -> {

			new GUI();
			f.setVisible(false);
			//f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			// gui.cardlayout3.next(gui.jp);

		});
		Load.addActionListener((e) -> {

			System.exit(0);

		});

		Quit.addActionListener((e) -> {

			System.exit(0);

		});
		Info.addActionListener((e) -> {

			// gui.getInfo();

		});

		this.setLayout(new GridLayout(0, 1, 0, 100));
		this.setBorder(new EmptyBorder(190, 600, 190, 600));
		Insets margin = new Insets(20, 100, 20, 150);

		NewGame.setMargin(margin);
		Load.setMargin(margin);
		Info.setMargin(margin);
		Quit.setMargin(margin);

		this.add(NewGame);
		this.add(Load);
		this.add(Info);
		this.add(Quit);

		this.setSize(50, 50);
		setFocusable(true);
		setVisible(true);
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.add(this);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(1400, 850);	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Meun();  
	}

	public void paintComponent(Graphics _g) {
		super.paintComponent(_g);
		Graphics2D g = (Graphics2D) _g;
		g.drawImage(ImgResources.BackGroud.img, 0, 0, this.getWidth(), this.getHeight(), null);

	}

}
