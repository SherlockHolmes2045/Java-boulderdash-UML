package model;

import javax.swing.ImageIcon;

public class Ground extends Objet{

	public Ground(int x, int y) {
		super(x, y, 32,32);
		super.icoObj=new ImageIcon(getClass().getResource("/images/sol.png"));
		super.imgObj=super.icoObj.getImage();
	}
	public void setImgObj() {
		String str="/images/solnoir.png";
		super.icoObj=new ImageIcon(getClass().getResource(str));
		super.imgObj = super.icoObj.getImage();

	}
}
