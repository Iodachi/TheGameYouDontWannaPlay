package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import resources.ImgResources;

public class DialogPanel  extends JPanel{ 
	/**
	 * This Panel Shows conversation between NPC and player, and shows all the goods 
	 * of the shop or the all the attribute of the player, that can level up;
	 */
	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	 @Override  
     public void paint(Graphics g) { 
		 
		 Image img= ImgResources.dialogBackGroud.img;// to load the dialog BackGroud image
		 //fill the BackGroud to appropriate size	 
		 g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),0,0,img.getWidth(null),img.getHeight(null),null);
	 }
	 
	 /**
	  * set the size for character panel, on the basis of tile size
	  */
	 public Dimension getPreferredSize() {return new Dimension((int) (TILESIZE*4), TILESIZE*12);}
} 

