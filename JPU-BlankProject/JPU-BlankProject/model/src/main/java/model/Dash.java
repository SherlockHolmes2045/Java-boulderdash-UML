package model;

import java.awt.Image;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Dash extends Character{
	private boolean walksright,walksleft,walksdown,walksup;
	private int compteur;
	private int score;
	private boolean rest;
	int countanimation=0;
	public Dash(int x, int y) {
		super(x, y,32,32);
		this.score=0;
		super.icoChar=new ImageIcon(getClass().getResource("/images/Dash.png"));
		super.imgChar=super.icoChar.getImage();
		super.walks=false;
		this.walksleft=false;
		this.walksright=false;
		this.walksup=false;
		this.walksdown=false;
		this.rest=true;
		this.compteur=0;
		Timer time=new Timer();
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				if(death==true) {
				setImgObj("1");
				try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
				setImgObj("2");
				try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			
		};
		time.schedule(task,10,640);
		
		Timer time2=new Timer();
		TimerTask task2=new TimerTask() {

			@Override
			public void run() {

				if(death==true) {
					
					if(countanimation<7) {
					setY(getY()-10);	
					countanimation++;
					}else {
						setY(getY()+10);
					}
					
				}
				
			}
			
		};
		time2.schedule(task2,10,100);
		
		Timer time3=new Timer();
		TimerTask task3=new TimerTask() {

			@Override
			public void run() {
				if(rest==true && death==false) {
					setImgObj2("Dash");
					try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
					setImgObj2("persoface2");
					try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

				}
			}
			
		};
		time3.schedule(task3,10,640);
	}

	public void setImgObj(String num) {
		String str="/images/persomort" + num+ ".png";
		super.icoChar=new ImageIcon(getClass().getResource(str));
		super.imgChar = super.icoChar.getImage();
	
	}
	public void setImgObj2(String nom) {
		String str="/images/" +nom+ ".png";
		super.icoChar=new ImageIcon(getClass().getResource(str));
		super.imgChar = super.icoChar.getImage();
	
	}
	
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public boolean getWalksright() {
		return walksright;
	}

	public void setWalksright(boolean walksright) {
		this.walksright = walksright;
	}

	public boolean getWalksleft() {
		return walksleft;
	}

	public void setWalksleft(boolean walksleft) {
		this.walksleft = walksleft;
	}

	public boolean getWalksdown() {
		return walksdown;
	}

	public void setWalksdown(boolean walksdown) {
		this.walksdown = walksdown;
	}

	public boolean getWalksup() {
		return walksup;
	}

	public void setWalksup(boolean walksup) {
		this.walksup = walksup;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Image Imagewalk(int frequence) {
		String str ="/images/Dash.png";
		ImageIcon ico;
		Image img;
		if(this.walks==false) {
			str="/images/Dash.png";
		}else {
				this.compteur++;
				if(this.compteur/frequence==0) {
					if(this.walksright) {
						str="/images/Dasharretdroit.png";
					}else if(this.walksleft) {
						str="/images/Dasharretgauche.png";
					}else if(this.walksup) {
						str="/images/Dashcreusegauche.png";
					}else if(this.walksdown){
						str="/images/Dashcreusegauchebas.png";
					}
				
				}else {
					if(this.walksright) {
						str="/images/Dashmarchedroitemain.png";
					}else if(this.walksleft) {
						str="/images/Dashmarchegauchemain.png";
					}else if(this.walksup) {
						str="/images/DashcreuseDroite.png";
					}else if(this.walksdown) {
						str="/images/Dashcreusedroitebas.png";
					}
					if(this.compteur==2*frequence) {
						this.compteur=0;
					}
							}
		}
		ico = new ImageIcon(getClass().getResource(str));
		img =ico.getImage();
		return img;
				}
	
	
	
	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}

	public boolean verifyDashLife(Objet objet) {
		if(this.x==objet.getX() && this.y-32==objet.getY()  && objet.velocity>0) {
			return true;
		}else {
		return false;
		}
	}
}
