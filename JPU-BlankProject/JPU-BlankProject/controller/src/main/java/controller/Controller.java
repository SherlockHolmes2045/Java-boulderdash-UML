package controller;

import contract.ControllerOrder;

import contract.IController;

import contract.IModel;

import contract.IView;

import model.Back;
import model.Dash;
import model.GameConstants;
import model.Objet;
import view.*;

/**
 * The Class Controller.
 *
 * @author Lemovou Dachi Ivan
 */

public final class Controller implements IController {

    /**
     * The view.
     */

    private IView view;

    /**
     * The model.
     */

    private IModel model;

    /**
     * Instantiates a new controller.
     *
     * @param view the view
     */

    public Controller(final IView view) {

        this.setView(view);

    }

    /**
     * @see contract.IController#control()
     */

    public void control() {
    }

    /**
     * Sets the view.
     *
     * @param pview the new view
     */

    private void setView(final IView pview) {
        this.view = pview;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */

    @SuppressWarnings("unused")
    private void setModel(final IModel model) {

        this.model = model;

    }


    /**
     * @see contract.IController#orderPerform(contract.ControllerOrder)
     */

    public void orderPerform(final ControllerOrder controllerOrder) {

        switch (controllerOrder) {

            case LEFT:

                moveLeft(View.viewFrame.getLevelCounter());

                break;

            case UP:

                moveUp(View.viewFrame.getLevelCounter());

                break;

            case DOWN:
                moveDown(View.viewFrame.getLevelCounter());
                break;

            case RIGHT:
                moveRight(View.viewFrame.getLevelCounter());
                break;
            default:
                break;
        }
    }


    private void moveLeft(int level) {
        LevelPanel panel = ViewFrame.panels.stream().filter(p -> p.getLevel().getLevelNumber() == level).findFirst().orElse(ViewFrame.panels.get(0));
        Dash dash = panel.getDash();
        Objet[][] tabObjets = panel.getTabObjets();


        dash.setRest(false);
        dash.setWalksleft(true);

        for (int j = 0; j < GameConstants.COLUMN; j++) {

            for (int i = 0; i < GameConstants.ROW; i++) {

                if (dash.leftContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back || tabObjets[j][i] instanceof model.ExitDoor) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {
                        panel.setDiamondCount(panel.getDiamondCount() - 1);
                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Roc) {

                        if (tabObjets[j][i].getPushableLeft()) {
                            int x = tabObjets[j][i].getX();
                            int y = tabObjets[j][i].getY();
                            tabObjets[j][i].setX(tabObjets[j][i].getX() - GameConstants.PIXEL_SIZE);
                            tabObjets[j][i - 1] = tabObjets[j][i];
                            tabObjets[j][i] = new Back(x, y);
                            dash.setWalks(true);
                        } else {
                            dash.setWalks(false);

                        }

                    } else {
                        dash.setWalks(false);
                    }

                }

            }
        }


        if (dash.getWalks()) {

            dash.setX(dash.getX() - GameConstants.PIXEL_SIZE);

            if (dash.getX() == panel.getExit().getX() && dash.getY() == panel.getExit().getY() && panel.isExitable()) {

                View.viewFrame.setLevelCounter(View.viewFrame.getLevelCounter() + 1);
                View.viewFrame.changeLevelPanel(View.viewFrame.getLevelCounter());

            }

        }

    }

    private void moveUp(int level) {

        LevelPanel panel = ViewFrame.panels.stream().filter(p -> p.getLevel().getLevelNumber() == level).findFirst().orElse(ViewFrame.panels.get(0));
        Dash dash = panel.getDash();
        Objet[][] tabObjets = panel.getTabObjets();

        dash.setRest(false);

        dash.setWalksup(true);

        for (int j = 0; j < GameConstants.COLUMN; j++) {

            for (int i = 0; i < GameConstants.ROW; i++) {

                if (tabObjets[j][i] != null  && dash.upContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back || tabObjets[j][i] instanceof model.ExitDoor) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        panel.setDiamondCount(panel.getDiamondCount() - 1);
                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);
                    } else {

                        dash.setWalks(false);

                    }
                }


            }
        }


        if (dash.getWalks()) {

            dash.setY(dash.getY() - GameConstants.PIXEL_SIZE);

            if (dash.getX() == panel.getExit().getX() && dash.getY() == panel.getExit().getY() && panel.isExitable()) {

                View.viewFrame.setLevelCounter(View.viewFrame.getLevelCounter() + 1);
                View.viewFrame.changeLevelPanel(View.viewFrame.getLevelCounter());

            }

        }
    }

    private void moveRight(int level) {

        LevelPanel panel = ViewFrame.panels.stream().filter(p -> p.getLevel().getLevelNumber() == level).findFirst().orElse(ViewFrame.panels.get(0));
        Dash dash = panel.getDash();
        Objet[][] tabObjets = panel.getTabObjets();

        dash.setRest(false);
        dash.setWalksright(true);

        for (int j = 0; j < GameConstants.COLUMN; j++) {

            for (int i = 0; i < GameConstants.ROW; i++) {

                if (dash.rightContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back || tabObjets[j][i] instanceof model.ExitDoor) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        panel.setDiamondCount(panel.getDiamondCount() - 1);
                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Roc) {

                        if (tabObjets[j][i].getPushableRight()) {
                            int x = tabObjets[j][i].getX();
                            int y = tabObjets[j][i].getY();
                            tabObjets[j][i].setX(tabObjets[j][i].getX() + GameConstants.PIXEL_SIZE);
                            tabObjets[j][i + 1] = tabObjets[j][i];
                            tabObjets[j][i] = new Back(x, y);
                            dash.setWalks(true);
                        } else {
                            dash.setWalks(false);

                        }

                    } else {
                        dash.setWalks(false);
                    }

                }

            }
        }

        if (dash.getWalks()) {

            dash.setX(dash.getX() + GameConstants.PIXEL_SIZE);


            if (dash.getX() == panel.getExit().getX() && dash.getY() == panel.getExit().getY() && panel.isExitable()) {

                View.viewFrame.setLevelCounter(View.viewFrame.getLevelCounter() + 1);
                View.viewFrame.changeLevelPanel(View.viewFrame.getLevelCounter());

            }


        }

    }

    private void moveDown(int level) {
        LevelPanel panel = ViewFrame.panels.stream().filter(p -> p.getLevel().getLevelNumber() == level).findFirst().orElse(ViewFrame.panels.get(0));
        Dash dash = panel.getDash();
        Objet[][] tabObjets = panel.getTabObjets();


        dash.setRest(false);
        dash.setWalksdown(true);

        for (int j = 0; j < GameConstants.COLUMN; j++) {

            for (int i = 0; i < GameConstants.ROW; i++) {


                if (dash.downContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back || tabObjets[j][i] instanceof model.ExitDoor) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        panel.setDiamondCount(panel.getDiamondCount() - 1);
                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);

                    } else {

                        dash.setWalks(false);

                    }
                }

            }
        }


        if (dash.getWalks()) {

            dash.setY(dash.getY() + GameConstants.PIXEL_SIZE);

            if (dash.getX() == panel.getExit().getX() && dash.getY() == panel.getExit().getY() && panel.isExitable()) {

                View.viewFrame.setLevelCounter(View.viewFrame.getLevelCounter() + 1);
                View.viewFrame.changeLevelPanel(View.viewFrame.getLevelCounter());

            }


        }

    }

}



