package view;

public class Refresh2 implements Runnable{
	private final int PAUSE=3;
	@Override
	public void run() {
		while(true) {
			ViewFrame.panel2.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
}
