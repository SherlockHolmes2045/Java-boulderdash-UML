package controller;

import contract.ControllerOrder;

import contract.IController;

import contract.IModel;

import contract.IView;

import model.Back;
import model.Objet;
import view.View;
import view.ViewFrame;
import view.ViewPanel;
import view.ViewPanel2;
import view.ViewPanel3;
import view.ViewPanel4;
import view.ViewPanel5;

/**

 * The Class Controller.
 * 
 * @author Lemovou Dachi Ivan
 
 */

public final class Controller implements IController {

	/** The view. */

	@SuppressWarnings("unused")
	private IView		view;

	/** The model. */

	@SuppressWarnings("unused")
	private IModel	model;

	/**

	 * Instantiates a new controller.

	 *

	 * @param view

	 *          the view

	 */

	public Controller(final IView view) {

		this.setView(view);

	}

	/**

     * Control.

     */

	/**

	 *

	 * @see contract.IController#control()

	 */

	public void control() {
		   	}

	/**

     * Sets the view.

     *

     * @param pview

     *            the new view

     */

private void setView(final IView pview) {
		this.view = pview;
	}

	/**

	 * Sets the model.
	 *
	 * @param model

	 *          the new model

	 */

	@SuppressWarnings("unused")
	private void setModel(final IModel model) {

		this.model = model;
		
	}

	/**

     * Order perform.

     *

     * @param controllerOrder

     *            the controller order

     */

	/**

	 *

	 * @see contract.IController#orderPerform(contract.ControllerOrder)

	 */

	public void orderPerform(final ControllerOrder controllerOrder) {

		switch (controllerOrder) {

			case LEFT:
				
				if(View.viewFrame.getLevel_counter()==2) {
					
					ViewPanel.dash.setRest(false);
					ViewPanel.dash.setWalksleft(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

				if(ViewPanel.dash.NearLeft(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.LeftContact(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){
							ViewFrame.panel1.setNbr_diamond(ViewFrame.panel1.getNbr_diamond()-1);
							ViewPanel.dash.setScore(ViewPanel.dash.getScore()+20);
							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());
							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Roc") {
							
							if(ViewPanel.tabObjets[j][i].getPushableLeft()==true) {
								int x=ViewPanel.tabObjets[j][i].getX();
								int y=ViewPanel.tabObjets[j][i].getY();
								ViewPanel.tabObjets[j][i].setX(ViewPanel.tabObjets[j][i].getX()-32);
								Objet tmp=ViewPanel.tabObjets[j][i];
								ViewPanel.tabObjets[j][i-1]=ViewPanel.tabObjets[j][i];
								ViewPanel.tabObjets[j][i]=new Back(x,y);
								ViewPanel.dash.setWalks(true);
							}else {
								ViewPanel.dash.setWalks(false);

							}
							
						}else {
							ViewPanel.dash.setWalks(false);
						}
							
					}
							}
					  }
				}
			
				

				
				if(ViewPanel.dash.getWalks()==true) {

					ViewPanel.dash.setX(ViewPanel.dash.getX()-32);		

				}
				
				//***Level 2 Handling controller****//
				
				
				}else if(View.viewFrame.getLevel_counter()==3) {
					
					
					ViewPanel2.dash.setWalksleft(true);
					ViewPanel2.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel2.dash.NearLeft(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.LeftContact(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel2.setNbr_diamond(ViewFrame.panel2.getNbr_diamond()-1);
								ViewPanel2.dash.setScore(ViewPanel2.dash.getScore()+20);
								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());
								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel2.tabObjets[j][i].getPushableLeft()==true) {
									int x=ViewPanel2.tabObjets[j][i].getX();
									int y=ViewPanel2.tabObjets[j][i].getY();
									ViewPanel2.tabObjets[j][i].setX(ViewPanel2.tabObjets[j][i].getX()-32);
									Objet tmp=ViewPanel2.tabObjets[j][i];
									ViewPanel2.tabObjets[j][i-1]=ViewPanel2.tabObjets[j][i];
									ViewPanel2.tabObjets[j][i]=new Back(x,y);
									ViewPanel2.dash.setWalks(true);
								}else {
									ViewPanel2.dash.setWalks(false);

								}
								
							}else {
								ViewPanel2.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
					
					if(ViewPanel2.dash.getWalks()==true) {
					
						ViewPanel2.dash.setX(ViewPanel2.dash.getX()-32);
					
					}
				}
				
				//****Level 3 Handling Controller****//
				
					else if(View.viewFrame.getLevel_counter()==4) {
					
					ViewPanel3.dash.setWalksleft(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel3.dash.NearLeft(ViewPanel3.tabObjets[j][i])) {

					if(ViewPanel3.dash.LeftContact(ViewPanel3.tabObjets[j][i])) {

							if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel3.dash.setWalks(true);	

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel3.setNbr_diamond(ViewFrame.panel3.getNbr_diamond()-1);
								ViewPanel3.dash.setScore(ViewPanel.dash.getScore()+20);
								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());
								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel3.tabObjets[j][i].getPushableLeft()==true) {
									int x=ViewPanel3.tabObjets[j][i].getX();
									int y=ViewPanel3.tabObjets[j][i].getY();
									ViewPanel3.tabObjets[j][i].setX(ViewPanel3.tabObjets[j][i].getX()-32);
									Objet tmp=ViewPanel3.tabObjets[j][i];
									ViewPanel3.tabObjets[j][i-1]=ViewPanel3.tabObjets[j][i];
									ViewPanel3.tabObjets[j][i]=new Back(x,y);
									ViewPanel3.dash.setWalks(true);
								}else {
									ViewPanel3.dash.setWalks(false);

								}
								
							}else {
								ViewPanel3.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
					
					if(ViewPanel3.dash.getWalks()==true) {
					
						ViewPanel3.dash.setX(ViewPanel3.dash.getX()-32);
					
					}
				}
				
				//****Level 4 Controller Handling****//
				
					else if(View.viewFrame.getLevel_counter()==5) {
						
						ViewPanel4.dash.setWalksleft(true);
						ViewPanel4.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel4.dash.NearLeft(ViewPanel4.tabObjets[j][i])) {

						if(ViewPanel4.dash.LeftContact(ViewPanel4.tabObjets[j][i])) {

								if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

									ViewPanel4.dash.setWalks(true);

								}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel4.dash.setWalks(true);	

								}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									ViewFrame.panel4.setNbr_diamond(ViewFrame.panel4.getNbr_diamond()-1);
									ViewPanel4.dash.setScore(ViewPanel4.dash.getScore()+20);
									ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());
									ViewPanel4.dash.setWalks(true);

								}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Roc") {
									
									if(ViewPanel4.tabObjets[j][i].getPushableLeft()==true) {
										int x=ViewPanel4.tabObjets[j][i].getX();
										int y=ViewPanel4.tabObjets[j][i].getY();
										ViewPanel4.tabObjets[j][i].setX(ViewPanel4.tabObjets[j][i].getX()-32);
										Objet tmp=ViewPanel4.tabObjets[j][i];
										ViewPanel4.tabObjets[j][i-1]=ViewPanel4.tabObjets[j][i];
										ViewPanel4.tabObjets[j][i]=new Back(x,y);
										ViewPanel4.dash.setWalks(true);
									}else {
										ViewPanel4.dash.setWalks(false);

									}
									
								}else {
									ViewPanel4.dash.setWalks(false);
								}
									
							}
									}
							  }
						}
						
						if(ViewPanel4.dash.getWalks()==true) {
						
							ViewPanel4.dash.setX(ViewPanel4.dash.getX()-32);
						
						}
					}
			//*****Level 5 handling Controller****//
				
					else if(View.viewFrame.getLevel_counter()==6) {
						
						ViewPanel5.dash.setWalksleft(true);
						ViewPanel5.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel5.dash.NearLeft(ViewPanel5.tabObjets[j][i])) {

						if(ViewPanel5.dash.LeftContact(ViewPanel5.tabObjets[j][i])) {

								if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

									ViewPanel5.dash.setWalks(true);

								}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel5.dash.setWalks(true);	

								}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									ViewFrame.panel5.setNbr_diamond(ViewFrame.panel5.getNbr_diamond()-1);
									ViewPanel5.dash.setScore(ViewPanel5.dash.getScore()+20);
									ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());
									ViewPanel5.dash.setWalks(true);

								}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Roc") {
									
									if(ViewPanel5.tabObjets[j][i].getPushableLeft()==true) {
										int x=ViewPanel5.tabObjets[j][i].getX();
										int y=ViewPanel5.tabObjets[j][i].getY();
										ViewPanel5.tabObjets[j][i].setX(ViewPanel5.tabObjets[j][i].getX()-32);
										Objet tmp=ViewPanel5.tabObjets[j][i];
										ViewPanel5.tabObjets[j][i-1]=ViewPanel5.tabObjets[j][i];
										ViewPanel5.tabObjets[j][i]=new Back(x,y);
										ViewPanel5.dash.setWalks(true);
									}else {
										ViewPanel5.dash.setWalks(false);

									}
									
								}else {
									ViewPanel5.dash.setWalks(false);
								}
									
							}
									}
							  }
						}
						
						if(ViewPanel5.dash.getWalks()==true) {
						
							ViewPanel5.dash.setX(ViewPanel5.dash.getX()-32);	
						}
					}
				
				break;

			case UP:
				
				if(View.viewFrame.getLevel_counter()==2) {
				
					ViewPanel.dash.setRest(false);
					
					ViewPanel.dash.setWalksup(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

						   if(ViewPanel.tabObjets[j][i]!=null) {

							   

				if(ViewPanel.dash.NearUp(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.UpContact(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {

							ViewFrame.panel1.setNbr_diamond(ViewFrame.panel1.getNbr_diamond()-1);
							ViewPanel.dash.setScore(ViewPanel.dash.getScore()+20);
							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());
							ViewPanel.dash.setWalks(true);
						}else {

							ViewPanel.dash.setWalks(false);

						}
				}
							}
					  }
				}
			}

				
				
				if(ViewPanel.dash.getWalks()==true) {

					ViewPanel.dash.setY(ViewPanel.dash.getY()-32);	

				}
				
				//****Level 2 handling Controller****//
				
			}else if(View.viewFrame.getLevel_counter()==3) {
				
				
				ViewPanel2.dash.setWalksup(true);
				ViewPanel2.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel2.dash.NearUp(ViewPanel2.tabObjets[j][i])) {

				if(ViewPanel2.dash.UpContact(ViewPanel2.tabObjets[j][i])) {

						if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

							ViewPanel2.dash.setWalks(true);

						}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel2.dash.setWalks(true);	

						}else if(ViewPanel2.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewFrame.panel2.setNbr_diamond(ViewFrame.panel2.getNbr_diamond()-1);
							ViewPanel2.dash.setScore(ViewPanel2.dash.getScore()+20);
							ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());
							ViewPanel2.dash.setWalks(true);
						}else {

							ViewPanel2.dash.setWalks(false);

						}
				}
							}
					  }
				}
		
			
				if(ViewPanel2.dash.getWalks()==true) {
				
				ViewPanel2.dash.setY(ViewPanel2.dash.getY()-32);
				
				}
			}
			//****Level 3 Handling Controller****//
				
			else if(View.viewFrame.getLevel_counter()==4) {
				
				
				ViewPanel3.dash.setWalksup(true);
				ViewPanel3.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel3.dash.NearUp(ViewPanel3.tabObjets[j][i])) {

				if(ViewPanel3.dash.UpContact(ViewPanel3.tabObjets[j][i])) {

						if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

							ViewPanel3.dash.setWalks(true);

						}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel3.dash.setWalks(true);	

						}else if(ViewPanel3.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							ViewFrame.panel3.setNbr_diamond(ViewFrame.panel3.getNbr_diamond()-1);
							ViewPanel3.dash.setScore(ViewPanel3.dash.getScore()+20);
							ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());
							ViewPanel3.dash.setWalks(true);
						}else {

							ViewPanel3.dash.setWalks(false);

						}
				}
							}
					  }
				}
		
			
				if(ViewPanel3.dash.getWalks()==true) {
				
				ViewPanel3.dash.setY(ViewPanel3.dash.getY()-32);
				if(ViewPanel3.dash.getX()==192 && ViewPanel3.dash.getY()==96 && ViewFrame.panel3.isExitable()==true) {
					View.viewFrame.setLevel_counter(View.viewFrame.getLevel_counter()+1);
					ViewFrame.card.show(ViewFrame.container, ""+View.viewFrame.getLevel_counter());
				}
				
				}
			}
				//****Level 4 Handling Controller****//
				
			else if(View.viewFrame.getLevel_counter()==5) {
				
				ViewPanel4.dash.setWalksup(true);
				ViewPanel4.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel4.dash.NearUp(ViewPanel4.tabObjets[j][i])) {

				if(ViewPanel4.dash.UpContact(ViewPanel4.tabObjets[j][i])) {

						if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

							ViewPanel4.dash.setWalks(true);

						}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel4.dash.setWalks(true);	

						}else if(ViewPanel4.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							ViewFrame.panel4.setNbr_diamond(ViewFrame.panel4.getNbr_diamond()-1);
							ViewPanel4.dash.setScore(ViewPanel4.dash.getScore()+20);
							ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());
							ViewPanel4.dash.setWalks(true);
						}else {

							ViewPanel4.dash.setWalks(false);

						}
				}
							}
					  }
				}
		
			
				if(ViewPanel4.dash.getWalks()==true) {
				
				ViewPanel4.dash.setY(ViewPanel4.dash.getY()-32);
				
				}
			}
		//****Level 5 Handling Controller ****//		
		
				else if(View.viewFrame.getLevel_counter()==6) {
				
				ViewPanel5.dash.setWalksup(true);
				ViewPanel5.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel5.dash.NearUp(ViewPanel5.tabObjets[j][i])) {

				if(ViewPanel5.dash.UpContact(ViewPanel5.tabObjets[j][i])) {

						if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

							ViewPanel5.dash.setWalks(true);

						}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel5.dash.setWalks(true);	

						}else if(ViewPanel5.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							ViewFrame.panel5.setNbr_diamond(ViewFrame.panel5.getNbr_diamond()-1);
							ViewPanel5.dash.setScore(ViewPanel5.dash.getScore()+20);
							ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());
							ViewPanel5.dash.setWalks(true);
						}else {

							ViewPanel5.dash.setWalks(false);

						}
				}
							}
					  }
				}
		
			
				if(ViewPanel5.dash.getWalks()==true) {
				
				ViewPanel5.dash.setY(ViewPanel5.dash.getY()-32);
				
				}
			}
				
				
				break;
				
			case DOWN:
				
				if(View.viewFrame.getLevel_counter()==2) {
				
				ViewPanel.dash.setRest(false);
				ViewPanel.dash.setWalksdown(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

							   
				if(ViewPanel.dash.NearDown(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.DownContact(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){

							ViewFrame.panel1.setNbr_diamond(ViewFrame.panel1.getNbr_diamond()-1);
							ViewPanel.dash.setScore(ViewPanel.dash.getScore()+20);
							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());
							ViewPanel.dash.setWalks(true);
							
						}else {
							
							ViewPanel.dash.setWalks(false);

						}
				}
							}
					  }
				}
			

				

				if(ViewPanel.dash.getWalks()==true) {

					ViewPanel.dash.setY(ViewPanel.dash.getY()+32);	

				}
				
				//****Level 2 Handling Controller***//
				
			}else if(View.viewFrame.getLevel_counter()==3) {
				
				
				ViewPanel2.dash.setWalksdown(true);
				ViewPanel2.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

				if(ViewPanel2.dash.NearDown(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.DownContact(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel2.setNbr_diamond(ViewFrame.panel2.getNbr_diamond()-1);
								ViewPanel2.dash.setScore(ViewPanel2.dash.getScore()+20);
								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());
								ViewPanel2.dash.setWalks(true);
								
							}else {
								
								ViewPanel2.dash.setWalks(false);

							}
					}
								}
						  }
					}
			}	
				
				
				if(ViewPanel2.dash.getWalks()==true) {

					ViewPanel2.dash.setY(ViewPanel2.dash.getY()+32);	
					
					
					if(ViewPanel2.dash.getX()==672 && ViewPanel2.dash.getY()==704 && ViewFrame.panel2.isExitable()==true) {
						System.out.println("ok");
						View.viewFrame.setLevel_counter(View.viewFrame.getLevel_counter()+1);
						ViewFrame.card.show(ViewFrame.container, ""+View.viewFrame.getLevel_counter());
					}
				}			

				//**** Level 3 Handling controller ****//
				
				else if(View.viewFrame.getLevel_counter()==4) {
					
					
					ViewPanel3.dash.setWalksdown(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel3.dash.NearDown(ViewPanel3.tabObjets[j][i])) {

						if(ViewPanel3.dash.DownContact(ViewPanel3.tabObjets[j][i])) {

								if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

									ViewPanel3.dash.setWalks(true);

								}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel3.dash.setWalks(true);	

								}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									ViewFrame.panel3.setNbr_diamond(ViewFrame.panel3.getNbr_diamond()-1);
									ViewPanel3.dash.setScore(ViewPanel3.dash.getScore()+20);
									ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());
									ViewPanel3.dash.setWalks(true);
									
								}else {
									
									ViewPanel3.dash.setWalks(false);

								}
						}
									}
							  }
						}
				}	
					
					
					if(ViewPanel3.dash.getWalks()==true) {

						ViewPanel3.dash.setY(ViewPanel3.dash.getY()+32);	
						
					}			
				
					//****Level 4 Handling Controller****//
					
					else if(View.viewFrame.getLevel_counter()==5) {
						
						
						ViewPanel4.dash.setWalksdown(true);
						ViewPanel4.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel4.dash.NearDown(ViewPanel4.tabObjets[j][i])) {

							if(ViewPanel4.dash.DownContact(ViewPanel4.tabObjets[j][i])) {

									if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

										ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

										ViewPanel4.dash.setWalks(true);

									}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

										ViewPanel4.dash.setWalks(true);	

									}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
										ViewFrame.panel4.setNbr_diamond(ViewFrame.panel4.getNbr_diamond()-1);
										ViewPanel4.dash.setScore(ViewPanel4.dash.getScore()+20);
										ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());
										ViewPanel4.dash.setWalks(true);
										
									}else {
										
										ViewPanel4.dash.setWalks(false);

									}
							}
										}
								  }
							}
					}	
						
						
						if(ViewPanel4.dash.getWalks()==true) {

							ViewPanel4.dash.setY(ViewPanel4.dash.getY()+32);
						}			
				//****Level 5 Handling Controller***//	
						
						else if(View.viewFrame.getLevel_counter()==6) {
							
							
							ViewPanel5.dash.setWalksdown(true);
							ViewPanel5.dash.setRest(false);

							for(int j=0;j<24;j++) {
								   
								for(int i=0;i<51;i++){

							if(ViewPanel5.dash.NearDown(ViewPanel5.tabObjets[j][i])) {

								if(ViewPanel5.dash.DownContact(ViewPanel5.tabObjets[j][i])) {

										if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

											ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

											ViewPanel5.dash.setWalks(true);

										}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

											ViewPanel5.dash.setWalks(true);	

										}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
											ViewFrame.panel5.setNbr_diamond(ViewFrame.panel5.getNbr_diamond()-1);
											ViewPanel5.dash.setScore(ViewPanel5.dash.getScore()+20);
											ViewPanel5.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());
											ViewPanel5.dash.setWalks(true);
											
										}else {
											
											ViewPanel5.dash.setWalks(false);

										}
								}
											}
									  }
								}
						}	
							if(ViewPanel5.dash.getWalks()==true) {

								ViewPanel5.dash.setY(ViewPanel5.dash.getY()+32);	
							
							}				
						
				
				break;

			case RIGHT:
				
				if(View.viewFrame.getLevel_counter()==2) {
				
					ViewPanel.dash.setRest(false);
					ViewPanel.dash.setWalksright(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++) {

				if(ViewPanel.dash.NearRight(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.RightContact(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){

							ViewFrame.panel1.setNbr_diamond(ViewFrame.panel1.getNbr_diamond()-1);
							ViewPanel.dash.setScore(ViewPanel2.dash.getScore()+20);
							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());
							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Roc") {
							
							if(ViewPanel.tabObjets[j][i].getPushableRight()==true) {
								int x=ViewPanel.tabObjets[j][i].getX();
								int y=ViewPanel.tabObjets[j][i].getY();
								ViewPanel.tabObjets[j][i].setX(ViewPanel.tabObjets[j][i].getX()+32);
								Objet tmp=ViewPanel.tabObjets[j][i];
								ViewPanel.tabObjets[j][i+1]=ViewPanel.tabObjets[j][i];
								ViewPanel.tabObjets[j][i]=new Back(x,y);
								ViewPanel.dash.setWalks(true);
							}else {
								ViewPanel.dash.setWalks(false);

							}
							
						}else {
							ViewPanel.dash.setWalks(false);
						}
							
					}
							}
					  }
				}
			
				if(ViewPanel.dash.getWalks()==true) {

					ViewPanel.dash.setX(ViewPanel.dash.getX() + 32);	
					
					if(ViewPanel.dash.getX()==1344 && ViewPanel.dash.getY()==544 && ViewFrame.panel1.isExitable()==true) {

						View.viewFrame.setLevel_counter(View.viewFrame.getLevel_counter()+1);
						ViewFrame.card.show(ViewFrame.container, ""+View.viewFrame.getLevel_counter());
					
					}
				}
		
				//***Level 2 Handling controller****//
				
				
				}else if(View.viewFrame.getLevel_counter()==3) {
				
					ViewPanel2.dash.setWalksright(true);
					ViewPanel2.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel2.dash.NearRight(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.RightContact(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel2.setNbr_diamond(ViewFrame.panel2.getNbr_diamond()-1);
								ViewPanel2.dash.setScore(ViewPanel2.dash.getScore()+20);
								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());
								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel2.tabObjets[j][i].getPushableRight()==true) {
									int x=ViewPanel2.tabObjets[j][i].getX();
									int y=ViewPanel2.tabObjets[j][i].getY();
									ViewPanel2.tabObjets[j][i].setX(ViewPanel2.tabObjets[j][i].getX()+32);
									Objet tmp=ViewPanel2.tabObjets[j][i];
									ViewPanel2.tabObjets[j][i+1]=ViewPanel2.tabObjets[j][i];
									ViewPanel2.tabObjets[j][i]=new Back(x,y);
									ViewPanel2.dash.setWalks(true);
								}else {
									ViewPanel2.dash.setWalks(false);
								}
							}else {
								ViewPanel2.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
				
					
				if(ViewPanel2.dash.getWalks()==true) {

					ViewPanel2.dash.setX(ViewPanel2.dash.getX()+32);		
				}

			}
				
				//****Level 3 Handling Controller****//
				
				else if(View.viewFrame.getLevel_counter()==4) {
					
					ViewPanel3.dash.setWalksright(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel3.dash.NearRight(ViewPanel3.tabObjets[j][i])) {

					if(ViewPanel3.dash.RightContact(ViewPanel3.tabObjets[j][i])) {

							if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel3.dash.setWalks(true);	

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel3.setNbr_diamond(ViewFrame.panel3.getNbr_diamond()-1);
								ViewPanel3.dash.setScore(ViewPanel3.dash.getScore()+20);
								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());
								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel3.tabObjets[j][i].getPushableRight()==true) {
									int x=ViewPanel3.tabObjets[j][i].getX();
									int y=ViewPanel3.tabObjets[j][i].getY();
									ViewPanel3.tabObjets[j][i].setX(ViewPanel3.tabObjets[j][i].getX()+32);
									Objet tmp=ViewPanel3.tabObjets[j][i];
									ViewPanel3.tabObjets[j][i+1]=ViewPanel3.tabObjets[j][i];
									ViewPanel3.tabObjets[j][i]=new Back(x,y);
									ViewPanel3.dash.setWalks(true);
								}else {
									ViewPanel3.dash.setWalks(false);
								}
							}else {
								ViewPanel3.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
				
					
				if(ViewPanel3.dash.getWalks()==true) {

					ViewPanel3.dash.setX(ViewPanel3.dash.getX()+32);		
				}

			}
				//****Level 4 handling Controller ****//
				
				else if(View.viewFrame.getLevel_counter()==5) {
					
					ViewPanel4.dash.setWalksright(true);
					ViewPanel4.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel4.dash.NearRight(ViewPanel4.tabObjets[j][i])) {

					if(ViewPanel4.dash.RightContact(ViewPanel4.tabObjets[j][i])) {

							if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

								ViewPanel4.dash.setWalks(true);

							}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel4.dash.setWalks(true);	

							}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel4.setNbr_diamond(ViewFrame.panel4.getNbr_diamond()-1);
								ViewPanel4.dash.setScore(ViewPanel4.dash.getScore()+20);
								ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());
								ViewPanel4.dash.setWalks(true);

							}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel4.tabObjets[j][i].getPushableRight()==true) {
									int x=ViewPanel4.tabObjets[j][i].getX();
									int y=ViewPanel4.tabObjets[j][i].getY();
									ViewPanel4.tabObjets[j][i].setX(ViewPanel4.tabObjets[j][i].getX()+32);
									Objet tmp=ViewPanel4.tabObjets[j][i];
									ViewPanel4.tabObjets[j][i+1]=ViewPanel4.tabObjets[j][i];
									ViewPanel4.tabObjets[j][i]=new Back(x,y);
									ViewPanel4.dash.setWalks(true);
								}else {
									ViewPanel4.dash.setWalks(false);
								}
							}else {
								ViewPanel4.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
				
					
				if(ViewPanel4.dash.getWalks()==true) {

					ViewPanel4.dash.setX(ViewPanel4.dash.getX()+32);		
				}

			}
		//****Level 5 Handling Controller****//	
				
				else if(View.viewFrame.getLevel_counter()==6) {
					
					ViewPanel5.dash.setWalksright(true);
					ViewPanel5.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel5.dash.NearRight(ViewPanel5.tabObjets[j][i])) {

					if(ViewPanel5.dash.RightContact(ViewPanel5.tabObjets[j][i])) {

							if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

								ViewPanel5.dash.setWalks(true);

							}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel5.dash.setWalks(true);	

							}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewFrame.panel5.setNbr_diamond(ViewFrame.panel5.getNbr_diamond()-1);
								ViewPanel5.dash.setScore(ViewPanel5.dash.getScore()+20);
								ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());
								ViewPanel5.dash.setWalks(true);

							}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Roc") {
								
								if(ViewPanel5.tabObjets[j][i].getPushableRight()==true) {
									int x=ViewPanel5.tabObjets[j][i].getX();
									int y=ViewPanel5.tabObjets[j][i].getY();
									ViewPanel5.tabObjets[j][i].setX(ViewPanel5.tabObjets[j][i].getX()+32);
									Objet tmp=ViewPanel5.tabObjets[j][i];
									ViewPanel5.tabObjets[j][i+1]=ViewPanel5.tabObjets[j][i];
									ViewPanel5.tabObjets[j][i]=new Back(x,y);
									ViewPanel5.dash.setWalks(true);
								}else {
									ViewPanel5.dash.setWalks(false);
								}
							}else {
								ViewPanel5.dash.setWalks(false);
							}
								
						}
								}
						  }
					}
				
					
				if(ViewPanel5.dash.getWalks()==true) {

					ViewPanel5.dash.setX(ViewPanel5.dash.getX()+32);		
				}

			}		
				break;
			default:
				break;
		}
	}

}



