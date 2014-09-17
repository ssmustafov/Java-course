package com.sirma.itt.javacourse.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds stocks which are unavailable for purchase. Cannot be instantiated.
 * 
 * @author smustafov
 */
public class UnavaliableStock {

	private final List<Stock> unavailableStocks = new ArrayList<>();

	/**
	 * Adds given stock to the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock which is unavailable for purchase to be added to the list of unavailable
	 *            stocks
	 */
	public void add(Stock stock) {
		unavailableStocks.add(stock);
	}

	/**
	 * Removes given stock from the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock which is available for purchase to be removed
	 */
	public void remove(Stock stock) {
		unavailableStocks.remove(stock);
	}

	/**
	 * Returns {@code List} of the unavailable stocks.
	 * 
	 * @return - list of unavailable stocks
	 */
	public List<Stock> getUnvailableStocks() {
		return unavailableStocks;
	}

	/**
	 * Checks if given stock exists in the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock to be checked if it exists in the list of unavailable stocks
	 * @return - true if given stock is in the list of unavailable stocks; otherwise false
	 */
	public boolean containsStock(Stock stock) {
		return unavailableStocks.contains(stock);
	}

	/**
	 * Returns the number of unavailable stocks in the list.
	 * 
	 * @return - number of unavailable stocks in the list
	 */
	public int getNumberOfUnavailableStocks() {
		return unavailableStocks.size();
	}

}
