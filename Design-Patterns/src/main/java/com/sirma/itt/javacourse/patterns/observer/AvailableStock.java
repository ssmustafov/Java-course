package com.sirma.itt.javacourse.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds stocks which are available for purchase. Cannot be instantiated.
 * 
 * @author smustafov
 */
public final class AvailableStock {

	private static final List<Stock> AVAILABLE_STOCKS = new ArrayList<>();

	/**
	 * Protects from instantiation.
	 */
	private AvailableStock() {

	}

	/**
	 * Adds given stock to the list of available stocks.
	 * 
	 * @param stock
	 *            - stock which is available for purchase to be added to the list of available
	 *            stocks
	 */
	public static void add(Stock stock) {
		AVAILABLE_STOCKS.add(stock);
	}

	/**
	 * Removes given stock from the list of available stocks.
	 * 
	 * @param stock
	 *            - stock which is not available for purchase to be removed
	 */
	public static void remove(Stock stock) {
		AVAILABLE_STOCKS.remove(stock);
	}

	/**
	 * Returns {@code List} of the available stocks.
	 * 
	 * @return - list of available stocks
	 */
	public static List<Stock> getAvailableStocks() {
		return AVAILABLE_STOCKS;
	}

	/**
	 * Checks if given stock exists in the list of available stocks.
	 * 
	 * @param stock
	 *            - stock to be checked if it exists in the list of available stocks
	 * @return - true if given stock is in the list of available stocks; otherwise false
	 */
	public static boolean containsStock(Stock stock) {
		return AVAILABLE_STOCKS.contains(stock);
	}

}
