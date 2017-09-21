package controllers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.nio.channels.NonWritableChannelException;

import javax.security.auth.x500.X500Principal;

import gui.BagPanel;
import gui.CharacterPanel;
import item.Item;
import main.Game;

/**
 * 
 * @author Minping
 */


public class MouseController implements MouseMotionListener, MouseListener {

	private Game game;
	private Item[][] bag= new Item[4][3]; 
	private int sizeRectangle = 60;
	private int gapWidth=10;
	private int initialX=25;
	private int initialY=60;
	private int bagRow=0, bagCol=0;
	private Rectangle[][] bagRectangle = new Rectangle[4][3];
	private Rectangle[] charactRectangle = new Rectangle[3];
	public MouseController(Game game) {
		this.game = game;
		fillRectangle();
		printOut();
	}
	public void fillRectangle() {
		for(int row=0;row<4;row++) {
			for(int col=0; col<3;col++) {
				if(row<2) {
					bagRectangle[row][col]=new Rectangle(initialX+(sizeRectangle+gapWidth)*col, initialY+(sizeRectangle+gapWidth)*row,sizeRectangle,sizeRectangle);
				}else {
					bagRectangle[row][col]=new Rectangle(initialX+(sizeRectangle+gapWidth)*col, initialY+(sizeRectangle+gapWidth)*row+10,sizeRectangle,sizeRectangle);
				}
			}
		}
		
	}
	
	public void printOut() {
		for(int row=0;row<4;row++) {
			for(int col=0; col<3;col++) {
			int x =	bagRectangle[row][col].x;
			int y =	bagRectangle[row][col].y;
			System.out.println("row:"+row + " col"+col+"  x:"+x+ "y:"+y);
			}
		}
	}
	public boolean checkClickOn(int x,int y) {
		for(int row=0;row<4;row++) {
			for(int col =0;col<3;col++) {
				
				if(bagRectangle[row][col].contains(x,y)) {
					bagRow=row;
					bagCol=col;
					return true;
				}
			}
		}
		return false;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("X:%dY:%d\n",e.getX(),e.getY());
		
		if(e.getSource() instanceof BagPanel) {
			if(checkClickOn(e.getX(), e.getY())) {
				System.out.println("row: "+(bagRow+1)+    "col:"+(bagCol+1));
			}else {
				System.out.println("have not clicked ");
			}
		}else if(e.getSource() instanceof CharacterPanel) {
			System.out.println("in characterPanel");
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
