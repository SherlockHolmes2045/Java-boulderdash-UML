package model;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Tamandjou lesly
 *		The class Character, it is the class that manages every character in the video game
 */

public class Character {
	/**
	 * @see Objet
	 */
	protected ImageIcon icoChar;
	protected Image imgChar;
	
	protected int x,y;
	protected int width,height;
	
	/** Tells if the hero can walk or not*/
	protected boolean walks;
	
	/**Tells if the Hero is death or not*/
	protected boolean death;
	
	/**
	 * 	
	 * @param x
	 * the x coordinate
	 * @param y
	 * the y coordinate
	 * @param width
	 * the width value
	 * @param height
	 * 		It is about the width, height and position of character
	 */

	public Character(int x,int y,int width,int height) {
		
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.death=false;
	}
	/**
	 * 
	 * @return imgChar means that it is returns the character image 
	 */

	public Image getImgChar() {
		return imgChar;
	}

	/**
	 * 
	 * @param imgChar
	 * 		This operation it is to modify the image
	 */

	public void setImgChar(Image imgChar) {
		this.imgChar = imgChar;
	}

	/**
	 * 
	 * @return x, the position of the character
	 */

	public int getX() {
		return x;
	}
/**
 * 
 * @param x
 * the new x coordinate
 * @see Objet
 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * 
	 * @return y
	 */

	public int getY() {
		return y;
	}
/**
 * 
 * @param y
 * setter for the y coordinate
 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return width
	 *    To obtain the width of the character
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return height
	 * 		To obtain the height of the character
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 
	 * @return walks
	 * 		Tells if the character can move 
	 */

	public boolean getWalks() {
		return walks;
	}
	
	/**
	 * 
	 * @param walks
	 * setter for walk
	 */
	public void setWalks(boolean walks) {
		this.walks= walks;
	}

	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect the contact with an object to the side precise
	 */

	public boolean LeftContact(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY() ) {
			return true;
		}else {
			return false;
		}
		}
	
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect the contact with an object to the side precise
	 */

	public boolean RightContact(Objet objet) {
		if(this.x+32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect the contact with an object to the side precise
	 */

	public boolean UpContact(Objet objet) {
		if(this.x==objet.getX() && this.y-32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect the contact with an object to the side precise
	 */

	public boolean DownContact(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect an object that it is near of the character
	 */
	
	public boolean NearLeft(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect an object that it is near of the character
	 */
	
	public boolean NearRight(Objet objet) {
		if(this.x+32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect an object that it is near of the character
	 */
	
	public boolean NearUp(Objet objet) {
		if(this.x==objet.getX() && this.y-32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @param objet
	 * the object to test the collison with
	 * @return boolean parameter
	 * 		To detect an object that it is near of the character
	 */
	
	public boolean NearDown(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * @return death
	 * getter for death
	 */

	public boolean getDeath() {
		return death;
	}
/**
 * 
 * @param death
 * setter for death
 */
	public void setDeath(boolean death) {
		this.death = death;
	}

}
