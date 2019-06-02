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



 */



public final class Controller implements IController {

	/** The view. */



	private IView		view;

	/** The model. */

	private IModel	model;

	/**

	 * Instantiates a new controller.

	 *

	 * @param view

	 *          the view

	 * @param model

	 *          the model

	 */

	public Controller(final IView view) {

		this.setView(view);

	}

	/**

     * Control.

     */

	/*

	 * (non-Javadoc)

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

	private void setModel(final IModel model) {

		this.model = model;
		
	}

	/**

     * Order perform.

     *

     * @param controllerOrder

     *            the controller order

     */

	/*

	 * (non-Javadoc)

	 *

	 * @see contract.IController#orderPerform(contract.ControllerOrder)

	 */

	public void orderPerform(final ControllerOrder controllerOrder) {

		switch (controllerOrder) {

			case LEFT:
				
				if(View.viewFrame.getCompteur()==2) {
					
					ViewPanel.dash.setRest(false);
					ViewPanel.dash.setWalksleft(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

				if(ViewPanel.dash.procheGauche(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.contactGauche(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){
							ViewPanel.nbr_diamant--;
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
				
				
				}else if(View.viewFrame.getCompteur()==3) {
					
					
					ViewPanel2.dash.setWalksleft(true);
					ViewPanel2.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel2.dash.procheGauche(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.contactGauche(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel2.nbr_diamant--;
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
				
					else if(View.viewFrame.getCompteur()==4) {
					
					ViewPanel3.dash.setWalksleft(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel3.dash.procheGauche(ViewPanel3.tabObjets[j][i])) {

					if(ViewPanel3.dash.contactGauche(ViewPanel3.tabObjets[j][i])) {

							if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel3.dash.setWalks(true);	

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel3.nbr_diamant--;
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
				
					else if(View.viewFrame.getCompteur()==5) {
						
						ViewPanel4.dash.setWalksleft(true);
						ViewPanel4.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel4.dash.procheGauche(ViewPanel4.tabObjets[j][i])) {

						if(ViewPanel4.dash.contactGauche(ViewPanel4.tabObjets[j][i])) {

								if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

									ViewPanel4.dash.setWalks(true);

								}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel4.dash.setWalks(true);	

								}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									ViewPanel4.nbr_diamant--;
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
				
					else if(View.viewFrame.getCompteur()==6) {
						
						ViewPanel5.dash.setWalksleft(true);
						ViewPanel5.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel5.dash.procheGauche(ViewPanel5.tabObjets[j][i])) {

						if(ViewPanel5.dash.contactGauche(ViewPanel5.tabObjets[j][i])) {

								if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

									ViewPanel5.dash.setWalks(true);

								}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel5.dash.setWalks(true);	

								}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									ViewPanel5.nbr_diamant--;
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
				
				if(View.viewFrame.getCompteur()==2) {
				
					ViewPanel.dash.setRest(false);
					
					ViewPanel.dash.setWalksup(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

						   if(ViewPanel.tabObjets[j][i]!=null) {

							   

				if(ViewPanel.dash.procheHaut(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.contactHaut(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewPanel.nbr_diamant--;
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
				
			}else if(View.viewFrame.getCompteur()==3) {
				
				
				ViewPanel2.dash.setWalksup(true);
				ViewPanel2.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel2.dash.procheHaut(ViewPanel2.tabObjets[j][i])) {

				if(ViewPanel2.dash.contactHaut(ViewPanel2.tabObjets[j][i])) {

						if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

							ViewPanel2.dash.setWalks(true);

						}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel2.dash.setWalks(true);	

						}else if(ViewPanel2.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewPanel2.nbr_diamant--;
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
				
			else if(View.viewFrame.getCompteur()==4) {
				
				
				ViewPanel3.dash.setWalksup(true);
				ViewPanel3.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel3.dash.procheHaut(ViewPanel3.tabObjets[j][i])) {

				if(ViewPanel3.dash.contactHaut(ViewPanel3.tabObjets[j][i])) {

						if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

							ViewPanel3.dash.setWalks(true);

						}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel3.dash.setWalks(true);	

						}else if(ViewPanel3.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewPanel3.nbr_diamant--;
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
					System.out.println("ok");
					View.viewFrame.setCompteur(View.viewFrame.getCompteur()+1);
					View.viewFrame.card.show(View.viewFrame.container, ""+View.viewFrame.getCompteur());
				}
				
				}
			}
				//****Level 4 Handling Controller****//
				
			else if(View.viewFrame.getCompteur()==5) {
				
				ViewPanel4.dash.setWalksup(true);
				ViewPanel4.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel4.dash.procheHaut(ViewPanel4.tabObjets[j][i])) {

				if(ViewPanel4.dash.contactHaut(ViewPanel4.tabObjets[j][i])) {

						if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

							ViewPanel4.dash.setWalks(true);

						}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel4.dash.setWalks(true);	

						}else if(ViewPanel4.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewPanel4.nbr_diamant--;
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
		
				else if(View.viewFrame.getCompteur()==6) {
				
				ViewPanel5.dash.setWalksup(true);
				ViewPanel5.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){ 

				if(ViewPanel5.dash.procheHaut(ViewPanel5.tabObjets[j][i])) {

				if(ViewPanel5.dash.contactHaut(ViewPanel5.tabObjets[j][i])) {

						if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

							ViewPanel5.dash.setWalks(true);

						}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel5.dash.setWalks(true);	

						}else if(ViewPanel5.tabObjets[j][i].getClass().getName().equals("model.Diamond")) {
							
							ViewPanel5.nbr_diamant--;
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
				
				if(View.viewFrame.getCompteur()==2) {
				
				ViewPanel.dash.setRest(false);
				ViewPanel.dash.setWalksdown(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

							   
				if(ViewPanel.dash.procheBas(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.contactBas(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){
						
							ViewPanel.nbr_diamant--;
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
				
			}else if(View.viewFrame.getCompteur()==3) {
				
				
				ViewPanel2.dash.setWalksdown(true);
				ViewPanel2.dash.setRest(false);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++){

				if(ViewPanel2.dash.procheBas(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.contactBas(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
							
								ViewPanel2.nbr_diamant--;
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
						View.viewFrame.setCompteur(View.viewFrame.getCompteur()+1);
						View.viewFrame.card.show(View.viewFrame.container, ""+View.viewFrame.getCompteur());
					}
				}			

				//**** Level 3 Handling controller ****//
				
				else if(View.viewFrame.getCompteur()==4) {
					
					
					ViewPanel3.dash.setWalksdown(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++){

					if(ViewPanel3.dash.procheBas(ViewPanel3.tabObjets[j][i])) {

						if(ViewPanel3.dash.contactBas(ViewPanel3.tabObjets[j][i])) {

								if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

									ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

									ViewPanel3.dash.setWalks(true);

								}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

									ViewPanel3.dash.setWalks(true);	

								}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								
									ViewPanel3.nbr_diamant--;
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
					
					else if(View.viewFrame.getCompteur()==5) {
						
						
						ViewPanel4.dash.setWalksdown(true);
						ViewPanel4.dash.setRest(false);

						for(int j=0;j<24;j++) {
							   
							for(int i=0;i<51;i++){

						if(ViewPanel4.dash.procheBas(ViewPanel4.tabObjets[j][i])) {

							if(ViewPanel4.dash.contactBas(ViewPanel4.tabObjets[j][i])) {

									if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

										ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

										ViewPanel4.dash.setWalks(true);

									}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

										ViewPanel4.dash.setWalks(true);	

									}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
									
										ViewPanel4.nbr_diamant--;
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
						
						else if(View.viewFrame.getCompteur()==6) {
							
							
							ViewPanel5.dash.setWalksdown(true);
							ViewPanel5.dash.setRest(false);

							for(int j=0;j<24;j++) {
								   
								for(int i=0;i<51;i++){

							if(ViewPanel5.dash.procheBas(ViewPanel5.tabObjets[j][i])) {

								if(ViewPanel5.dash.contactBas(ViewPanel5.tabObjets[j][i])) {

										if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

											ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

											ViewPanel5.dash.setWalks(true);

										}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

											ViewPanel5.dash.setWalks(true);	

										}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
										
											ViewPanel5.nbr_diamant--;
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
				
				if(View.viewFrame.getCompteur()==2) {
				
					ViewPanel.dash.setRest(false);
					ViewPanel.dash.setWalksright(true);

				for(int j=0;j<24;j++) {
					   
					for(int i=0;i<51;i++) {

				if(ViewPanel.dash.procheDroite(ViewPanel.tabObjets[j][i])) {

				if(ViewPanel.dash.contactDroite(ViewPanel.tabObjets[j][i])) {

						if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Ground") {

							ViewPanel.tabObjets[j][i]=new Back(ViewPanel.tabObjets[j][i].getX(),ViewPanel.tabObjets[j][i].getY());

							ViewPanel.dash.setWalks(true);

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Back") {

							ViewPanel.dash.setWalks(true);	

						}else if(ViewPanel.tabObjets[j][i].getClass().getName()=="model.Diamond"){
							ViewPanel.nbr_diamant--;
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

						View.viewFrame.setCompteur(View.viewFrame.getCompteur()+1);
						View.viewFrame.card.show(View.viewFrame.container, ""+View.viewFrame.getCompteur());
					
					}
				}
		
				//***Level 2 Handling controller****//
				
				
				}else if(View.viewFrame.getCompteur()==3) {
				
					ViewPanel2.dash.setWalksright(true);
					ViewPanel2.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel2.dash.procheDroite(ViewPanel2.tabObjets[j][i])) {

					if(ViewPanel2.dash.contactDroite(ViewPanel2.tabObjets[j][i])) {

							if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel2.tabObjets[j][i]=new Back(ViewPanel2.tabObjets[j][i].getX(),ViewPanel2.tabObjets[j][i].getY());

								ViewPanel2.dash.setWalks(true);

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel2.dash.setWalks(true);	

							}else if(ViewPanel2.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel2.nbr_diamant--;
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
				
				else if(View.viewFrame.getCompteur()==4) {
					
					ViewPanel3.dash.setWalksright(true);
					ViewPanel3.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel3.dash.procheDroite(ViewPanel3.tabObjets[j][i])) {

					if(ViewPanel3.dash.contactDroite(ViewPanel3.tabObjets[j][i])) {

							if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel3.tabObjets[j][i]=new Back(ViewPanel3.tabObjets[j][i].getX(),ViewPanel3.tabObjets[j][i].getY());

								ViewPanel3.dash.setWalks(true);

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel3.dash.setWalks(true);	

							}else if(ViewPanel3.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel3.nbr_diamant--;
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
				
				else if(View.viewFrame.getCompteur()==5) {
					
					ViewPanel4.dash.setWalksright(true);
					ViewPanel4.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel4.dash.procheDroite(ViewPanel4.tabObjets[j][i])) {

					if(ViewPanel4.dash.contactDroite(ViewPanel4.tabObjets[j][i])) {

							if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel4.tabObjets[j][i]=new Back(ViewPanel4.tabObjets[j][i].getX(),ViewPanel4.tabObjets[j][i].getY());

								ViewPanel4.dash.setWalks(true);

							}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel4.dash.setWalks(true);	

							}else if(ViewPanel4.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel4.nbr_diamant--;
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
				
				else if(View.viewFrame.getCompteur()==6) {
					
					ViewPanel5.dash.setWalksright(true);
					ViewPanel5.dash.setRest(false);

					for(int j=0;j<24;j++) {
						   
						for(int i=0;i<51;i++) {

					if(ViewPanel5.dash.procheDroite(ViewPanel5.tabObjets[j][i])) {

					if(ViewPanel5.dash.contactDroite(ViewPanel5.tabObjets[j][i])) {

							if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Ground") {

								ViewPanel5.tabObjets[j][i]=new Back(ViewPanel5.tabObjets[j][i].getX(),ViewPanel5.tabObjets[j][i].getY());

								ViewPanel5.dash.setWalks(true);

							}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Back") {

								ViewPanel5.dash.setWalks(true);	

							}else if(ViewPanel5.tabObjets[j][i].getClass().getName()=="model.Diamond"){
								ViewPanel5.nbr_diamant--;
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



