package view;

import java.util.logging.Logger;
import java.awt.event.KeyEvent;


import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IView;


/**
 * The Class View.
 *
 * @author Lemovou
 * <p>
 * <p>
 * The Class View is responsible for managing the user interface and handling
 * user input. It implements the IView interface and the Runnable interface
 * to ensure proper display and interaction with the ViewFrame.
 * <p>
 * It provides functionality to map key codes to controller orders and
 * to print messages using a logger. The View class also manages the
 * visibility of the ViewFrame and allows setting a controller.
 * <p>
 * The View is instantiated to run on the Event Dispatch Thread using
 * SwingUtilities.
 * @see contract.IView
 * @see java.lang.Runnable
 * @see javax.swing.SwingUtilities
 * @see java.util.logging.Logger
 */
public final class View implements IView, Runnable {

    /**
     * The frame.
     */

    public static final ViewFrame viewFrame = new ViewFrame();

    /**
     * Instantiates a new view.
     * the model
     */

    public View() {
        SwingUtilities.invokeLater(this);
    }

    /**
     * Key code to controller order.
     *
     * @param keyCode the key code
     * @return the controller order
     */

    static ControllerOrder keyCodeToControllerOrder(final int keyCode) {

        return switch (keyCode) {
            case KeyEvent.VK_LEFT -> ControllerOrder.LEFT;
            case KeyEvent.VK_RIGHT -> ControllerOrder.RIGHT;
            case KeyEvent.VK_UP -> ControllerOrder.UP;
            case KeyEvent.VK_DOWN -> ControllerOrder.DOWN;
            default -> null;
        };
    }

    /**
     * @see contract.IView#printMessage(java.lang.String)
     */

    public void printMessage(final String message) {
        Logger logger = Logger.getLogger(View.class.getName());
        logger.info(message);
    }

    /**
     * @see java.lang.Runnable#run()
     */


    public void run() {
        viewFrame.setVisible(true);
    }

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */

    public void setController(final IController controller) {
        viewFrame.setController(controller);
    }

}