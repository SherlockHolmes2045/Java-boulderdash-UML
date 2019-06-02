package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Roc extends Objet implements Runnable{

	public Roc(int x, int y) {
		super(x, y, 32,32);
	super.icoObj=new ImageIcon(getClass().getResource("/images/roche.png"));
	super.imgObj=super.icoObj.getImage();
	super.falling=false;
	super.velocity=0;
	
	Timer time =new Timer();
	TimerTask task= new TimerTask() {

		@Override
		public void run() {
			if(falling==false) {
				
				setImgObj2("rocher_droite");
				try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
				setImgObj2("rocher_gauche");
				try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

			}
			
		}
	};
	time.schedule(task, 10,640);
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
	//time2.schedule(task2,10,300);
	}

	public void setImgObj2(String nom) {
		String str="/images/" +nom+ ".png";
		super.icoObj=new ImageIcon(getClass().getResource(str));
		super.imgObj = super.icoObj.getImage();
	
	}

	public int getY() {
		/*if(super.falling==true) {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			y+=32;
			velocity++;
			return y;
		}else {*/
			//this.velocity=0;
			return y;	
		//}
	}
	
	

	public boolean getFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	@Override
	public void run() {
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		if(this.falling==true) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			this.getY();
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
			}
}
