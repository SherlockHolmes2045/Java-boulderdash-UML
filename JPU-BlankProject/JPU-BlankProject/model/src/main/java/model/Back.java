package model;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The class Character, it is the class that manages every character in the video game
 * 
 * @author Lemovou Ivan
 */
public class Back extends Objet {
    private static final Logger logger = Logger.getLogger(Back.class.getName());

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @see Objet
     */
    public Back(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
    }

    @Override
    public Image getImgObj() {
        if (super.imgObj == null) {
            try {
                super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.BACK_IMAGE)));
                super.imgObj = super.icoObj.getImage();
            } catch (NullPointerException e) {
                logger.log(Level.SEVERE, "Resource not found: " + GameConstants.BACK_IMAGE, e);
            }
        }
        return super.imgObj;
    }

    @Override
    public String toString() {
        return String.format("Back{x=%d, y=%d, width=%d, height=%d}", x, y, width, height);
    }
}
