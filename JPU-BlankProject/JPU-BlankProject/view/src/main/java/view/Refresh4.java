package view;

public class Refresh4 implements Runnable{
	private final int PAUSE=3;
	@Override
	public void run() {
		while(true) {
			ViewFrame.panel4.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
}
