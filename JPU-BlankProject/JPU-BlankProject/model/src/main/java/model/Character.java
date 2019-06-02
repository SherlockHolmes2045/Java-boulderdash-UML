package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Character {

	protected ImageIcon icoChar;
	protected Image imgChar;
	
	protected int x,y;
	protected int width,height;
	
	protected boolean walks;
	protected boolean death;
	
	public Character(int x,int y,int width,int height) {
		
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.death=false;
	}

	public Image getImgChar() {
		return imgChar;
	}

	public void setImgChar(Image imgChar) {
		this.imgChar = imgChar;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean getWalks() {
		return walks;
	}

	public void setWalks(boolean walks) {
		this.walks= walks;
	}

	public boolean contactGauche(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY() ) {
			return true;
		}else {
			return false;
		}
		}
	public boolean contactDroite(Objet objet) {
		if(this.x+32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean contactHaut(Objet objet) {
		if(this.x==objet.getX() && this.y-32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean contactBas(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean procheGauche(Objet objet) {
		if(this.x-32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean procheDroite(Objet objet) {
		if(this.x+32==objet.getX() && this.y==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean procheHaut(Objet objet) {
		if(this.x==objet.getX() && this.y-32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean procheBas(Objet objet) {
		if(this.x==objet.getX() && this.y+32==objet.getY()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean getDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

}
