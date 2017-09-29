package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

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

public class DialogPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	private Game game;
	
	private int code = 0;
	private int i=0;
	private java.util.Timer timer = new java.util.Timer();

	public DialogPanel(Game game) {
		this.game = game;

	}

	@Override
	public void paint(Graphics g) {

		Image img = ImgResources.dialogBackGroud.img;// to load the dialog BackGroud image
		// fill the BackGroud to appropriate size
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, img.getWidth(null), img.getHeight(null), null);

		showDialog(g);
	}

	public void showDialog(Graphics g) {
		
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

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(i<2) {
				 i++;
				}else {
					i=0;
				}
				
				repaint();
			}
		}, 500, 500);
		
		String name = code + i + "";
		//System.out.println(name);
		ImageIcon img = new ImageIcon(View.class.getResource("/Player/Player_" + name + ".png"));
		img.paintIcon(null, g, 30, 30);
		
		}

		
		

	

	/**
	 * set the size for character panel, on the basis of tile size
	 */
	public Dimension getPreferredSize() {
		return new Dimension((int) (TILESIZE * 4), TILESIZE * 12);
	}
}
