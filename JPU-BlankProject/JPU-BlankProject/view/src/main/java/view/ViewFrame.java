package view;
import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Welaji chris-yvan
 */

public class ViewFrame extends JFrame  {

	/** The container for all the others panels.*/
	public static Container container;
	
	/** The parameter that controls the switching of level. */ 
	private  int level_counter;
	
	/** The Layout. */
	public static CardLayout card;
	
	/** The panel for the level 1. */
	public static ViewPanel panel1;
	 
	/** The panel for the level 2. */
	public static ViewPanel2 panel2;
	
	/** The panel for the level 3. */
	public static ViewPanel3 panel3;
	
	/** The panel for the level 4. */
	public static ViewPanel4 panel4;
	
	/** The panel for the level 5. */
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
	 * 
	 * Instantiates a new view frame.
	 */

	public ViewFrame() {

		card=new CardLayout();
		container=new Container();
		panel1=new ViewPanel();
		panel2=new ViewPanel2();
		panel3=new ViewPanel3();
		panel4=new ViewPanel4();
		panel5=new ViewPanel5();
		container.setLayout(card);
		panel1.setLayout(null);
		this.level_counter=2;
		container.add(panel1,"2");
		container.add(panel2,"3");
		container.add(panel3,"4");
		container.add(panel4,"5");
		container.add(panel5,"6");
		card.show(container, "1");
		
		this.setModel(model);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("BoulderDash");
		
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

	@SuppressWarnings("static-access")
	protected void setController(final IController controller) {
		this.controller = controller;
	}



	public int getLevel_counter() {
		return level_counter;
	}

	
	public void setLevel_counter(int level_counter) {
		this.level_counter= level_counter;
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
	}

}