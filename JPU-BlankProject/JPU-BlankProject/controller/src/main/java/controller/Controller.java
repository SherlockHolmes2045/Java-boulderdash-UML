package controller;

import contract.ControllerOrder;

import contract.IController;

import contract.IModel;

import contract.IView;

import model.Back;
import model.Dash;
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

    @SuppressWarnings("unused")
    private IView view;

    /**
     * The model.
     */

    @SuppressWarnings("unused")
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

                moveLeft(View.viewFrame.getLevel_counter());

                break;

            case UP:

                moveUp(View.viewFrame.getLevel_counter());

                break;

            case DOWN:
                moveDown(View.viewFrame.getLevel_counter());
                break;

            case RIGHT:
                moveRight(View.viewFrame.getLevel_counter());
                break;
            default:
                break;
        }
    }

    private void decreaseDiamonds(int level) {
        if (level == 2) {
            ViewFrame.panel1.setNbr_diamond(ViewFrame.panel1.getNbr_diamond() - 1);
        } else if (level == 3) {
            ViewFrame.panel2.setNbr_diamond(ViewFrame.panel2.getNbr_diamond() - 1);
        } else if (level == 4) {
            ViewFrame.panel3.setNbr_diamond(ViewFrame.panel3.getNbr_diamond() - 1);
        } else if (level == 5) {
            ViewFrame.panel4.setNbr_diamond(ViewFrame.panel4.getNbr_diamond() - 1);
        } else if (level == 6) {
            ViewFrame.panel5.setNbr_diamond(ViewFrame.panel5.getNbr_diamond() - 1);
        }
    }

    private void moveLeft(int level) {
        Dash dash = ViewPanel.dash;
        Objet[][] tabObjets = ViewPanel.tabObjets;
        ApplicationPanel panel = ViewFrame.panel1;
        if (level == 3) {
            dash = ViewPanel2.dash;
            tabObjets = ViewPanel2.tabObjets;
            panel = ViewFrame.panel2;
        } else if (level == 4) {
            dash = ViewPanel3.dash;
            tabObjets = ViewPanel3.tabObjets;
            panel = ViewFrame.panel3;
        } else if (level == 5) {
            dash = ViewPanel4.dash;
            tabObjets = ViewPanel4.tabObjets;
            panel = ViewFrame.panel4;
        } else if (level == 6) {
            dash = ViewPanel5.dash;
            tabObjets = ViewPanel5.tabObjets;
            panel = ViewFrame.panel5;
        }

        dash.setRest(false);
        dash.setWalksleft(true);

        for (int j = 0; j < 24; j++) {

            for (int i = 0; i < 51; i++) {

                if (dash.nearLeft(tabObjets[j][i]) && dash.leftContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {
                        decreaseDiamonds(level);

                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Roc) {

                        if (tabObjets[j][i].getPushableLeft()) {
                            int x = tabObjets[j][i].getX();
                            int y = tabObjets[j][i].getY();
                            tabObjets[j][i].setX(tabObjets[j][i].getX() - 32);
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

            dash.setX(dash.getX() - 32);

        }

    }

    private void moveUp(int level) {

        Dash dash = ViewPanel.dash;
        Objet[][] tabObjets = ViewPanel.tabObjets;
        ApplicationPanel panel = ViewFrame.panel1;
        if (level == 3) {
            dash = ViewPanel2.dash;
            tabObjets = ViewPanel2.tabObjets;
            panel = ViewFrame.panel2;
        } else if (level == 4) {
            dash = ViewPanel3.dash;
            tabObjets = ViewPanel3.tabObjets;
            panel = ViewFrame.panel3;
        } else if (level == 5) {
            dash = ViewPanel4.dash;
            tabObjets = ViewPanel4.tabObjets;
            panel = ViewFrame.panel4;
        } else if (level == 6) {
            dash = ViewPanel5.dash;
            tabObjets = ViewPanel5.tabObjets;
            panel = ViewFrame.panel5;
        }
        dash.setRest(false);

        dash.setWalksup(true);

        for (int j = 0; j < 24; j++) {

            for (int i = 0; i < 51; i++) {

                if (tabObjets[j][i] != null && dash.nearUp(tabObjets[j][i]) && dash.upContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        decreaseDiamonds(level);
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

            dash.setY(dash.getY() - 32);

        }
    }

    private void moveRight(int level) {

        Dash dash = ViewPanel.dash;
        Objet[][] tabObjets = ViewPanel.tabObjets;
        ApplicationPanel panel = ViewFrame.panel1;
        if (level == 3) {
            dash = ViewPanel2.dash;
            tabObjets = ViewPanel2.tabObjets;
            panel = ViewFrame.panel2;
        } else if (level == 4) {
            dash = ViewPanel3.dash;
            tabObjets = ViewPanel3.tabObjets;
            panel = ViewFrame.panel3;
        } else if (level == 5) {
            dash = ViewPanel4.dash;
            tabObjets = ViewPanel4.tabObjets;
            panel = ViewFrame.panel4;
        } else if (level == 6) {
            dash = ViewPanel5.dash;
            tabObjets = ViewPanel5.tabObjets;
            panel = ViewFrame.panel5;
        }
        dash.setRest(false);
        dash.setWalksright(true);

        for (int j = 0; j < 24; j++) {

            for (int i = 0; i < 51; i++) {

                if (dash.nearRight(tabObjets[j][i]) && dash.rightContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        decreaseDiamonds(level);
                        dash.setScore(dash.getScore() + 20);
                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());
                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Roc) {

                        if (tabObjets[j][i].getPushableRight()) {
                            int x = tabObjets[j][i].getX();
                            int y = tabObjets[j][i].getY();
                            tabObjets[j][i].setX(tabObjets[j][i].getX() + 32);
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

            dash.setX(dash.getX() + 32);


            if (level == 2 && dash.getX() == 1344 && dash.getY() == 544 && ViewFrame.panel1.isExitable()) {

                View.viewFrame.setLevel_counter(View.viewFrame.getLevel_counter() + 1);
                ViewFrame.card.show(ViewFrame.container, "" + View.viewFrame.getLevel_counter());

            }


        }

    }

    private void moveDown(int level) {

        Dash dash = ViewPanel.dash;
        Objet[][] tabObjets = ViewPanel.tabObjets;
        ApplicationPanel panel = ViewFrame.panel1;
        if (level == 3) {
            dash = ViewPanel2.dash;
            tabObjets = ViewPanel2.tabObjets;
            panel = ViewFrame.panel2;
        } else if (level == 4) {
            dash = ViewPanel3.dash;
            tabObjets = ViewPanel3.tabObjets;
            panel = ViewFrame.panel3;
        } else if (level == 5) {
            dash = ViewPanel4.dash;
            tabObjets = ViewPanel4.tabObjets;
            panel = ViewFrame.panel4;
        } else if (level == 6) {
            dash = ViewPanel5.dash;
            tabObjets = ViewPanel5.tabObjets;
            panel = ViewFrame.panel5;
        }

        dash.setRest(false);
        dash.setWalksdown(true);

        for (int j = 0; j < 24; j++) {

            for (int i = 0; i < 51; i++) {


                if (dash.nearDown(tabObjets[j][i]) && dash.downContact(tabObjets[j][i])) {

                    if (tabObjets[j][i] instanceof model.Ground) {

                        tabObjets[j][i] = new Back(tabObjets[j][i].getX(), tabObjets[j][i].getY());

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Back) {

                        dash.setWalks(true);

                    } else if (tabObjets[j][i] instanceof model.Diamond) {

                        decreaseDiamonds(level);
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

            dash.setY(dash.getY() + 32);

            if (level == 3 && ViewPanel2.dash.getX() == 672 && ViewPanel2.dash.getY() == 704 && ViewFrame.panel2.isExitable()) {
                System.out.println("ok");
                View.viewFrame.setLevel_counter(View.viewFrame.getLevel_counter() + 1);
                ViewFrame.card.show(ViewFrame.container, "" + View.viewFrame.getLevel_counter());
            }


        }

    }

}



