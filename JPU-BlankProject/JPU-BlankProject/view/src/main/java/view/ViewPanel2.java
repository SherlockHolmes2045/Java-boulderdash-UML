package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Back;
import model.Dash;
import model.Diamond;
import model.ExitDoor;
import model.Ground;
import model.Level;
import model.Monster;
import model.Objet;
import model.Roc;
import model.Wall;

/**
 * Date:02-06-2019
 * The Class ViewPanel2.
 * @author Welaji chris-yvan
 */

public class ViewPanel2 extends JPanel implements Observer{
	
	/** The Constant serialVersionUID */
	private static final long serialVersionUID = 556761802292369776L;
	
	/**
	 * @see ViewPanel
	 */
	private static Level level=new Level(2);
	public static Objet[][] tabObjets;
	public ExitDoor exit1;
	private int nbr_diamond;
	public static Dash dash;
	private int timegame=150;
	int xstar=0,ystar=0;
	private static 	int deathcount;
	private boolean exitable;
	
	/** Arraylist of monsters*/
	public static ArrayList<Monster> tabMonsters;
	
	
	public ViewPanel2() {
		
		dash=new Dash(320,576);
		tabObjets=new Objet[25][51];
		nbr_diamond=12;
		deathcount=0;
		exit1=new ExitDoor(672,704);
		tabMonsters=new ArrayList<Monster>();
		tabObjets=mapImage();
		this.exitable=false;
		
		//timer to handle the gametime
		Timer time = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
			if(timegame<=0) {
			}else {
				timegame--;	
			}
				if(timegame<=0) {
					dash.setDeath(true);
				}
				if(dash.getWalks()==false) {
					dash.setRest(true);
				}
			}
		};
		time.schedule(task,0,1000);
		
		//timer for collision between monster and hero
		Timer time2 = new Timer();
		TimerTask task2= new TimerTask() {

			@Override
			public void run() {
				for(int i=0;i<tabMonsters.size();i++) {
					if(dash.getX()==tabMonsters.get(i).getX() && dash.getY()==tabMonsters.get(i).getY()) {
						dash.setDeath(true);
					}
				}
			}
		};
		time2.schedule(task2,10,100);
		
		Timer time5=new Timer();
		
		TimerTask task5=new TimerTask(){

			@Override
			public void run() {
				int nb = (int) (Math.random() * 4); 
				for(int k=0;k<tabMonsters.size();k++) {
					
					if(tabMonsters.get(k).getWalks()==false) {
						
						for(int i=0;i<24;i++) {
							for(int j=0;j<51;j++) {
								
								if(nb==0) {
								
									if(tabMonsters.get(k).movesRight(tabObjets[i][j])) {
									tabMonsters.get(k).setWalks(true);
									tabMonsters.get(k).setGoesRight(true);
									}else if(tabMonsters.get(k).movesLeft(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesLeft(true);
									}else if(tabMonsters.get(k).movesUp(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesUp(true);
									}else if(tabMonsters.get(k).movesDown(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesDown(true);
									}
							
								}else if(nb==1) {
									
									if(tabMonsters.get(k).movesLeft(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesLeft(true);
										}else if(tabMonsters.get(k).movesRight(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesRight(true);
										}else if(tabMonsters.get(k).movesUp(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesUp(true);
										}else if(tabMonsters.get(k).movesDown(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesDown(true);
										}
									
								}else if(nb==2) {
									
									if(tabMonsters.get(k).movesUp(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesUp(true);
										}else if(tabMonsters.get(k).movesLeft(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesLeft(true);
										}else if(tabMonsters.get(k).movesRight(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesRight(true);
										}else if(tabMonsters.get(k).movesDown(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesDown(true);
										}
									
								}else if(nb==3) {
									
									if(tabMonsters.get(k).movesDown(tabObjets[i][j])) {
										tabMonsters.get(k).setWalks(true);
										tabMonsters.get(k).setGoesDown(true);
										}else if(tabMonsters.get(k).movesLeft(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesLeft(true);
										}else if(tabMonsters.get(k).movesUp(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesUp(true);
										}else if(tabMonsters.get(k).movesRight(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(true);
											tabMonsters.get(k).setGoesRight(true);
										}
									
								}
							
							}
							
						}	
					}else {
						for(int i=0;i<24;i++) {
							
							for(int j=0;j<51;j++) {
							
								if(tabObjets[i][j]!=null) {
									
									if(tabMonsters.get(k).isGoesRight()) {
										
										if(tabMonsters.get(k).DoesnotmovesRight(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(false);
											tabMonsters.get(k).setGoesRight(false);
										}
									}else if(tabMonsters.get(k).isGoesLeft()) {
										if(tabMonsters.get(k).DoesnotmovesLeft(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(false);
											tabMonsters.get(k).setGoesLeft(false);
										}
									}else if(tabMonsters.get(k).isGoesUp()) {
										if(tabMonsters.get(k).DoesnotmovesUp(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(false);
											tabMonsters.get(k).setGoesUp(false);
										}
									}else if(tabMonsters.get(k).isGoesDown()) {
										if(tabMonsters.get(k).DoesnotmovesDown(tabObjets[i][j])) {
											tabMonsters.get(k).setWalks(false);
											tabMonsters.get(k).setGoesDown(false);
											}
										}									
									}
								}
							}
						}
					}
				}
			};
	time5.schedule(task5,300,100);

		
		Timer time3=new Timer();
		TimerTask task3=new TimerTask() {

			@Override
			public void run() {
				
				for(int i=0;i<24;i++) {
					
					for(int j=0;j<51;j++) {
						if(tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
							
							if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j+1].getClass().getName().equals("model.Back") && tabObjets[i+1][j+1].getClass().getName().equals("model.Back")) {
								int x=tabObjets[i][j].getX();
								int y=tabObjets[i][j].getY();
								tabObjets[i][j+1]=tabObjets[i][j];
								tabObjets[i][j]=new Back(x,y);
								tabObjets[i][j+1].setX(tabObjets[i][j].getX()+32);
								}else if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j-1].getClass().getName().equals("model.Back") && tabObjets[i+1][j-1].getClass().getName().equals("model.Back")) {
									int x=tabObjets[i][j].getX();
									int y=tabObjets[i][j].getY();
									tabObjets[i][j-1]=tabObjets[i][j];
									tabObjets[i][j]=new Back(x,y);
									tabObjets[i][j-1].setX(tabObjets[i][j].getX()-32);
								}	
							}
								
						}
					}
				}
		};
		time3.schedule(task3,10,200);
		
		Timer time4=new Timer();
		TimerTask task4= new TimerTask() {

			@Override
			public void run() {
				for(int i=0;i<24;i++) {
					
			for(int j=0;j<51;j++) {
				if(tabObjets[i][j].getClass().getName().equals("model.Roc")) {
					
					if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j+1].getClass().getName().equals("model.Back") && tabObjets[i+1][j+1].getClass().getName().equals("model.Back")) {
						int x=tabObjets[i][j].getX();
						int y=tabObjets[i][j].getY();
						tabObjets[i][j+1]=tabObjets[i][j];
						tabObjets[i][j]=new Back(x,y);
						tabObjets[i][j+1].setX(tabObjets[i][j].getX()+32);
						}else if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond")) && tabObjets[i][j-1].getClass().getName().equals("model.Back") && tabObjets[i+1][j-1].getClass().getName().equals("model.Back")) {
							int x=tabObjets[i][j].getX();
							int y=tabObjets[i][j].getY();
							tabObjets[i][j-1]=tabObjets[i][j];
							tabObjets[i][j]=new Back(x,y);
							tabObjets[i][j-1].setX(tabObjets[i][j].getX()-32);
							}
						}
					}
				}
			}
		};
		time4.schedule(task4,10,200);
			
		Thread  refresh=new Thread(new Refresh2());
		refresh.start();
	}
	
	/**
	 * @param o
	 * observable
	 * @param arg
	 * object
	 */

	@Override
	public void update(Observable o, Object arg) {

	}
	
	/**
	 * @see ViewPanel
	 */
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2=(Graphics2D)g;
		
		for(int i=0;i<24;i++) {
			for(int j=0;j<51;j++) {
			if(tabObjets[i][j]!=null) {
			
				if(tabObjets[i][j].getClass().getName().equals("model.Roc")) {
				
				if(tabObjets[i][j].RightContact(tabObjets[i][j+1])) {
					tabObjets[i][j].setPushableRight(true);
				}else {
					tabObjets[i][j].setPushableRight(false);
				}
				if(tabObjets[i][j].LeftContact(tabObjets[i][j-1])) {
					tabObjets[i][j].setPushableLeft(true);
				}else {
					tabObjets[i][j].setPushableLeft(false);
					}
				
					}
				}
			}
		}
		  
		for(int i=0;i<24;i++) {
				
			for(int j=0;j<51;j++) {
				
				if(tabObjets[i][j].getClass().getName().equals("model.Roc") || tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
					
					if(tabObjets[i][j].NearDown(tabObjets[i+1][j]) && tabObjets[i][j].DownContactDash(dash)==false) {
						int x=tabObjets[i][j].getX();
						int y=tabObjets[i][j].getY();
						tabObjets[i][j].setFalling(true);
						tabObjets[i+1][j]=tabObjets[i][j];
						tabObjets[i][j]=new Back(x,y);
						tabObjets[i+1][j].setY(tabObjets[i+1][j].getY()+32);
						tabObjets[i+1][j].setVelocity(tabObjets[i+1][j].getVelocity()+1);
					}else {
						tabObjets[i][j].setFalling(false);
						tabObjets[i][j].setVelocity(0);
					}
				}
					g2.drawImage(tabObjets[i][j].getImgObj(),tabObjets[i][j].getX(),tabObjets[i][j].getY(),null);	
			}
		}

	
			for(int i=0;i<tabMonsters.size();i++) {
				g2.drawImage(tabMonsters.get(i).getImgChar(),tabMonsters.get(i).getX(),tabMonsters.get(i).getY(),null);
		
			}
			
			if(nbr_diamond<=5) {
			this.exitable=true;
		g2.drawImage(exit1.getImgObj(),exit1.getX(), exit1.getY(),null);
			}
			
			if(dash.getDeath()==false && dash.isRest()==false) {
				g2.drawImage(dash.Imagewalk(50),dash.getX(),dash.getY(),null);	
			}else if(dash.isRest()==true && dash.getDeath()==false) {
				g2.drawImage(dash.getImgChar(),dash.getX(),dash.getY(),null);	
			}else if(dash.getDeath()==true){
				if(deathcount==0) {
					xstar=dash.getX();
					ystar=dash.getY();
				}
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar-32,ystar-64,null);
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar,ystar-64,null);
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar+32,ystar-64,null);
				
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar-32,ystar-32,null);
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar,ystar-32,null);
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar+32,ystar-32,null);
				
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar-32,ystar,null);
				g2.drawImage(new ImageIcon(getClass().getResource("/images/upstar.png")).getImage(),xstar+32,ystar,null);
				g2.drawImage(dash.getImgChar(),dash.getX(),dash.getY(),null);	
				deathcount++;
				
			}
		
		Font font = new Font("Courier", Font.BOLD, 20); 
		  g2.setFont(font); 

		 g2.fillRoundRect(20, 2, 48, 28, 20, 20);
	     g2.fillRoundRect(100, 2, 63, 28, 20, 20);
	     g2.fillRoundRect(100, 35, 63, 28, 20, 20);
	     g2.setColor(Color.BLUE);
	     g2.drawRoundRect(20, 2, 48, 28, 20, 20);
	     g2.drawRoundRect(100, 2, 63, 28, 20, 20);
	     g2.drawRoundRect(100, 35, 63, 28, 20, 20);
	     g2.setColor(Color.WHITE); 
	     g2.drawString(Integer.toString(nbr_diamond),130, 22);
	     g2.drawString(Integer.toString(dash.getScore()),30, 22);
	     g2.drawString(Integer.toString(timegame),125, 57);
	     g2.drawImage(new ImageIcon(getClass().getResource("/images/diam_icon.png")).getImage(),105, 8,null);
	     g2.drawImage(new ImageIcon(getClass().getResource("/images/horloge_icon.png")).getImage(),105,40,null);
	
	}

	/**
	 * 
	 * @see ViewPanel
	 * @return tabObjets
	 */
	private static Objet[][] mapImage(){
		
		Objet[][] tabObjets=new Objet[25][51];

	Objet tmp2=null;
	int xobj=0;
	int yobj=0;

		for(int j=0;j<25;j++) {

			   for(int i=0;i<51;i++){
				   
				  
				  if(level.getMap()[j][i]=='.') {
					  tmp2=new Ground(xobj,yobj);
			
				  	 }else if(level.getMap()[j][i]=='-') {
				  		tmp2=new Wall(xobj,yobj);   
				   
				  	 }else if(level.getMap()[j][i]=='X') {
				  		 tmp2=new Roc(xobj,yobj);
					  
				  	 }else if(level.getMap()[j][i]=='D') {
				 			tmp2=new Diamond(xobj,yobj);
					   }else if(level.getMap()[j][i]==' ') {
						   
						  tmp2=new Back(xobj,yobj);
					   }else if(level.getMap()[j][i]=='M') {
						   tmp2=new Back(xobj,yobj);
						  tabMonsters.add(new Monster(xobj,yobj));
					   }else {
						   tmp2=new Ground(xobj,yobj);
				 	  }   
				  tabObjets[j][i]=tmp2;
				  tmp2=null;
				  xobj+=32;
			   		}
			   xobj=0;
			   yobj+=32;
			   }
 		return tabObjets;
		
	}
	/**
	 * 
	 * @see ViewPanel
	 * @return nbr_diamond
	 */
	public int getNbr_diamond() {
		return nbr_diamond;
	}
	/**
	 * 
	 * @see ViewPanel
	 * @param nbr_diamond
	 * the actual number of diamond
	 */
	
	public void setNbr_diamond(int nbr_diamond) {
		this.nbr_diamond = nbr_diamond;
	}
	/**
	 * 
	 * @see ViewPanel
	 * @return exitable
	 * 
	 */
	
	public boolean isExitable() {
		return exitable;
	}
	/**
	 * 
	 * @see ViewPanel
	 * @param exitable
	 * the new value of exitable
	 * 
	 */
	
	public void setExitable(boolean exitable) {
		this.exitable = exitable;
	}
	/**
	 * 
	 * @see ViewPanel
	 * @return timegame
	 */
	
	public int getTimegame() {
		return timegame;
	}
	
	
}
