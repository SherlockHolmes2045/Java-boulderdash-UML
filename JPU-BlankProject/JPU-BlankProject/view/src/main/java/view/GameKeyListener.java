package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import contract.ControllerOrder;
import contract.IController;
import model.Dash;


/**
 * Date:31-05-2019
 * The Class GameKeyListener.
 * Handles keyboard events for a game.
 *
 * @author Lemovou Dachi Ivan
 */
public class GameKeyListener implements KeyListener {

    private static final Logger logger = Logger.getLogger(GameKeyListener.class.getName());

    /**
     * Invoked when a key has been typed. This event occurs when a key press is followed by a key release.
     *
     * @param e The param gets the event of the key typed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        logger.info("Key typed: " + e.getKeyChar());
    }

    /**
     * Invoked when a key has been pressed.
     * The different keys to enter are in the class ControllerOrder of enumerated type
     */
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            ControllerOrder order = View.keyCodeToControllerOrder(e.getKeyCode());
            IController controller = ViewFrame.getController();
            if (order != null && controller != null) {
                controller.orderPerform(order);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, String.format("Error processing key press: %s", ex.getMessage()), ex);
        }
    }

    /**
     * Invoked when a key has been released.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        try {
            int level = View.viewFrame.getLevel_counter();
            Dash dash = switch (level) {
                case 2 -> ViewPanel.dash;
                case 3 -> ViewPanel2.dash;
                case 4 -> ViewPanel3.dash;
                case 5 -> ViewPanel4.dash;
                case 6 -> ViewPanel5.dash;
                default -> null;
            };
            if (dash != null) {
                dash.setWalks(false);
                dash.setWalksdown(false);
                dash.setWalksup(false);
                dash.setWalksleft(false);
                dash.setWalksright(false);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, String.format("Error processing key release: %s", ex.getMessage()), ex);
        }
    }
}
