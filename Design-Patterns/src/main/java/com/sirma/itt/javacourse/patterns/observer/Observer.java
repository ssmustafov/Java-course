package com.sirma.itt.javacourse.patterns.observer;

import java.util.List;

/**
 * @author smustafov
 */
public interface Observer {

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
