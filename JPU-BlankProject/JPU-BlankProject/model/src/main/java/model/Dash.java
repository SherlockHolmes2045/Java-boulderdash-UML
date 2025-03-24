package model;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import java.awt.Image;


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

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @see Character
     */

    public Dash(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        this.score = 0;
        try {
            super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.DASH_IMAGE)));
        } catch (NullPointerException e) {
            e.printStackTrace();
            // Handle the error, e.g., set a default image or log the error
        }
        super.imgChar = super.icoChar.getImage();
        super.walks = false;
        this.walksLeft = false;
        this.walksRight = false;
        this.walksUp = false;
        this.walksDown = false;
        this.rest = true;
        this.counter = 0;

        deathAnimationTask();
        deathFallTask();
        idleAnimationTask();

    }

    private void deathAnimationTask() {
        Runnable task = () -> {
            if (death) {
                setImgObj("1");
                setImgObj("2");
            }
        };
        scheduler.scheduleAtFixedRate(task, 10, 640, TimeUnit.MILLISECONDS);
    }

    private void deathFallTask() {
        Runnable task = () -> {
            if (death) {
                if (countanimation < 7) {
                    setY(getY() - 10);
                    countanimation++;
                } else {
                    setY(getY() + 10);
                }
            }
        };
        scheduler.scheduleAtFixedRate(task, 10, 100, TimeUnit.MILLISECONDS);
    }

    private void idleAnimationTask() {
        Runnable task = () -> {
            if (rest && !death) {
                setImgObj2("Dash");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                setImgObj2("persoface2");
            }
        };
        scheduler.scheduleAtFixedRate(task, 10, 640, TimeUnit.MILLISECONDS);
    }

    /**
     * @param num to put an image
     */

    public void setImgObj(String num) {
        String str = "/images/persomort" + num + ".png";
        try {
            super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        } catch (NullPointerException e) {
            e.printStackTrace();
            // Handle the error, e.g., set a default image or log the error
        }
        super.imgChar = super.icoChar.getImage();
    }

    /**
     * @param nom to put an image also
     */

    public void setImgObj2(String nom) {
        String str = "/images/" + nom + ".png";
        try {
            super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        } catch (NullPointerException e) {
            e.printStackTrace();
            // Handle the error, e.g., set a default image or log the error
        }
        super.imgChar = super.icoChar.getImage();
    }

    /**
     * @param walksRight setter for walksRight
     */
    public void setWalksright(boolean walksRight) {
        this.walksRight = walksRight;
    }

    /**
     * @param walksLeft setter for walksLeft
     */
    public void setWalksleft(boolean walksLeft) {
        this.walksLeft = walksLeft;
    }

    /**
     * @param walksDown setter for walksDown
     */
    public void setWalksdown(boolean walksDown) {
        this.walksDown = walksDown;
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
        Map<String, String> walkImages = Map.of(
                "right0", "/images/Dasharretdroit.png",
                "left0", "/images/Dasharretgauche.png",
                "up0", "/images/Dashcreusegauche.png",
                "down0", "/images/Dashcreusegauchebas.png",
                "right1", "/images/Dashmarchedroitemain.png",
                "left1", "/images/Dashmarchegauchemain.png",
                "up1", "/images/DashcreuseDroite.png",
                "down1", "/images/Dashcreusedroitebas.png"
        );

        String key = "";
        if (this.walks) {
            this.counter++;
            key += this.walksRight ? "right" : this.walksLeft ? "left" : this.walksUp ? "up" : "down";
            key += this.counter / frequence == 0 ? "0" : "1";
            if (this.counter == 2 * frequence) {
                this.counter = 0;
            }
        }
        String str = walkImages.getOrDefault(key, GameConstants.DASH_IMAGE);
        ImageIcon ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        return ico.getImage();
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

}
