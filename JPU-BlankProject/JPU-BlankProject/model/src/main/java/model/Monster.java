package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * 
 * @author Tamandjou lesly
 *		the class Roc
 */
public class Monster extends Character{

	/** tell if the monster is going left or right or up or down*/
	private boolean goesLeft;
	private boolean goesRight;
	private boolean goesUp;
	private boolean goesDown;
	
	/**
	 * 
	 * @param x
	 * the x coordinate
	 * @param y
	 * the y coordinate
	 * the coordinates of the monster
	 */
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
	
	/**
	 * 
	 * @return
	 * getter of goesleft
	 */
	public boolean isGoesLeft() {
		return goesLeft;
	}
	/**
	 * 
	 * @param goesLeft
	 * setter of the goesleft
	 */
	public void setGoesLeft(boolean goesLeft) {
		this.goesLeft = goesLeft;
	}
	/**
	 * 
	 * @return
	 * getter of goesright
	 */
	public boolean isGoesRight() {
		return goesRight;
	}
	/**
	 * 
	 * @param goesRight
	 * setter of goesright
	 */
	public void setGoesRight(boolean goesRight) {
		this.goesRight = goesRight;
	}
	/**
	 * 
	 * @return
	 * getter of goesup
	 */
	public boolean isGoesUp() {
		return goesUp;
	}
	/**
	 * 
	 * @param goesUp
	 * setter of goesup
	 */
	public void setGoesUp(boolean goesUp) {
		this.goesUp = goesUp;
	}
	/**
	 * 
	 * @return
	 * getter of goesdown
	 */
	public boolean isGoesDown() {
		return goesDown;
	}
	/**
	 * 
	 * @param goesDown
	 * setter of goesdown
	 */
	public void setGoesDown(boolean goesDown) {
		this.goesDown = goesDown;
	}

	/**
	 * 
	 * @param objet
	 * the object to test the collision with
	 * @return
	 * tells if the right object is a back
	 */
	public boolean movesRight(Objet objet) {
		
		if(this.x+32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	/**
	 * 
	 * @param objet
	 * the Object to test the collision with
	 * @return
	 * tells if the left object is a back
	 */
	public boolean movesLeft(Objet objet) {
		
		if(this.x-32==objet.getX() && this.y==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	/**
	 * 
	 * @param objet
	 * the Object to test the collision with
	 * @return
	 * tells if the up object is a back
	 */
	public boolean movesUp(Objet objet) {
		
		if(this.x==objet.getX() && this.y-32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	/**
	 * 
	 * @param objet
	 * the Object to test the collision with
	 * @return
	 * tells if the down object is back
	 */
	public boolean movesDown(Objet objet) {
		
		if(this.x==objet.getX() && this.y+32==objet.getY() && objet.getClass().getName().equals("model.Back")) {
		return true;
		}else {
			return false;	
		}
	}
	/**
	 * 
	 * @param objet
	 * the Object to test the collision with
	 * @return
	 * tells if the monster cannot move in the precise direction
	 */
		public boolean DoesnotmovesLeft(Objet objet) {
			if(this.x-32==objet.getX() && this.y==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
				return true;
			}else {
			return false;	
}
		}
		/**
		 * 
		 * @param objet
		 * the Object to test the collision with
		 * @return
		 * tells if the monster cannot move in the precise direction
		 */
			public boolean DoesnotmovesRight(Objet objet) {
				if(this.x+32==objet.getX() && this.y==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
					return true;
				}else {
				return false;	
	}
			}
			/**
			 * 
			 * @param objet
			 * the Object to test the collision with
			 * @return
			 * tells if the monster cannot move in the precise direction
			 */
				public boolean DoesnotmovesUp(Objet objet) {
					if(this.x==objet.getX() && this.y-32==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
						return true;
					}else {
					return false;	
		}
}
				/**
				 * 
				 * @param objet
				 * 		to object to test the collision with
				 * @return
				 * tells if the monster cannot move in the precise direction
				 */
				public boolean DoesnotmovesDown(Objet objet) {
					if(this.x==objet.getX() && this.y+32==objet.getY() && !objet.getClass().getName().equals("model.Back")) {
						return true;
					}else {
					return false;	
		}
}
}
