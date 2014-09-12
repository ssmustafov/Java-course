package com.sirma.itt.javacourse.patterns.observer;

/**
 * @author smustafov
 */
public interface Observer {

	// TODO: This update method is probably redundant - consider it
	/**
	 * Adds given stock to the appropriate class. Depending if it has available quantity to list of
	 * available stocks and if it doesn't have available quantity to list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock to be added to appropriate class.
	 */
	void update(Stock stock);

	/**
	 * Adds the given stock depending on its quantity to available stocks or to unavailable stocks.
	 * 
	 * @param stock
	 *            - stock to be added
	 */
	void add(Stock stock);

	/**
	 * Sales the given stock with given quantity.
	 * 
	 * @param stock
	 *            - stock to be sold
	 * @param quantity
	 *            - how many stocks
	 */
	void sell(Stock stock, int quantity);

}
