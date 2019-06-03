package model;

import java.util.Observable;


/**
 * 
 * @author Tamandjou lesly
 *		the class Objet
 */

	public  class Model extends Observable{

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		
	}	

	/**
     * Gets the observable.
     *
     * @return the observable
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

}
