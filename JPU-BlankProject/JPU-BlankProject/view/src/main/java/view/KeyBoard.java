package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			ViewFrame.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));	

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(View.viewFrame.getCompteur()==2) {
		ViewPanel.dash.setWalks(false);
		ViewPanel.dash.setWalksdown(false);
		ViewPanel.dash.setWalksup(false);
		ViewPanel.dash.setWalksleft(false);
		ViewPanel.dash.setWalksright(false);
		}else if(View.viewFrame.getCompteur()==3) {
			ViewPanel2.dash.setWalks(false);
			ViewPanel2.dash.setWalksdown(false);
			ViewPanel2.dash.setWalksup(false);
			ViewPanel2.dash.setWalksleft(false);
			ViewPanel2.dash.setWalksright(false);
		}else if(View.viewFrame.getCompteur()==4) {
			ViewPanel3.dash.setWalks(false);
			ViewPanel3.dash.setWalksdown(false);
			ViewPanel3.dash.setWalksup(false);
			ViewPanel3.dash.setWalksleft(false);
			ViewPanel3.dash.setWalksright(false);
		}else if(View.viewFrame.getCompteur()==5) {
			ViewPanel4.dash.setWalks(false);
			ViewPanel4.dash.setWalksdown(false);
			ViewPanel4.dash.setWalksup(false);
			ViewPanel4.dash.setWalksleft(false);
			ViewPanel4.dash.setWalksright(false);
	}else if(View.viewFrame.getCompteur()==6) {
		ViewPanel5.dash.setWalks(false);
		ViewPanel5.dash.setWalksdown(false);
		ViewPanel5.dash.setWalksup(false);
		ViewPanel5.dash.setWalksleft(false);
		ViewPanel5.dash.setWalksright(false);
	}
		}
}
