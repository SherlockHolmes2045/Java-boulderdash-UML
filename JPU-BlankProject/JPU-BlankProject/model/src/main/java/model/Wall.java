package model;

import javax.swing.ImageIcon;

public class Wall extends Objet{

	public Wall(int x, int y) {
		super(x, y, 32, 32);
		super.icoObj=new ImageIcon(getClass().getResource("/images/mur.png"));
		super.imgObj=super.icoObj.getImage();
	}

}
