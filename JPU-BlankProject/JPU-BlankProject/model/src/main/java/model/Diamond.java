package model;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 * @author Lemovou Ivan
 * This class is about the exitDoor
 */


public class Diamond extends Objet {

    private static final Logger logger = Logger.getLogger(Diamond.class.getName());
    private static final int SLEEP_DURATION = 100;
    private static final String[] IMAGE_SEQUENCE = {"2", "3", "4", "1"};

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @see Objet
     */
    public Diamond(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        initializeImage();
        startImageCycling();
    }

    private void initializeImage() {
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.DIAMOND_IMAGE)));
        super.imgObj = super.icoObj.getImage();
        super.falling = false;
        super.velocity = 0;
    }

    private void startImageCycling() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::cycleImages, 10, 420, TimeUnit.MILLISECONDS);
    }

    private void cycleImages() {
        for (String num : IMAGE_SEQUENCE) {
            setImgObj(num);
            try {
                TimeUnit.MILLISECONDS.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * @param num to set an image
     */
    public void setImgObj(String num) {
        String str = "/images/diam" + num + ".png";
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        super.imgObj = super.icoObj.getImage();
    }
}
