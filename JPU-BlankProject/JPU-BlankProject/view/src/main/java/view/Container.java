package view;

import java.io.Serial;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * Date:02-06-2019
 * The Class Container.
 *
 * @author Lemovou Ivan
 */
public class Container extends JPanel implements Observer {

    /**
     * The Constant serialVersionUID.
     */
    @Serial
    private static final long serialVersionUID = -6177364578189888713L;
    /**
     * The view frame.
     */
    private ViewFrame viewFrame;


    public Container() {

        this.setFocusable(true);
        this.requestFocusInWindow(true);
        this.addKeyListener(new GameKeyListener());

    }

    /**
     * Gets the view frame.
     *
     * @return the view frame
     */

    @SuppressWarnings("unused")
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame the new view frame
     */
    @SuppressWarnings("unused")
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /**
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */

    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

}
