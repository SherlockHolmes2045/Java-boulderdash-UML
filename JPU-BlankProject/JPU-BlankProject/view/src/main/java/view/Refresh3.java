package view;

public class Refresh3 implements Runnable{
	private final int PAUSE=3;
	@Override
	public void run() {
		while(true) {
			ViewFrame.panel3.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
}
