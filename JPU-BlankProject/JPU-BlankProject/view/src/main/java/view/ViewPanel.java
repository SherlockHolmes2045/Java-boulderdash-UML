package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import java.util.*;

import javax.swing.ImageIcon;

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
 * @author Welaji chris-yvan.
 */

public class ViewPanel extends ApplicationPanel implements Observer {

    /**
     * An instantiation of the Level class,the paramater of the constructor define the level to fetch.
     */
    static Level level = new Level(1);

    /**
     * An array of all the immobile elements of the game
     */
    public static Objet[][] tabObjets;

    /**
     * The hero
     */
    public static Dash dash;

    private final ExitDoor exit1;

    private int diamondCount;


    /**
     * The duration of the game in seconds
     */
    private int gameDuration = 120;

    private static int deathCount;
    /**
     * A boolean that defines if we can exit the level or not
     */

    private boolean exitable;

    int xstar = 0;
    int ystar = 0;

    /**
     * The Constant serialVersionUID.
     */

    @Serial
    private static final long serialVersionUID = -998294702363713521L;

    private static final int PAUSE = 3;


    /**
     * Instantiates a new view panel.
     */

    public ViewPanel() {

        setDiamondCount(20);
        dash = new Dash(224, 128);
        tabObjets = new Objet[25][51];
        tabObjets = mapImage();
        exit1 = new ExitDoor(1344, 544);
        this.exitable = false;

        // This timer handles the gametime
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (gameDuration > 0) {
                    gameDuration--;
                }

                if (gameDuration <= 0) {
                    dash.setDeath(true);
                }

                if (!dash.getWalks()) {
                    dash.setRest(true);
                }
            }
        };
        time.schedule(task, 0, 1000);

        //This timer controll that a diamond empile on another one or a roc falls if there is space

        Timer time3 = new Timer();
        TimerTask task3 = new TimerTask() {

            @Override
            public void run() {

                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (tabObjets[i][j] instanceof model.Diamond) {

                            if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j + 1] instanceof model.Back && tabObjets[i + 1][j + 1] instanceof model.Back && ((tabObjets[i][j].getX() + 32 != dash.getX() && tabObjets[i][j].getY() != dash.getY()) || (tabObjets[i][j].getX() + 32 != dash.getX() && tabObjets[i][j].getY() + 32 != dash.getY()))) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j + 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j + 1].setX(tabObjets[i][j].getX() + 32);
                            } else if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j - 1] instanceof model.Back && tabObjets[i + 1][j - 1] instanceof model.Back && ((tabObjets[i][j].getX() - 32 != dash.getX() && tabObjets[i][j].getY() != dash.getY()) || (tabObjets[i][j].getX() - 32 != dash.getX() && tabObjets[i][j].getY() + 32 != dash.getY()))) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j - 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j - 1].setX(tabObjets[i][j].getX() - 32);
                            }
                        }

                    }
                }
            }
        };
        time3.schedule(task3, 10, 250);

        //This timer controll that a roc empile on another one or a diamond falls if there is space

        Timer time4 = new Timer();
        TimerTask task4 = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 24; i++) {

                    for (int j = 0; j < 51; j++) {
                        if (tabObjets[i][j] instanceof model.Roc) {

                            if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j + 1] instanceof model.Back && tabObjets[i + 1][j + 1] instanceof model.Back && ((tabObjets[i][j].getX() + 32 != dash.getX() && tabObjets[i][j].getY() != dash.getY()) || (tabObjets[i][j].getX() + 32 != dash.getX() && tabObjets[i][j].getY() + 32 != dash.getY()))) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j + 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j + 1].setX(tabObjets[i][j].getX() + 32);
                            } else if ((tabObjets[i + 1][j] instanceof model.Roc || tabObjets[i + 1][j] instanceof model.Diamond) && tabObjets[i][j - 1] instanceof model.Back && tabObjets[i + 1][j - 1] instanceof model.Back && ((tabObjets[i][j].getX() - 32 != dash.getX() && tabObjets[i][j].getY() != dash.getY()) || (tabObjets[i][j].getX() - 32 != dash.getX() && tabObjets[i][j].getY() + 32 != dash.getY()))) {
                                int x = tabObjets[i][j].getX();
                                int y = tabObjets[i][j].getY();
                                tabObjets[i][j - 1] = tabObjets[i][j];
                                tabObjets[i][j] = new Back(x, y);
                                tabObjets[i][j - 1].setX(tabObjets[i][j].getX() - 32);
                            }


                        }

                    }
                }

            }
        };
        time4.schedule(task4, 10, 250);

        // The refresh thread

        Thread refresh = new Thread(new Refresh(PAUSE,this));
        refresh.start();
    }


    /**
     * @param arg0 Observable
     * @param arg1 object
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */

    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }


    /**
     * @param graphics An awt element that allows to draw components
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */

    @Override

    protected void paintComponent(final Graphics graphics) {


        Graphics2D g2 = (Graphics2D) graphics;

        //Check and set the pushable attribute of the rocks

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 51; j++) {

                if (tabObjets[i][j] instanceof model.Roc) {

                    tabObjets[i][j].setPushableRight(tabObjets[i][j].rightContact(ViewPanel.tabObjets[i][j + 1]));

                    tabObjets[i][j].setPushableLeft(tabObjets[i][j].leftContact(ViewPanel.tabObjets[i][j - 1]));
                }
            }
        }
		
		/*for(int i=0;i<24;i++) {
			for(int j=0;j<51;j++) {
			
			if(tabObjets[i][j].getClass().getName().equals("model.Roc") ||tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
				
				if(dash.getX()==tabObjets[i][j].getX() && dash.getY()-32==tabObjets[i][j].getY() && tabObjets[i][j].getVelocity()>0) {
					dash.setDeath(true);
					//System.out.println("meurt");
				}else {
					dash.setDeath(false);
					//System.out.println("vie");
				}
			}
		}
		
	}*/
        //Check if the rock or the diamond can fall
        for (int i = 0; i < 24; i++) {

            for (int j = 0; j < 51; j++) {

                if (tabObjets[i][j] instanceof model.Roc) {

                    if (tabObjets[i][j].getVelocity() == 0) {
                        if (tabObjets[i][j].nearDown(tabObjets[i + 1][j]) && !tabObjets[i][j].downContactDash(dash)) {
                            int x = tabObjets[i][j].getX();
                            int y = tabObjets[i][j].getY();
                            tabObjets[i][j].setFalling(true);
                            tabObjets[i][j] = new Back(x, y);
                            tabObjets[i + 1][j] = new Roc(x, y);
                            tabObjets[i + 1][j].setY(tabObjets[i + 1][j].getY() + 32);
                            tabObjets[i + 1][j].setVelocity(tabObjets[i + 1][j].getVelocity() + 1);
                        } else {
                            tabObjets[i][j].setFalling(false);
                            tabObjets[i][j].setVelocity(0);
                        }
                    } else if (tabObjets[i][j].getVelocity() > 0) {
                        if (tabObjets[i][j].nearDown(tabObjets[i + 1][j])) {
                            int x = tabObjets[i][j].getX();
                            int y = tabObjets[i][j].getY();
                            tabObjets[i][j].setFalling(true);
                            tabObjets[i][j] = new Back(x, y);
                            tabObjets[i + 1][j] = new Roc(x, y);
                            tabObjets[i + 1][j].setY(tabObjets[i + 1][j].getY() + 32);
                            tabObjets[i + 1][j].setVelocity(tabObjets[i + 1][j].getVelocity() + 1);
                        } else {
                            tabObjets[i][j].setFalling(false);
                            tabObjets[i][j].setVelocity(0);
                        }
                    }

                } else if (tabObjets[i][j] instanceof model.Diamond) {

                    if (tabObjets[i][j].nearDown(tabObjets[i + 1][j]) && !tabObjets[i][j].downContactDash(dash)) {
                        int x = tabObjets[i][j].getX();
                        int y = tabObjets[i][j].getY();
                        tabObjets[i][j].setFalling(true);
                        tabObjets[i][j] = new Back(x, y);
                        tabObjets[i + 1][j] = new Diamond(x, y);
                        tabObjets[i + 1][j].setY(tabObjets[i + 1][j].getY() + 32);
                        tabObjets[i + 1][j].setVelocity(tabObjets[i + 1][j].getVelocity() + 1);
                    } else {
                        tabObjets[i][j].setFalling(false);
                        tabObjets[i][j].setVelocity(0);
                    }
                }
                g2.drawImage(tabObjets[i][j].getImgObj(), tabObjets[i][j].getX(), tabObjets[i][j].getY(), null);
            }
        }

        //determine the method to call to get the hero image
        if (!dash.getDeath() && !dash.isRest()) {
            g2.drawImage(dash.imageWalk(50), dash.getX(), dash.getY(), null);
        } else if (dash.isRest() && !dash.getDeath()) {
            g2.drawImage(dash.getImgChar(), dash.getX(), dash.getY(), null);
        } else if (dash.getDeath()) {
            if (deathCount == 0) {
                xstar = dash.getX();
                ystar = dash.getY();
            }
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar - 32, ystar - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar, ystar - 64, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar + 32, ystar - 64, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar - 32, ystar - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar, ystar - 32, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar + 32, ystar - 32, null);

            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar - 32, ystar, null);
            g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/upstar.png"))).getImage(), xstar + 32, ystar, null);
            g2.drawImage(dash.getImgChar(), dash.getX(), dash.getY(), null);
            deathCount++;

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

        //Draw the score,the time and the number of diamond remaining
        if (getDiamondCount() <= 10) {
            this.exitable = true;
            g2.drawImage(getExit1().getImgObj(), getExit1().getX(), getExit1().getY(), null);
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
        g2.drawString(Integer.toString(getDiamondCount()), 130, 22);
        g2.drawString(Integer.toString(dash.getScore()), 30, 22);
        g2.drawString(Integer.toString(gameDuration), 125, 57);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/diam_icon.png"))).getImage(), 105, 8, null);
        g2.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/horloge_icon.png"))).getImage(), 105, 40, null);
    }


    /**
     * @return tabObjets
     * <p>
     * Instanciate the correspondant objet for the character read from the array
     */

    private Objet[][] mapImage() {

        Objet[][] tabObjets = new Objet[25][51];

        Objet tmp2 = null;
        int xobj = 0;
        int yobj = 0;

        for (int j = 0; j < 25; j++) {

            for (int i = 0; i < 51; i++) {


                if (level.getMap()[j][i] == '.') {
                    tmp2 = new Ground(xobj, yobj);

                } else if (level.getMap()[j][i] == '-') {
                    tmp2 = new Wall(xobj, yobj);

                } else if (level.getMap()[j][i] == 'X') {
                    tmp2 = new Roc(xobj, yobj);

                } else if (level.getMap()[j][i] == 'D') {
                    tmp2 = new Diamond(xobj, yobj);
                } else if (level.getMap()[j][i] == ' ') {

                    tmp2 = new Back(xobj, yobj);
                } else {
                    tmp2 = new Ground(xobj, yobj);
                }
                tabObjets[j][i] = tmp2;
                tmp2 = null;
                xobj += 32;
            }
            xobj = 0;
            yobj += 32;
        }
        return tabObjets;
    }


    /**
     * @return exitable
     * <p>
     * getter for exitable
     */
    public boolean isExitable() {
        return exitable;
    }

    /**
     * @return gameDuration
     * <p>
     * getter for the gameDuration
     */
    public int getTimegame() {
        return gameDuration;
    }

    /**
     * The number of diamond of the level
     */ /**
     * @return diamondCount
     * <p>
     * getter for the number diamond
     */
    public int getDiamondCount() {
        return diamondCount;
    }

    /**
     * @param diamondCount setter for the number of diamond
     */
    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }


    /**
     * The exitdoor of the level
     */
    public ExitDoor getExit1() {
        return exit1;
    }
}