package com.sirma.itt.javacourse.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds stocks which are unavailable for purchase. Cannot be instantiated.
 * 
 * @author smustafov
 */
public final class UnavaliableStock {

	private static final List<Stock> UNAVAILABLE_STOCKS = new ArrayList<>();

	/**
	 * Protects from instantiation.
	 */
	private UnavaliableStock() {

	}

	/**
	 * Adds given stock to the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock which is unavailable for purchase to be added to the list of unavailable
	 *            stocks
	 */
	public static void add(Stock stock) {
		UNAVAILABLE_STOCKS.add(stock);
	}

	/**
	 * Removes given stock from the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock which is available for purchase to be removed
	 */
	public static void remove(Stock stock) {
		UNAVAILABLE_STOCKS.remove(stock);
	}

	/**
	 * Returns {@code List} of the unavailable stocks.
	 * 
	 * @return - list of unavailable stocks
	 */
	public static List<Stock> getUnvailableStocks() {
		return UNAVAILABLE_STOCKS;
	}

	/**
	 * Checks if given stock exists in the list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock to be checked if it exists in the list of unavailable stocks
	 * @return - true if given stock is in the list of unavailable stocks; otherwise false
	 */
	public static boolean containsStock(Stock stock) {
		return UNAVAILABLE_STOCKS.contains(stock);
	}

}
