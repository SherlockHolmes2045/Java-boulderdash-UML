package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Container extends JPanel implements Observer{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6177364578189888713L;
	/** The view frame. */
	private ViewFrame					viewFrame;
	
	
	public Container() {
		
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.addKeyListener(new KeyBoard());

	}
	/**

	 * Gets the view frame.

	 *

	 * @return the view frame

	 */

	private ViewFrame getViewFrame() {

		return this.viewFrame;

	}



	/**

	 * Sets the view frame.

	 *

	 * @param viewFrame

	 *          the new view frame

	 */

	private void setViewFrame(final ViewFrame viewFrame) {

		this.viewFrame = viewFrame;

	}



	/*

	 * (non-Javadoc)

	 *

	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)

	 */

	@Override
	public void update(final Observable arg0, final Object arg1) {

		this.repaint();

	}



	/*

	 * (non-Javadoc)

	 *

	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)

	 */


	

}
