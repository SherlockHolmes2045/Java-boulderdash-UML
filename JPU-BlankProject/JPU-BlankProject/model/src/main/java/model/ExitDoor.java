package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class ExitDoor extends Objet{

	public ExitDoor(int x, int y) {
		super(x, y, 32,32);
		super.icoObj=new ImageIcon(getClass().getResource("/images/Exit1.PNG"));
		super.imgObj=super.icoObj.getImage();
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

	public void setImgObj(String num) {
		String str="/images/Exit" + num+ ".PNG";
		super.icoObj=new ImageIcon(getClass().getResource(str));
		super.imgObj = super.icoObj.getImage();
	}
}
