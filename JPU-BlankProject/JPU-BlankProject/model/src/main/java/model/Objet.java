package model;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * @author Lemovou Ivan
 * the class Objet superclass of all the objects
 */

public class Objet {

    /**
     * This variable gives the path to the image
     */
    protected ImageIcon icoObj;

    /**
     * This variable contains the image
     */
    protected Image imgObj;

    /**
     * The x and y coordonates of the object
     */
    protected int x;
    protected int y;

    /**
     * the height and the width of the object
     */
    protected int width;
    protected int height;

    protected int counter;

    /**
     * Tells if the Object is falling or not
     */
    protected boolean falling;

    /**
     * Give the speed of the Object
     */
    protected int velocity;

    /**
     * Tell if the object is pushable right or left
     */

    protected boolean pushableLeft;
    protected boolean pushableRight;

    /**
     * @param x      The x coordinate
     * @param y      The y coordinate
     * @param width  The width
     * @param height The height
     */

    public Objet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.counter = 0;
        this.pushableLeft = false;
        this.pushableRight = false;

    }

    /**
     * @return velocity
     * get the speed of the object
     */

    public int getVelocity() {
        return velocity;
    }

    /**
     * @param velocity define the speed of the object
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * @return counter
     * getter of the variable counter
     */

    public int getCounter() {
        return counter;
    }

    /**
     * @param counter setter of the counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @param objet the object to test the collision with
     * @return return true if there is a collision and false if not
     */
    public boolean downContact(Objet objet) {
        return this.x == objet.getX() && this.y + 32 == objet.getY();
    }

    /**
     * @param objet the object to test the collision with
     * @return return true if there is a collision and false if not
     */

    public boolean leftContact(Objet objet) {
        return this.x - 32 == objet.getX() && this.y == objet.getY() && objet instanceof Back;
    }

    /**
     * @param objet the object to test the collision with
     * @return return true if there is a collision and false if not
     */

    public boolean rightContact(Objet objet) {
        return this.x + 32 == objet.getX() && this.y == objet.getY() && objet instanceof model.Back;
    }

    /**
     * @param character the character to test the collision with
     * @return return true if there is a collision and false if not
     */
    public boolean downContactDash(Character character) {
        return this.x == character.getX() && this.y + 32 == character.getY();
    }

    /**
     * @param objet the object to test the proximity with
     * @return return true if there is a collision and false if not
     */
    public boolean nearDown(Objet objet) {
        return this.x == objet.getX() && this.y + 32 == objet.getY() && objet instanceof Back;
    }

    /**
     * @return getter for x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x setter for x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * sets the image of the object
     */
    public void setImgObj() {
        String str = "/images/solnoir.png";
        this.icoObj = new ImageIcon(str);
        this.imgObj = this.icoObj.getImage();
    }

    /**
     * @return return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @param y setter of the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return getter of the image
     */
    public Image getImgObj() {
        return imgObj;
    }

    /**
     * @return getter of falling
     */
    public boolean getFalling() {
        return falling;
    }

    /**
     * @param falling setter of falling
     */
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    /**
     * @return getter of pushableLeft
     */
    public boolean getPushableLeft() {
        return pushableLeft;
    }

    /**
     * @param pushableLeft setter of pushableLeft
     */
    public void setPushableLeft(boolean pushableLeft) {
        this.pushableLeft = pushableLeft;
    }

    /**
     * @return getter of pushableRight
     */
    public boolean getPushableRight() {
        return pushableRight;
    }

    /**
     * @param pushableRight setter of pushableRight
     */
    public void setPushableRight(boolean pushableRight) {
        this.pushableRight = pushableRight;
    }
}
