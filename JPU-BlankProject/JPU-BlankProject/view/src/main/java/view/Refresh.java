package view;

/**
 * Date:31-05-2019
 * The Class Refresh.
 * @author Welaji Chris-yvan
 */
public class Refresh implements Runnable{
	
	/**
	 * The pause parameter defines the delay of refreshment
	 */

	private final int PAUSE=3;
	
	
	@Override
	public void run() {
		while(true) {
			ViewFrame.panel1.repaint();
	try {Thread.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}

	}
}
}