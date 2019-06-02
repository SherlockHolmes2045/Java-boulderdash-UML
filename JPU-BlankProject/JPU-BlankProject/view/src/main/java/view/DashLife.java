package view;

import java.util.Timer;
import java.util.TimerTask;

public class DashLife {

	public DashLife() {
		
		Timer time= new Timer();
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				
				/*for(int i=0;i<24;i++) {
					for(int j=0;j<51;j++) {
					if(ViewPanel.tabObjets[i][j]!=null) {
					if(ViewPanel.tabObjets[i][j].getClass().getName().equals("model.Roc") || ViewPanel.tabObjets[i][j].getClass().getName().equals("model.Diamond")) {
						
						if(ViewPanel.dash.verifyDashLife(ViewPanel.tabObjets[i][j])) {
							ViewPanel.dash.setDeath(true);
							System.out.println("meurt");
						}else {
							ViewPanel.dash.setDeath(false);
							//System.out.println("vie");
						}
						
						}
					}
				}
			}*/
			}
		};
		time.schedule(task,10,50);
	}

		
	}
	

