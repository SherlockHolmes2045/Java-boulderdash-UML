package model;

import javax.swing.ImageIcon;

public class Back extends Objet{

	public Back(int x, int y) {
		super(x, y,32,32);
		super.icoObj=new ImageIcon(getClass().getResource("/images/solnoir.png"));
		super.imgObj=super.icoObj.getImage();

	}

}
