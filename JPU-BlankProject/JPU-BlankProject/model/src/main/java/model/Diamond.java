package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Diamond extends Objet implements Runnable{

	
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
		Timer time2=new Timer();
		TimerTask task2=new TimerTask() {

			@Override
			public void run() {
			
				if(falling==true) {
					setY(getY()+32);
					setVelocity(getVelocity()+1);
				}
				
			}
			
		};
		//time2.schedule(task2,10,100);
	}
	
	public int getY() {
		/*if(super.falling==true) {
			this.y=this.y+32;
			this.velocity++;
			return y;
		}else {*/
			return y;	
		//}

	}
	
	public boolean getFalling() {
		return falling;
	}



	public void setFalling(boolean falling) {
		this.falling = falling;
	}


	public void setImgObj(String num) {
		String str="/images/diam" + num+ ".png";
		super.icoObj=new ImageIcon(getClass().getResource(str));
		super.imgObj = super.icoObj.getImage();
	
	}
	@Override
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			this.getY();
			this.getX();
			try {Thread.sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
		}
	
	}
}
