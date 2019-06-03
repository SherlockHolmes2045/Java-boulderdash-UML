package view;



import java.awt.event.KeyEvent;



import javax.swing.SwingUtilities;
import contract.ControllerOrder;
import contract.IController;
import contract.IView;



/**
 * The Class View.
 *
 * @author Welaji chris-yvan

 */

public final class View implements IView, Runnable {

	/** The frame. */

	public static  ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *          the model
	 */

	@SuppressWarnings("static-access")
	public View() {
		this.viewFrame = new ViewFrame();
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {

		switch (keyCode) {

			case KeyEvent.VK_LEFT:
				
				return ControllerOrder.LEFT;

			case KeyEvent.VK_RIGHT:

				return ControllerOrder.RIGHT;
			case KeyEvent.VK_UP:

				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
					default:
				return null;
		}
	}

	/**
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */

	public void printMessage(final String message) {
	}
	
	/**
	 *
	 * @see java.lang.Runnable#run()
	 */

	@SuppressWarnings("static-access")
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */

	@SuppressWarnings("static-access")
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

}