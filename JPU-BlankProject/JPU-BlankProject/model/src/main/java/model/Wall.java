package model;

import javax.swing.ImageIcon;
import java.util.Objects;

/**
 * @author Lemovou Ivan
 * the class Objet
 */
public class Wall extends Objet {
    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Wall(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.WALL_IMAGE)));
        super.imgObj = super.icoObj.getImage();
    }

}
