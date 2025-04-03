/**
 * @author Lemovou Dachi Ivan
 * @version 1.0
 */
package main;

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
    public static final View view = new View();

    public static void main(final String[] args) {

        final Controller controller = new Controller(view);
        view.setController(controller);
    }
}
