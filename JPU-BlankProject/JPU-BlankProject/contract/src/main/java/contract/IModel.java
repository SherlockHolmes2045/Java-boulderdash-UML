package contract;

import java.util.Observable;


/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {



	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
