package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Game;
import resources.ImgResources;

public class BagPanel extends JPanel implements Observer {

	/**
	 * the Panel for showing all the equipments in players bag
	 */
	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	private static final int RECTSIZE = 60;
	private static final int COLGAPSIZE = 10;
	private static final int ROWGAPSIZE = 20;
	private int initialX = 28;
	private int initialY = 38;
	private Game game;
	private Rectangle[][] bagRectangle = new Rectangle[4][3];

	public BagPanel(Game game) {
		this.game = game;
		game.addObserver(this);
		CreateRectangle();
	}

	@Override
	public void paint(Graphics g) {

		Image img = ImgResources.equipmentBackGroud.img; // to load the equipment BackGroud image
		// fill the BackGroud to appropriate size
		game.getPlayer().getInventory();
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, img.getWidth(null), img.getHeight(null), null);
		drawItem(g);

	}

	private void drawItem(Graphics g) {
		int size = game.getPlayer().getInventory().size();
		String Name = "";

		for (int i = 0; i < size; i++) {
			int col = i % 3;
			int row = i / 3;
			int x = bagRectangle[row][col].x;
			int y = bagRectangle[row][col].y;
			try {
				Name = game.getPlayer().getInventory().get(i).getName();
				ImageIcon img = new ImageIcon(View.class.getResource("/Entities/" + Name + ".png"));
				img.paintIcon(null, g, x, y);
				System.out.println(i);
			} catch (NullPointerException e) {
				System.err.println("NullPointerException: image unfind" + Name);
			}
		}

	}

	/**
	 * The Rectangles is provide for the Mouse controller, to checking does the user
	 * chick on the items on bag Panel.
	 */

	public void CreateRectangle() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 3; col++) {
				int x = initialX + (RECTSIZE + COLGAPSIZE) * col;
				int y = initialY + (RECTSIZE + ROWGAPSIZE) * row;
				if (row > 1)
					y += 20;// the gap changes when the row lager than 1
				bagRectangle[row][col] = new Rectangle(x, y, RECTSIZE, RECTSIZE);
			}
		}
	}

	/**
	 * To check those the user check on the items frame
	 * 
	 * @return true if contains otherwise return false
	 */
	public boolean containsRect(int x, int y) {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 3; col++) {
				if (bagRectangle[row][col].contains(x, y))
					return true;
			}
		}
		return false;

	}

	/**
	 * set the size for character panel, on the basis of tile size
	 */
	public Dimension getPreferredSize() {
		return new Dimension((int) (TILESIZE * 4), TILESIZE * 6);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}
}
