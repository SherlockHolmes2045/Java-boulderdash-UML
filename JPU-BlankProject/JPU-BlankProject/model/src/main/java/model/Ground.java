package model;

import javax.swing.ImageIcon;
import java.util.Objects;


/**
 * @author Lemovou Ivan
 * This class manages all about ground object
 */

public class Ground extends Objet {

    /**
     * @param x the x coordinate
     * @param y the x coordinate
     * @see Objet
     */

    public Ground(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.GROUND_IMAGE)));
        super.imgObj = super.icoObj.getImage();
    }

}
