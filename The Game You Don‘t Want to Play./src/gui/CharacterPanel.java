package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import resources.ImgResources;

public class CharacterPanel  extends JPanel{ 
	/**
	 * the Panel for showing all the attribute main character 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TILESIZE = 64;
	 @Override  
     public void paint(Graphics g) { 
		 
		 Image img= ImgResources.characterBackGroud.img;
		 g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),0,0,img.getWidth(null),img.getHeight(null),null);
	 }	 
	 public Dimension getPreferredSize() {return new Dimension((int) (TILESIZE*4), TILESIZE*6);}
} 


