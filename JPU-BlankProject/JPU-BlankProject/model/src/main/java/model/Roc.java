package model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import java.util.Objects;

import javax.swing.ImageIcon;


/**
 * @author Lemovou Ivan
 * the class Roc
 */
public class Roc extends Objet {


    public Roc(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.ROC_IMAGE)));
        super.imgObj = super.icoObj.getImage();
        super.falling = false;
        super.velocity = 0;
        rocAnimation();
    }

    private void rocAnimation() {
       ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            if (!falling) {
                setImgObj2("rocher_droite");
                executor.schedule(() -> setImgObj2("rocher_gauche"), 300, TimeUnit.MILLISECONDS);
            } else {
                executor.shutdown();
            }
        }, 10, 640, TimeUnit.MILLISECONDS);
    }

    /**
     * @param name the name of the image for the roc animation
     */
    public void setImgObj2(String name) {
        String str = "/images/" + name + ".png";
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        super.imgObj = super.icoObj.getImage();
    }
}
