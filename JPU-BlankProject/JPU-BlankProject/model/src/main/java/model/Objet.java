package model;

import java.awt.Image;

import javax.swing.ImageIcon;

import contract.IObjet;

public class Objet {

	protected ImageIcon icoObj;
	protected Image imgObj;
	
	protected int x,y;
	protected int width,height;
	protected int compt;
	protected boolean falling;
	protected int velocity;
	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	protected boolean pushableLeft;
	protected boolean pushableRight;
	public Objet(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.compt=0;
		this.pushableLeft=false;
		this.pushableRight=false;

	}

	public int getCompt() {
		return compt;
	}

	public void setCompt(int compt) {
		this.compt = compt;
	}

	public boolean contactBas(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean contactGauche(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
	}else {
		return false;
	}
}

public boolean contactDroite(Objet objet) {
	if(this.x+32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
	return true;
		}else {
	return false;
		}
}

	
	public boolean contactBasDash(Character character) {
		if(this.x==character.getX() && this.y+32==character.getY()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean procheBas(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
			return true;
		}else {
			return false;
		}
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setImgObj() {
		String str="/images/solnoir.png";
		this.icoObj=new ImageIcon(str);
		this.imgObj = imgObj;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImgObj() {
		return imgObj;
	}

	public boolean getFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean getPushableLeft() {
		return pushableLeft;
	}

	public void setPushableLeft(boolean pushableLeft) {
		this.pushableLeft = pushableLeft;
	}

	public boolean getPushableRight() {
		return pushableRight;
	}

	public void setPushableRight(boolean pushableRight) {
		this.pushableRight = pushableRight;
	}
	
	
}
