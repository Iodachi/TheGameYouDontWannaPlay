package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.Game;

/**
 * 
 * @author Zhancheng Gan
 *
 */


public class MouseController implements MouseMotionListener, MouseListener {

	private Game game;
	
	public MouseController(Game game) {
		this.game = game;

	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("X:%dY:%d\n",e.getX(),e.getY());
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
