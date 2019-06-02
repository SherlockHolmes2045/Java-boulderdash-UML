package view;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import model.Objet;
import model.Roc;
import model.Wall;



/**

 * The Class ViewPanel.

 *

 * @author Jean-Aymeric Diet

 */

public class ViewPanel extends JPanel implements Observer {

	static Level level=new Level(1);
	
	public static Objet[][] tabObjets;
	public static Dash dash;
	static Objet rocher;
	public ExitDoor exit1;
	public static int nbr_diamant;
	/** The view frame. */
	private static int compt=8;
	private static  int timegame=120;
	private ViewFrame					viewFrame;
	private static 	int deathcount;
	private boolean exitable;
	int xstar=0,ystar=0;

	/** The Constant serialVersionUID. */

	private static final long	serialVersionUID	= -998294702363713521L;

	
	/**

	 * Instantiates a new view panel.

	 *

	 * @param viewFrame

	 *          the view frame

	 */

	public ViewPanel(/*final ViewFrame viewFrame*/) {
		
		nbr_diamant=20;
		dash=new Dash(224,128);
		tabObjets=new Objet[25][51];
		tabObjets=mapImage();
	    rocher=tabObjets[4][6];
	    exit1=new ExitDoor(1344,544);
		this.exitable=false;
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
		Timer time3=new Timer();
		TimerTask task3=new TimerTask() {

			@Override
			public void run() {
				
				for(int i=0;i<24;i++) {
					
					for(int j=0;j<51;j++) {
						if(tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
							
							if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j+1].getClass().getName().equals("model.Back") && tabObjets[i+1][j+1].getClass().getName().equals("model.Back") &&  ((tabObjets[i][j].getX()+32!=dash.getX() && tabObjets[i][j].getY()!=dash.getY()) || (tabObjets[i][j].getX()+32!=dash.getX()&&tabObjets[i][j].getY()+32!=dash.getY()))) {
								int x=tabObjets[i][j].getX();
								int y=tabObjets[i][j].getY();
								tabObjets[i][j+1]=tabObjets[i][j];
								tabObjets[i][j]=new Back(x,y);
								tabObjets[i][j+1].setX(tabObjets[i][j].getX()+32);
								}else if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j-1].getClass().getName().equals("model.Back") && tabObjets[i+1][j-1].getClass().getName().equals("model.Back") &&  ((tabObjets[i][j].getX()-32!=dash.getX() && tabObjets[i][j].getY()!=dash.getY()) || (tabObjets[i][j].getX()-32!=dash.getX()&&tabObjets[i][j].getY()+32!=dash.getY()))) {
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
		time3.schedule(task3,10,250);	
		
		Timer time4=new Timer();
		TimerTask task4= new TimerTask() {

			@Override
			public void run() {
		for(int i=0;i<24;i++) {
					
			for(int j=0;j<51;j++) {
				if(tabObjets[i][j].getClass().getName().equals("model.Roc")) {
					
					if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond"))&& tabObjets[i][j+1].getClass().getName().equals("model.Back") && tabObjets[i+1][j+1].getClass().getName().equals("model.Back") && ((tabObjets[i][j].getX()+32!=dash.getX() && tabObjets[i][j].getY()!=dash.getY()) || (tabObjets[i][j].getX()+32!=dash.getX()&&tabObjets[i][j].getY()+32!=dash.getY()))) {
						int x=tabObjets[i][j].getX();
						int y=tabObjets[i][j].getY();
						tabObjets[i][j+1]=tabObjets[i][j];
						tabObjets[i][j]=new Back(x,y);
						tabObjets[i][j+1].setX(tabObjets[i][j].getX()+32);
						}else if((tabObjets[i+1][j].getClass().getName().equals("model.Roc") || tabObjets[i+1][j].getClass().getName().equals("model.Diamond")) && tabObjets[i][j-1].getClass().getName().equals("model.Back") && tabObjets[i+1][j-1].getClass().getName().equals("model.Back") && ((tabObjets[i][j].getX()-32!=dash.getX() && tabObjets[i][j].getY()!=dash.getY()) || (tabObjets[i][j].getX()-32!=dash.getX()&&tabObjets[i][j].getY()+32!=dash.getY()))) {
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
		time4.schedule(task4,10,250);
		Thread  refresh=new Thread(new Refresh());
		refresh.start();
	}



	/**

	 * Gets the view frame.

	 *

	 * @return the view frame

	 */

	/*private ViewFrame getViewFrame() {

		return this.viewFrame;

	}*/



	/**

	 * Sets the view frame.

	 *

	 * @param viewFrame

	 *          the new view frame

	 */

	/*private void setViewFrame(final ViewFrame viewFrame) {

		this.viewFrame = viewFrame;

	}*/



	/*

	 * (non-Javadoc)

	 *

	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)

	 */

	public void update(final Observable arg0, final Object arg1) {

		this.repaint();

	}



	/*

	 * (non-Javadoc)

	 *

	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)

	 */

	@Override

	protected void paintComponent(final Graphics graphics) {

		Graphics2D g2=(Graphics2D)graphics;
	//	System.out.println(rocher.getX() + " " + rocher.getY());
		for(int i=0;i<24;i++) {
			for(int j=0;j<51;j++) {
			if(ViewPanel.tabObjets[i][j]!=null) {
			
				if(ViewPanel.tabObjets[i][j].getClass().getName().equals("model.Roc")) {
				
				if(ViewPanel.tabObjets[i][j].contactDroite(ViewPanel.tabObjets[i][j+1])) {
					ViewPanel.tabObjets[i][j].setPushableRight(true);
				}else {
					ViewPanel.tabObjets[i][j].setPushableRight(false);
				}
				
				
				if(ViewPanel.tabObjets[i][j].contactGauche(ViewPanel.tabObjets[i][j-1])) {
					ViewPanel.tabObjets[i][j].setPushableLeft(true);
				}else {
					ViewPanel.tabObjets[i][j].setPushableLeft(false);
					}
				
					}
				}
			}
		}
		
		for(int i=0;i<24;i++) {
			for(int j=0;j<51;j++) {
			
			if(tabObjets[i][j].getClass().getName().equals("model.Roc") ||tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
				
				if(dash.getX()==tabObjets[i][j].getX() && dash.getY()==tabObjets[i][j].getY()) {
					dash.setDeath(true);
					System.out.println("meurt");
				}else {
					dash.setDeath(false);
					System.out.println("vie");
				}
			}
		}
		
	}
		
				    
		for(int i=0;i<24;i++) {
				
			for(int j=0;j<51;j++) {
				
				if(tabObjets[i][j].getClass().getName().equals("model.Roc") ) {
					
					if(tabObjets[i][j].getVelocity()==0) {
					if(tabObjets[i][j].procheBas(tabObjets[i+1][j]) && tabObjets[i][j].contactBasDash(dash)==false) {
						int x=tabObjets[i][j].getX();
						int y=tabObjets[i][j].getY();
						tabObjets[i][j].setFalling(true);
						tabObjets[i][j]=new Back(x,y);
						tabObjets[i+1][j]=new Roc(x,y);
						tabObjets[i+1][j].setY(tabObjets[i+1][j].getY()+32);
						tabObjets[i+1][j].setVelocity(tabObjets[i+1][j].getVelocity()+1);
					}else {
						tabObjets[i][j].setFalling(false);
						tabObjets[i][j].setVelocity(0);
					}
					}else if (tabObjets[i][j].getVelocity()>0) {
						if(tabObjets[i][j].procheBas(tabObjets[i+1][j])) {
							int x=tabObjets[i][j].getX();
							int y=tabObjets[i][j].getY();
							tabObjets[i][j].setFalling(true);
							tabObjets[i][j]=new Back(x,y);
							tabObjets[i+1][j]=new Roc(x,y);
							tabObjets[i+1][j].setY(tabObjets[i+1][j].getY()+32);
							tabObjets[i+1][j].setVelocity(tabObjets[i+1][j].getVelocity()+1);
						}else {
							tabObjets[i][j].setFalling(false);
							tabObjets[i][j].setVelocity(0);
						}
						
						
					}
					
				}else if(tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
					
					if(tabObjets[i][j].procheBas(tabObjets[i+1][j]) && tabObjets[i][j].contactBasDash(dash)==false) {
						int x=tabObjets[i][j].getX();
						int y=tabObjets[i][j].getY();
						tabObjets[i][j].setFalling(true);
						tabObjets[i][j]=new Back(x,y);
						tabObjets[i+1][j]=new Diamond(x,y);
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
				
						//System.out.println(rocher.getY());
						//System.out.println(" case depart " + tabObjets[4][6].getClass().getName());
						/*System.out.println(" case depart " + tabObjetsPerdus[5][6].getY());
						System.out.println(" case d'avant " + tabObjets[4][29].getClass().getName());
						if(tabObjetsPerdus[5][6]!=null) {
							System.out.println(" case suivante " + tabObjetsPerdus[5][6].getClass().getName());
						}
						if(tabObjetsPerdus[6][6]!=null) {
							System.out.println(" case suivante++ " + tabObjetsPerdus[6][6].getClass().getName());
						}*/
						if(nbr_diamant<=10) {
							this.exitable=true;
					g2.drawImage(exit1.getImgObj(),exit1.getX(), exit1.getY(),null);
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
				     g2.drawString(Integer.toString(nbr_diamant),130, 22);
				     g2.drawString(Integer.toString(dash.getScore()),30, 22);
				     g2.drawString(Integer.toString(timegame),125, 57);
				     g2.drawImage(new ImageIcon(getClass().getResource("/images/diam_icon.png")).getImage(),105, 8,null);
				     g2.drawImage(new ImageIcon(getClass().getResource("/images/horloge_icon.png")).getImage(),105,40,null);
				   /*  try {
						Thread.sleep(80);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     repaint();*/
	}

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
				  	//	tabObjetsPerdus[j][i]=tmp2/*new Roc(xobj,yobj)*/;
					  
				  	 }else if(level.getMap()[j][i]=='D') {
				 			tmp2=new Diamond(xobj,yobj);
				  		// tabObjetsPerdus[j][i]=tmp2/*new Diamond(xobj,yobj)*/;
					   }else if(level.getMap()[j][i]==' ') {
						   
						  tmp2=new Back(xobj,yobj);
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



	public boolean isExitable() {
		return exitable;
	}
	
	
	
}