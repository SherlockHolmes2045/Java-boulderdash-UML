package view;

/**
 * Date:31-05-2019
 * The Class Refresh3.
 * @author Welaji Chris-yvan
 */

public class Refresh3 implements Runnable{
	
	/**
	 * @see Refresh
	 */
	
	private final int PAUSE=3;
	
	@Override
	public void run() {
		while(true) {
			ViewFrame.panel3.repaint();
	try {Thread.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
