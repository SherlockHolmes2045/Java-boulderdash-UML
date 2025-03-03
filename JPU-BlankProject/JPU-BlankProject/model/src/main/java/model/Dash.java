package model;

import java.awt.Image;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * @author Lemovou Ivan
 * This class manages the heros of the video game
 */

public class Dash extends Character {

    /**
     * Tell if the character is walking down or left or right or up down
     */
    private boolean walksRight;
    private boolean walksLeft;
    private boolean walksDown;
    private boolean walksUp;

    private int counter;
    /**
     * The score of the character
     */
    private int score;
    /**
     * Tells if the character is doing nothing
     */
    private boolean rest;

    int countanimation = 0;

    private static final String DASH_IMAGE = "/images/Dash.png";

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @see Character
     */

    public Dash(int x, int y) {
        super(x, y, 32, 32);
        this.score = 0;
        super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(DASH_IMAGE)));
        super.imgChar = super.icoChar.getImage();
        super.walks = false;
        this.walksLeft = false;
        this.walksRight = false;
        this.walksUp = false;
        this.walksDown = false;
        this.rest = true;
        this.counter = 0;
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (death) {
                    setImgObj("1");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setImgObj("2");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        time.schedule(task, 10, 640);

        Timer time2 = new Timer();
        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {

                if (death) {

                    if (countanimation < 7) {
                        setY(getY() - 10);
                        countanimation++;
                    } else {
                        setY(getY() + 10);
                    }

                }

            }

        };
        time2.schedule(task2, 10, 100);

        Timer time3 = new Timer();
        TimerTask task3 = new TimerTask() {

            @Override
            public void run() {
                if (rest && !death) {
                    setImgObj2("Dash");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setImgObj2("persoface2");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        };
        time3.schedule(task3, 10, 640);
    }

    /**
     * @param num to put an image
     */

    public void setImgObj(String num) {
        String str = "/images/persomort" + num + ".png";
        super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        super.imgChar = super.icoChar.getImage();

    }

    /**
     * @param nom to put an image also
     */

    public void setImgObj2(String nom) {
        String str = "/images/" + nom + ".png";
        super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        super.imgChar = super.icoChar.getImage();

    }

    public int getCompteur() {
        return counter;
    }

    public void setCompteur(int counter) {
        this.counter = counter;
    }

    /**
     * @return walksRight
     */

    public boolean getWalksright() {
        return walksRight;
    }

    /**
     * @param walksRight setter for walksRight
     */
    public void setWalksright(boolean walksRight) {
        this.walksRight = walksRight;
    }

    /**
     * @return walksLeft
     */

    public boolean getWalksleft() {
        return walksLeft;
    }

    /**
     * @param walksLeft setter for walksLeft
     */
    public void setWalksleft(boolean walksLeft) {
        this.walksLeft = walksLeft;
    }

    /**
     * @return walksDown
     */

    public boolean getWalksdown() {
        return walksDown;
    }

    /**
     * @param walksDown setter for walksDown
     */
    public void setWalksdown(boolean walksDown) {
        this.walksDown = walksDown;
    }

    /**
     * @return walksUp
     */

    public boolean getWalksup() {
        return walksUp;
    }

    /**
     * @param walksUp setter for walksUp
     */
    public void setWalksup(boolean walksUp) {
        this.walksUp = walksUp;
    }

    /**
     * @return score
     */

    public int getScore() {
        return score;
    }

    /**
     * @param score setter for the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @param frequence the value of the frequence
     * @return img
     * animation for the dash
     */

    public Image imageWalk(int frequence) {
        String str = DASH_IMAGE;
        ImageIcon ico;
        Image img;
        if (this.walks) {
            this.counter++;
            if (this.counter / frequence == 0) {
                if (this.walksRight) {
                    str = "/images/Dasharretdroit.png";
                } else if (this.walksLeft) {
                    str = "/images/Dasharretgauche.png";
                } else if (this.walksUp) {
                    str = "/images/Dashcreusegauche.png";
                } else if (this.walksDown) {
                    str = "/images/Dashcreusegauchebas.png";
                }

            } else {
                if (this.walksRight) {
                    str = "/images/Dashmarchedroitemain.png";
                } else if (this.walksLeft) {
                    str = "/images/Dashmarchegauchemain.png";
                } else if (this.walksUp) {
                    str = "/images/DashcreuseDroite.png";
                } else if (this.walksDown) {
                    str = "/images/Dashcreusedroitebas.png";
                }
                if (this.counter == 2 * frequence) {
                    this.counter = 0;
                }
            }
        }
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }


    /**
     * @return rest
     * when the heros don't move
     */

    public boolean isRest() {
        return rest;
    }

    /**
     * @param rest setter for rest
     */
    public void setRest(boolean rest) {
        this.rest = rest;
    }

    /**
     * @param objet the object to test the collison with
     * @return true or false if the heros is in life or death
     */

    public boolean verifyDashLife(Objet objet) {
        return this.x == objet.getX() && this.y - 32 == objet.getY() && objet.velocity > 0;
    }
}
