package view;

import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.Serial;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import javax.swing.*;

import contract.IController;
import contract.IModel;
import model.*;

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
     * List of panels for all levels.
     */
    public static List<LevelPanel> panels = getLevels();


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
        this.buildViewFrame(null);
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


    public static List<LevelPanel> getLevels() {
        DAOLevel dao = new DAOLevel();
        List<Map<String, Integer>> levelsData = dao.getLevelsData();
        return levelsData.stream().map(map -> new LevelPanel(new Level(map.get("level"), levelsData.size()), map.get("diamond_count"), new ExitDoor(map.get("exitX"), map.get("exitY")), new Dash(map.get("dashX"), map.get("dashY")), map.get("game_duration"))).toList();
    }


    /**
     * Builds the view frame.
     *
     * @param model the model
     */

    private void buildViewFrame(final IModel model) {
        container.setLayout(card);
        panels.get(0).setLayout(null);
        this.levelCounter = 1;
        IntStream.range(0, panels.size()).forEachOrdered(i -> container.add(panels.get(i), String.valueOf(i + 1)));
        card.show(container, String.valueOf(this.levelCounter));
        if (model != null) {
            this.setModel(model);
        }
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("BoulderDash");
        this.setResizable(false);
        this.add(container);
        this.setSize(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        container.revalidate();
        this.setVisible(true);
    }


    public void changeLevelPanel(int level) {
        if (level != 0 && level < panels.size()) {
            card.show(container, String.valueOf(level));
        }
    }

}