package model;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author Lemovou Ivan
 * The class Character, it is the class that manages every character in the video game
 */

public class Character {
    /**
     * @see Objet
     */
    protected ImageIcon icoChar;
    protected Image imgChar;

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    /**
     * Tells if the hero can walk or not
     */
    protected boolean walks;

    /**
     * Tells if the Hero is death or not
     */
    protected boolean death;


    /**
     * @param x      the x coordinate
     * @param y      the y coordinate
     * @param width  the width value
     * @param height It is about the width, height and position of character
     */

    public Character(int x, int y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.death = false;
    }

    /**
     * @return imgChar means that it is returns the character image
     */

    public Image getImgChar() {
        if (imgChar == null) {
            loadCharacterImage();
        }
        return imgChar;
    }

    private void loadCharacterImage() {
        String imagePath = "/images/character.png"; // Example path
        this.icoChar = new ImageIcon(imagePath);
        this.imgChar = this.icoChar.getImage();
    }

    /**
     * @return x, the position of the character
     */

    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the character.
     *
     * @param x the new x coordinate
     * @see Objet
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y
     */

    public int getY() {
        return y;
    }

    /**
     * @param y setter for the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return width
     * To obtain the width of the character
     */

    public int getWidth() {
        return width;
    }

    /**
     * @return height
     * To obtain the height of the character
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return walks
     * Tells if the character can move
     */

    public boolean getWalks() {
        return walks;
    }

    /**
     * @param walks setter for walk
     */
    public void setWalks(boolean walks) {
        this.walks = walks;
    }

    /**
     * @param objet the object to test the collison with
     * @return boolean parameter
     * To detect the contact with an object to the side precise
     */

    public boolean leftContact(Objet objet) {
        if (objet == null) {
            return false;
        }
        return this.x - GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY();
    }

    /**
     * @param objet the object to test the collison with
     * @return boolean parameter
     * To detect the contact with an object to the side precise
     */

    public boolean rightContact(Objet objet) {
        if (objet == null) {
            return false;
        }
        return this.x + GameConstants.PIXEL_SIZE == objet.getX() && this.y == objet.getY();
    }

    /**
     * @param objet the object to test the collison with
     * @return boolean parameter
     * To detect the contact with an object to the side precise
     */

    public boolean upContact(Objet objet) {
        if (objet == null) {
            return false;
        }
        return this.x == objet.getX() && this.y - GameConstants.PIXEL_SIZE == objet.getY();
    }

    /**
     * @param objet the object to test the collison with
     * @return boolean parameter
     * To detect the contact with an object to the side precise
     */

    public boolean downContact(Objet objet) {
        if (objet == null) {
            return false;
        }
        return this.x == objet.getX() && this.y + GameConstants.PIXEL_SIZE == objet.getY();
    }

    /**
     * @return death
     * getter for death
     */

    public boolean isDead() {
        return death;
    }

    /**
     * @param death setter for death
     */
    public void setDead(boolean death) {
        this.death = death;
    }

}
