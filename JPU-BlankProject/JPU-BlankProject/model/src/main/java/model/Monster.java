package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Monster extends Character{

	private boolean goesLeft;
	private boolean goesRight;
	private boolean goesUp;
	private boolean goesDown;
	public Monster(int x, int y) {
		super(x, y,32,32);
		super.icoChar=new ImageIcon(getClass().getResource("/images/monster.png"));
		super.imgChar=super.icoChar.getImage();
		super.walks=false;
		this.goesDown=false;
		this.goesLeft=false;
		this.goesRight=false;
		this.goesLeft=false;
		Timer time=new Timer();
		TimerTask task=new TimerTask(){

			@Override
			public void run() {
				if(getWalks()==true) {
				if(goesRight==true)	{
					setX(getX()+32);
				}else if(goesLeft==true) {
					setX(getX()-32);
				}else if(goesUp==true) {
					setY(getY()-32);
				}else if(goesDown==true) {
					setY(getY()+32);
				}
			}
		}	
	};
		time.schedule(task,100,110);
	}
	public boolean isGoesLeft() {
		return goesLeft;
	}
	public void setGoesLeft(boolean goesLeft) {
		this.goesLeft = goesLeft;
	}
	public boolean isGoesRight() {
		return goesRight;
	}
	public void setGoesRight(boolean goesRight) {
		this.goesRight = goesRight;
	}
	public boolean isGoesUp() {
		return goesUp;
	}
	public void setGoesUp(boolean goesUp) {
		this.goesUp = goesUp;
	}
	public boolean isGoesDown() {
		return goesDown;
	}
	public void setGoesDown(boolean goesDown) {
		this.goesDown = goesDown;
	}

	public boolean movesRight(Objet objet) {
		
		if(this.x+32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	
	public boolean movesLeft(Objet objet) {
		
		if(this.x-32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	public boolean movesUp(Objet objet) {
		
		if(this.x==objet.getX() && this.y-32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	public boolean movesDown(Objet objet) {
		
		if(this.x==objet.getX() && this.y+32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
		public boolean DoesnotmovesLeft(Objet objet) {
			if(this.x-32==objet.getX() && this.y==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
				return true;
			}else {
			return false;	
}
		}
			public boolean DoesnotmovesRight(Objet objet) {
				if(this.x+32==objet.getX() && this.y==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
					return true;
				}else {
				return false;	
	}
			}
				public boolean DoesnotmovesUp(Objet objet) {
					if(this.x==objet.getX() && this.y-32==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
						return true;
					}else {
					return false;	
		}
}
				public boolean DoesnotmovesDown(Objet objet) {
					if(this.x==objet.getX() && this.y+32==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
						return true;
					}else {
					return false;	
		}
}
}
