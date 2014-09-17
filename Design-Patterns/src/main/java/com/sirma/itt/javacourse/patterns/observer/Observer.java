package com.sirma.itt.javacourse.patterns.observer;

import java.util.List;

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

	/**
	 * Changes the quantity of given stock.
	 * 
	 * @param stock
	 *            - stock which quantity to be changed
	 * @param quantity
	 *            - quantity of the stock to be set
	 */
	void changeQuantity(Stock stock, int quantity);

	/**
	 * Returns {@code List} of the unavailable stocks.
	 * 
	 * @return - list of unavailable stocks
	 */
	List<Stock> getUnvailableStocks();

	/**
	 * Returns {@code List} of the available stocks.
	 * 
	 * @return - list of available stocks
	 */
	List<Stock> getAvailableStocks();

}
