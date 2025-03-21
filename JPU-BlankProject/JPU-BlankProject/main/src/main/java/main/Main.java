/**
 * @author Lemovou Dachi Ivan
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import view.View;

/**
 * The Class Main.
 *
 * @author Lemovou Dachi Ivan
 */
public abstract class Main {

    /**
     * The main method.
     */
    public static View view;

    public static void main(final String[] args) {

        view = new View();
        final Controller controller = new Controller(view);
        view.setController(controller);
        controller.control();
        //controller.orderPerform(ControllerOrder.LEFT);
    }
}
