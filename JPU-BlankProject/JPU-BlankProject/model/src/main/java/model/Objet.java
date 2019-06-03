package model;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * 
 * @author Tamandjou lesly
 *		the class Objet superclass of all the objects
 */

public class Objet {

	/** This variable gives the path to the image*/
	protected ImageIcon icoObj;
	
	/** This variable contains the image*/
	protected Image imgObj;
	
	/** The x and y coordonates of the object*/
	protected int x,y;
	
	/** the height and the width of the object*/
	protected int width,height;
	
	protected int compt;
	
	/** Tells if the Object is falling or not*/
	protected boolean falling;
	
	/** Give the speed of the Object*/
	protected int velocity;
	
	/**Tell if the object is pushable right or left*/
	
	protected boolean pushableLeft;
	protected boolean pushableRight;
	
	/**
	 * 
	 * @param x
	 * The x coordinate
	 * @param y
	 * The y coordinate
	 * @param width
	 * The width 
	 * @param height
	 * The height
	 */

	public Objet(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.compt=0;
		this.pushableLeft=false;
		this.pushableRight=false;

	}
	
	/**
	 * 
	 * @return velocity
	 * get the speed of the object
	 */

	public int getVelocity() {
		return velocity;
	}

	/**
	 * 
	 * @param velocity
	 * define the speed of the object
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * 
	 * @return compt
	 * getter of the variable compt
	 */

	public int getCompt() {
		return compt;
	}

	/**
	 * 
	 * @param compt
	 * setter of the compt
	 */
	public void setCompt(int compt) {
		this.compt = compt;
	}
	
	/**
	 * 
	 * @param objet
	 * the object to test the collision with
	 * @return
	 * return true if there is a collision and false if not
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
	 * the object to test the collision with
	 * @return
	 * return true if there is a collision and false if not
	 */
	
	public boolean LeftContact(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
	}else {
		return false;
	}
}

	/**
	 * 
	 * @param objet
	 * the object to test the collision with
	 * @return
	 * return true if there is a collision and false if not
	 */

	public boolean RightContact(Objet objet) {
	if(this.x+32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
	return true;
		}else {
	return false;
		}
}

	/**
	 * 
	 * @param character
	 * the character to test the collision with
	 * @return
	 * return true if there is a collision and false if not
	 */
	public boolean DownContactDash(Character character) {
		if(this.x==character.getX() && this.y+32==character.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param objet
	 * the object to test the proximity with
	 * @return
	 * return true if there is a collision and false if not
	 */
	public boolean NearDown(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @return
	 * getter for x
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @param x
	 * setter for x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * sets the image of the object
	 */
	public void setImgObj() {
		String str="/images/solnoir.png";
		this.icoObj=new ImageIcon(str);
		this.imgObj = this.icoObj.getImage();
	}
	/**
	 * 
	 * @return
	 * return the y coordinate
	 */
	public int getY() {
		return y;
	}
/**
 * 
 * @param y
 * setter of the y
 */
	public void setY(int y) {
		this.y = y;
	}
/**
 * 
 * @return
 * getter of the image
 */
	public Image getImgObj() {
		return imgObj;
	}
/**
 * @return
 * getter of falling
 */
	public boolean getFalling() {
		return falling;
	}
/**
 * 
 * @param falling
 * setter of falling
 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
/**
 * 
 * @return
 * getter of pushableLeft
 */
	public boolean getPushableLeft() {
		return pushableLeft;
	}
	/**
	 * 
	 * @param pushableLeft
	 * setter of pushableLeft
	 */
	public void setPushableLeft(boolean pushableLeft) {
		this.pushableLeft = pushableLeft;
	}
	/**
	 * 
	 * @return
	 * getter of pushableRight
	 */
	public boolean getPushableRight() {
		return pushableRight;
	}
	
	/**
	 * 
	 * @param pushableRight
	 * setter of pushableRight
	 */
	public void setPushableRight(boolean pushableRight) {
		this.pushableRight = pushableRight;
	}
}
