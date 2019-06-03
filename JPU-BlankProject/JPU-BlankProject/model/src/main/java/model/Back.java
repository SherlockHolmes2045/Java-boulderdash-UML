package model;

import javax.swing.ImageIcon;

/**
 * 
 * @author Tamandjou lesly
 *		The class Character, it is the class that manages every character in the video game
 */

public class Back extends Objet{
	/**
	 * 
	 * @param x
	 * the x coordinate
	 * @param y
	 * the y coordinate
	 * @see Objet
	 */
	
	public Back(int x, int y) {
		super(x, y,32,32);
		super.icoObj=new ImageIcon(getClass().getResource("/images/solnoir.png"));
		super.imgObj=super.icoObj.getImage();

	}

}
