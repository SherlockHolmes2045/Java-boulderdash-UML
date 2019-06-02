package view;



import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;

import java.awt.HeadlessException;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;



import javax.swing.JFrame;

import javax.swing.JOptionPane;



import contract.IController;

import contract.IModel;



/**

 * The Class ViewFrame.

 *

 * @author Jean-Aymeric Diet

 */

public class ViewFrame extends JFrame  {

	public static Container container;
	private  int compteur;
	public static CardLayout card;
	public static ViewPanel panel1;
	public static ViewPanel2 panel2;
	public static ViewPanel3 panel3;
	public static ViewPanel4 panel4;
	public static ViewPanel5 panel5;
	/** The model. */

	private IModel						model;



	/** The controller. */

	private static IController				controller;

	/** The Constant serialVersionUID. */

	private static final long	serialVersionUID	= -697358409737458175L;



	/**

	 * Instantiates a new view frame.

	 *

	 * @param model

	 *          the model

	 * @throws HeadlessException

	 *           the headless exception

	 */

	public ViewFrame(final IModel model) throws HeadlessException {

		this.buildViewFrame(model);

	}



	/**

	 * Instantiates a new view frame.

	 *

	 * @param model

	 *          the model

	 * @param gc

	 *          the gc

	 */

	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {

		super(gc);

		this.buildViewFrame(model);

	}



	/**

	 * Instantiates a new view frame.

	 *

	 * @param model

	 *          the model

	 * @param title

	 *          the title

	 * @throws HeadlessException

	 *           the headless exception

	 */

	/*public ViewFrame(final IModel model, final String title) throws HeadlessException {

		super(title);

		this.buildViewFrame(model);

	}*/



	/**

	 * Instantiates a new view frame.

	 *

	 * @param model

	 *          the model

	 * @param title

	 *          the title

	 * @param gc

	 *          the gc

	 */

	public ViewFrame(/*final IModel model, final String title, final GraphicsConfiguration gc*/) {

		/*super(title, gc);

		this.buildViewFrame(model);*/
		card=new CardLayout();
		container=new Container();
		panel1=new ViewPanel();
		panel2=new ViewPanel2();
		panel3=new ViewPanel3();
		panel4=new ViewPanel4();
		panel5=new ViewPanel5();
		container.setLayout(card);
		panel1.setLayout(null);
		this.compteur=2;
		container.add(panel1,"2");
		container.add(panel2,"3");
		container.add(panel5,"4");
		container.add(panel3,"5");
		container.add(panel4,"6");
		card.show(container, "1");
		
		this.setModel(model);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(false);
		
		this.add(container);

		this.setSize(1638,802);
	
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	
	}



	/**

	 * Gets the controller.

	 *

	 * @return the controller

	 */

	public static IController getController() {

		return controller;

	}



	/**

	 * Sets the controller.

	 *

	 * @param controller

	 *          the new controller

	 */

	protected void setController(final IController controller) {

		this.controller = controller;

	}



	public int getCompteur() {
		return compteur;
	}



	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}



	/**

	 * Gets the model.

	 *

	 * @return the model

	 */

	protected IModel getModel() {

		return this.model;

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

	 * Builds the view frame.

	 *

	 * @param model

	 *          the model

	 */

	private void buildViewFrame(final IModel model) {
		/*card=new CardLayout();
		compteur=2;
		
		this.setModel(model);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(false);


		this.add(panel1=new ViewPanel(this));

		this.setSize(1638,802);
	
		this.setLocationRelativeTo(null);*/
		
	}


}