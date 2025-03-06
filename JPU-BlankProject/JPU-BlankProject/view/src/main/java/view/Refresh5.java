package view;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date:31-05-2019
 * The Class Refresh5.
 * @author Lemovou Ivan
 */

public class Refresh5 implements Runnable{

	/**
	 * @see Refresh
	 */

	private int pause;
	private volatile boolean running = true;
	private static final Logger LOGGER = Logger.getLogger(Refresh5.class.getName());

	public Refresh5(int pause) {
		this.pause = pause;
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
			ViewFrame.panel5.repaint();
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread was interrupted", e);
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
