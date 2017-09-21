package resources;

import java.awt.Image;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author Zhancheng Gan
 */

public enum ImgResources {
	//
	
	equipmentBackGroud("equipmentPanel.png"),
	characterBackGroud("characterPanel.png"),
	BackGround("background.jpg");
	
	public final Image img;

	ImgResources(String resourceName) {
		try {
			img = ImageIO.read(ImgResources.class.getResource(resourceName));
		} catch (IOException e) {
			throw new Error(e);
		}
	}
}
