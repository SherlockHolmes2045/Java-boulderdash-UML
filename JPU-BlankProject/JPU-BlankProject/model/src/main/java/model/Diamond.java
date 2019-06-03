package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * 
 * @author Tamandjou lesly
 *		this class is about the exitDoor
 */

public class Diamond extends Objet{
	
	/**
	 * 
	 * @param x
	 * the x coordinate
	 * @param y
	 * the y coordinate
	 * @see Objet
	 */

	public Diamond(int x, int y) {
		super(x, y,32,32);
	
		super.icoObj=new ImageIcon(getClass().getResource("/images/diam1.png"));
		super.imgObj=super.icoObj.getImage();
		super.falling=false;
		super.velocity=0;
		Timer time=new Timer();
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				setImgObj("2");
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				setImgObj("3");
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				setImgObj("4");
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				setImgObj("1");
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}

			}
		
		};
		time.schedule(task,10,420);
	}
	
	/**
	 * 
	 * @param num
	 * 			to set an image
	 */

	public void setImgObj(String num) {
		String str="/images/diam" + num+ ".png";
		super.icoObj=new ImageIcon(getClass().getResource(str));
		super.imgObj = super.icoObj.getImage();
	
	}
	
}
