/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Level;
import model.Model;
import model.Roc;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
	public static View view;
	
    public static void main(final String[] args) {
    
         view = new View();
        final Controller controller = new Controller(view);
        view.setController(controller);
        controller.control();
        controller.orderPerform(ControllerOrder.LEFT);
    }
}
