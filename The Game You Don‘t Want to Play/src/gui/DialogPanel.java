package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Game;
import resources.ImgResources;

/**
 * This Panel Shows conversation between NPC and player, and shows all the goods
 * of the shop or the all the attribute of the player, that can level up;
 * 
 * @author jackgan
 *
 */

public class DialogPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	private Game game;

	private int code = 0;
	private int i = 0;
	
	public DialogPanel(Game game) {
		this.game = game;
		game.addObserver(this);

	}

	@Override
	public void paint(Graphics g) {
		Image img = ImgResources.dialogBackGroud.img;
		drawBackGround(img,g);
		String str = "get XXX string";
		drawString(str,g);
		drawIcon(g);
		//if(game.getInShop())
		drawitem(g);
	}

	private void drawitem(Graphics g) {
		int x = 18;
		int y = 430;
		int w = 60;
		int h = 60;
		int gap = 20;
		Graphics2D _g = (Graphics2D) g.create();
		_g.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		_g.setColor(Color.WHITE);
		
		for(int i = 0; i<4; i++) {
			for(int j=0; j<3; j++) {
				_g.fillRect(x, y, w, h);
				//game.getBoard()
				x+=(w+gap);
			}
			x=18;
			y+=(gap+h);
		}
		game.getBoard();
	}

	private void drawString(String str,Graphics g) {
	
		g.setColor(Color.WHITE);

		int i = 0;
		for (; i < str.length()/25; i++) {
			g.drawString(str.substring(i*25,i*25+25), 30, 110+20*i);
		}
			g.drawString(str.substring(i*25,str.length()), 30, 110+20*i);

		}
		
	

	private void drawIcon(Graphics g) {
		switch (game.getPlayer().getFacingDirection()) {
		case "up":
			code = 10;
			break;
		case "down":
			code = 1;
			break;
		case "right":
			code = 7;
			break;
		case "left":
			code = 4;
			break;
		default:
			break;
		}
		String name = code + i + "";
		ImageIcon img = null;
		if(game.getInShop()) {
			img = new ImageIcon(View.class.getResource("/Entities/60.png"));
		}else {
			img = new ImageIcon(View.class.getResource("/Player/Player_" + name + ".png"));

		}
			img.paintIcon(null, g, 30, 30);
		
	}

	private void drawBackGround(Image img,Graphics g) {
		// to load the dialog BackGroud image
		// fill the BackGroud to appropriate size
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, img.getWidth(null), img.getHeight(null), null);
		
	}	

	/**
	 * set the size for character panel, on the basis of tile size
	 */
	public Dimension getPreferredSize() {
		return new Dimension((int) (TILESIZE * 4), TILESIZE * 12);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
}
