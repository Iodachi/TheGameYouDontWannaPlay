package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

import resources.ImgResources;

public class CharacterPanel extends JPanel {
	/**
	 * the Panel for showing all the attribute main character
	 */
	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	private static final int RECTSIZE = 50;
	private static final int GAPSIZE = 10;
	private static final int INITIALX = 40;
	private static final int INITIALY = 50;
	private Rectangle[] charaRect = new Rectangle[3];
	
	public CharacterPanel(){
		CreateRectangle();
	}
	
	@Override
	public void paint(Graphics g) {

		Image img = ImgResources.characterBackGroud.img; // to load the character BackGroud image
		// fill the BackGroud to appropriate size
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
	

	/**
	 * The Rectangles is provide for the Mouse controller, to checking does the user
	 * chick on the items on Character Panel .
	 */
	public void CreateRectangle() {
		for (int row = 0; row < 3; row++) {
			int x = INITIALX;
			int y = INITIALY + (RECTSIZE+GAPSIZE) * row;
			if (row > 1)
				y += 10;// the gap changes when the row lager than 1
			charaRect[row] = new Rectangle(x, y, RECTSIZE, RECTSIZE);

		}
	}
	/**
	 * To check those the user check on the items frame
	 * @return true if contains otherwise return false
	 */
	public boolean containsRect(int x, int y) {
		for(int row = 0; row<3; row++) {
			if(charaRect[row].contains(x, y))
			return true;
		}
		return false;
		
	}

	/**
	 * set the size for character panel, on the basis of tile size
	 */
	public Dimension getPreferredSize() {
		return new Dimension((int) (TILESIZE * 4), TILESIZE * 6);
	}
}
