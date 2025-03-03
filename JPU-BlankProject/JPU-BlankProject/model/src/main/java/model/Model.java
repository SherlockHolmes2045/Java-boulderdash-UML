package model;

import java.util.Observable;


/**
 * @author Lemovou Ivan
 * the class Objet
 */

public class Model extends Observable {


    /**
     * Gets the observable.
     *
     * @return the observable
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }

}
