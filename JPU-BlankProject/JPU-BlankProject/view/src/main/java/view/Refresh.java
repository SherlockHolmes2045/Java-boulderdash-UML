package view;

public class Refresh implements Runnable{
	private final int PAUSE=3;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//if(View.viewFrame.getCompteur()==2) {
			/*try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			ViewFrame.panel1.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*}else if(Main.compteur==3) {
			
			Main.scene2.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(Main.compteur==4) {
			
			Main.scene3.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
		//}
	}
}
}