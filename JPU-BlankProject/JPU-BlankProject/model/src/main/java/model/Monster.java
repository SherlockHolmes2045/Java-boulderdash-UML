package model;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * @author Lemovou Ivan
 * the class Monster
 */
public class Monster extends Character {

    /**
     * tell if the monster is going left or right or up or down
     */
    private boolean goesLeft;
    private boolean goesRight;
    private boolean goesUp;
    private boolean goesDown;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     *          the coordinates of the monster
     */
    public Monster(int x, int y) {
        super(x, y, 32, 32);
        super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.MONSTER_IMAGE)));
        super.imgChar = super.icoChar.getImage();
        super.walks = false;
        this.goesDown = false;
        this.goesRight = false;
        this.goesLeft = false;
        movementAnimation();
    }

    private void movementAnimation() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (getWalks()) {
                    if (goesRight) {
                        setX(getX() + GameConstants.PIXEL_SIZE);
                    } else if (goesLeft) {
                        setX(getX() - GameConstants.PIXEL_SIZE);
                    } else if (goesUp) {
                        setY(getY() - GameConstants.PIXEL_SIZE);
                    } else if (goesDown) {
                        setY(getY() + GameConstants.PIXEL_SIZE);
                    }
                }
            }
        };
        time.schedule(task, 100, 110);
    }

    /**
     * @return getter of goesleft
     */
    public boolean isGoesLeft() {
        return goesLeft;
    }

    /**
     * @param goesLeft setter of the goesleft
     */
    public void setGoesLeft(boolean goesLeft) {
        this.goesLeft = goesLeft;
    }

    /**
     * @return getter of goesright
     */
    public boolean isGoesRight() {
        return goesRight;
    }

    /**
     * @param goesRight setter of goesright
     */
    public void setGoesRight(boolean goesRight) {
        this.goesRight = goesRight;
    }

    /**
     * @return getter of goesup
     */
    public boolean isGoesUp() {
        return goesUp;
    }

    /**
     * @param goesUp setter of goesup
     */
    public void setGoesUp(boolean goesUp) {
        this.goesUp = goesUp;
    }

    /**
     * @return getter of goesdown
     */
    public boolean isGoesDown() {
        return goesDown;
    }

    /**
     * @param goesDown setter of goesdown
     */
    public void setGoesDown(boolean goesDown) {
        this.goesDown = goesDown;
    }

    /**
     * @param objet the object to test the collision with
     * @return tells if the right object is a back
     */
    public boolean canMoveRight(Objet objet) {

        return objet != null && this.x + GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY() && objet instanceof model.Back;
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the left object is a back
     */
    public boolean canMoveLeft(Objet objet) {

        return objet != null && this.x - GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY() && objet instanceof model.Back;
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the up object is a back
     */
    public boolean canMoveUp(Objet objet) {

        return objet != null && this.x == objet.getX() && this.y - GameConstants.PIXEL_SIZE == objet.getY() && objet instanceof model.Back;
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the down object is back
     */
    public boolean canMoveDown(Objet objet) {

        return objet != null && this.x == objet.getX() && this.y + GameConstants.PIXEL_SIZE == objet.getY() && objet instanceof model.Back;
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the monster cannot move in the precise direction
     */
    public boolean doesNotMoveLeft(Objet objet) {
        return objet != null && this.x - GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY() && !(objet instanceof model.Back);
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the monster cannot move in the precise direction
     */
    public boolean doesNotMoveRight(Objet objet) {
        return objet != null && this.x + GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY() && !(objet instanceof model.Back);
    }

    /**
     * @param objet the Object to test the collision with
     * @return tells if the monster cannot move in the precise direction
     */
    public boolean doesNotMoveUp(Objet objet) {
        return objet != null && this.x == objet.getX() && this.y - GameConstants.PIXEL_SIZE == objet.getY() && !(objet instanceof model.Back);
    }

    /**
     * @param objet to object to test the collision with
     * @return tells if the monster cannot move in the precise direction
     */
    public boolean doesNotMoveDown(Objet objet) {
        return objet != null && this.x == objet.getX() && this.y + GameConstants.PIXEL_SIZE == objet.getY() && !(objet instanceof model.Back);
    }
}
