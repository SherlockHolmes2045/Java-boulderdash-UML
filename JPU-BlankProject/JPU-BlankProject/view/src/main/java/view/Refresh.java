package view;

import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * The Refresh class implements the Runnable interface to periodically refresh
 * the ViewFrame's panel1 by repainting it at a specified interval.
 * The refresh interval is defined by the pause parameter, which can be set
 * through the constructor or the setPause method. The refresh process can be
 * stopped by calling the stop method, which sets the running flag to false.
 * The run method contains the main loop that performs the repaint operation
 * and handles any InterruptedException that may occur during the sleep period.
 * Logging is used to report severe interruptions.
 * Date: 31-05-2019
 *
 * @author Lemovou Ivan
 */
public class Refresh implements Runnable {

    /**
     * The pause parameter defines the delay of refreshment
     */

    private int pause;
    private final JPanel panel;
    private volatile boolean running = true;
    private static final Logger LOGGER = Logger.getLogger(Refresh.class.getName());

    public Refresh(int pause, JPanel panel) {
        this.pause = pause;
        this.panel = panel;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            panel.repaint();
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}