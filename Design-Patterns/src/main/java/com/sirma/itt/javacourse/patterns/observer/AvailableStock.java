package com.sirma.itt.javacourse.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds stocks which are available for purchase. Cannot be instantiated.
 * 
 * @author smustafov
 */
public class AvailableStock {

	private final List<Stock> availableStocks = new ArrayList<>();

	/**
	 * Adds given stock to the list of available stocks.
	 * 
	 * @param stock
	 *            - stock which is available for purchase to be added to the list of available
	 *            stocks
	 */
	public void add(Stock stock) {
		availableStocks.add(stock);
	}

	/**
	 * Removes given stock from the list of available stocks.
	 * 
	 * @param stock
	 *            - stock which is not available for purchase to be removed
	 */
	public void remove(Stock stock) {
		availableStocks.remove(stock);
	}

	/**
	 * Returns {@code List} of the available stocks.
	 * 
	 * @return - list of available stocks
	 */
	public List<Stock> getAvailableStocks() {
		return availableStocks;
	}

	/**
	 * Checks if given stock exists in the list of available stocks.
	 * 
	 * @param stock
	 *            - stock to be checked if it exists in the list of available stocks
	 * @return - true if given stock is in the list of available stocks; otherwise false
	 */
	public boolean containsStock(Stock stock) {
		return availableStocks.contains(stock);
	}

	/**
	 * Returns the number of available stocks in the list.
	 * 
	 * @return - number of available stocks in the list
	 */
	public int getNumberOfAvailableStocks() {
		return availableStocks.size();
	}

}
