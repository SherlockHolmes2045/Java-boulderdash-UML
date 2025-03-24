package model;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * @author Lemovou Ivan
 * this class is about the exitDoor
 */

public class ExitDoor extends Objet {
    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @see Objet
     */

    public ExitDoor(int x, int y) {
        super(x, y, GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(GameConstants.EXIT_IMAGE)));
        super.imgObj = super.icoObj.getImage();
        exitDoorAnimationTask();
    }

    private Timer time;
    private TimerTask task;

    private void exitDoorAnimationTask() {
        if (task == null) {
            time = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    setImgObj("2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    setImgObj("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    setImgObj("4");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    setImgObj("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };
            time.schedule(task, 10, 420);
        }
    }

    /**
     * @param num to set the image for the exit
     */

    public void setImgObj(String num) {
        String str = "/images/Exit" + num + ".PNG";
        super.icoObj = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        super.imgObj = super.icoObj.getImage();
    }
}
