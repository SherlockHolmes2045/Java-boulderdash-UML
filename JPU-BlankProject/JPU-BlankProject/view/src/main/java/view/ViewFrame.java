package view;

import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.Serial;
import javax.swing.*;

import contract.IController;
import contract.IModel;

/**
 * The ViewFrame class represents the main window of the application, extending JFrame.
 * It manages the display of different game levels using a CardLayout and contains
 * references to various panels and controllers. The class provides constructors for
 * initializing the frame with or without a model and graphics configuration, and methods
 * for setting and getting the model and controller. It also includes functionality to
 * build the view frame and manage the level switching.
 *
 * @author Lemovou Ivan
 */

public class ViewFrame extends JFrame {

    /**
     * The container for all the others panels.
     */
    public static final Container container = new Container();

    /**
     * The parameter that controls the switching of level.
     */
    private int levelCounter;

    /**
     * The Layout.
     */
    public static final CardLayout card = new CardLayout();

    /**
     * The panel for the level 1.
     */
    public static final ViewPanel panel1 = new ViewPanel();

    /**
     * The panel for the level 2.
     */
    public static final ViewPanel2 panel2 = new ViewPanel2();

    /**
     * The panel for the level 3.
     */
    public static final ViewPanel3 panel3 = new ViewPanel3();

    /**
     * The panel for the level 4.
     */
    public static final ViewPanel4 panel4 = new ViewPanel4();

    /**
     * The panel for the level 5.
     */
    public static final ViewPanel5 panel5 = new ViewPanel5();

    /**
     * The model.
     */

    private IModel model;

    /**
     * The controller.
     */

    private static IController controller;

    /**
     * The Constant serialVersionUID.
     */

    @Serial
    private static final long serialVersionUID = -697358409737458175L;

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @throws HeadlessException the headless exception
     */

    public ViewFrame(final IModel model) throws HeadlessException {
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @param gc    the gc
     */

    public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
        super(gc);
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        this.buildViewFrame(model);
    }


    /**
     * Instantiates a new view frame.
     */

    public ViewFrame() {
        this.buildViewFrame();
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
     * @param controller the new controller
     */

    protected void setController(final IController controller) {
        ViewFrame.controller = controller;
    }


    public int getLevelCounter() {
        return levelCounter;
    }


    public void setLevelCounter(int levelCounter) {
        this.levelCounter = levelCounter;
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
     * @param model the new model
     */

    private void setModel(final IModel model) {
        this.model = model;
    }


    /**
     * Builds the view frame.
     *
     * @param model the model
     */

    private void buildViewFrame(final IModel model) {
        container.setLayout(card);
        panel1.setLayout(null);
        this.levelCounter = 2;
        container.add(panel1, "2");
        container.add(panel2, "3");
        container.add(panel3, "4");
        container.add(panel4, "5");
        container.add(panel5, "6");
        card.show(container, "1");
        this.setModel(model);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("BoulderDash");
        this.setResizable(false);
        this.add(container);
        this.setSize(1638, 802);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void buildViewFrame() {
        container.setLayout(card);
        panel1.setLayout(null);
        this.levelCounter = 2;
        container.add(panel1, "2");
        container.add(panel2, "3");
        container.add(panel3, "4");
        container.add(panel4, "5");
        container.add(panel5, "6");
        card.show(container, "1");
        this.setModel(model);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("BoulderDash");
        this.setResizable(false);
        this.add(container);
        this.setSize(1638, 802);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}