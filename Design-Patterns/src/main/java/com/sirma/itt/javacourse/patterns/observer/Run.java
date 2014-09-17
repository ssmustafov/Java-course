package com.sirma.itt.javacourse.patterns.observer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Shows how the Observer can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiations.
	 */
	private Run() {

	}

	/**
	 * Prints available and unavailable stocks.
	 * 
	 * @param aStock
	 *            - available stocks to be printed
	 * @param uStock
	 *            - unavailable stocks to be printed
	 */
	private static void printStocks(List<Stock> aStock, List<Stock> uStock) {
		System.out.print("[Available stocks]: ");
		for (Stock stock : aStock) {
			System.out.println(stock.getName() + " -> " + stock.getQuantity());
		}
		System.out.println();

		System.out.print("[Unavailable stocks]: ");
		for (Stock stock : uStock) {
			System.out.println(stock.getName() + " -> " + stock.getQuantity());
		}
		System.out.println();
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - argument
	 */
	public static void main(String[] args) {
		Observer a = new StockObserver();
		List<Stock> aStock = a.getAvailableStocks();
		List<Stock> uStock = a.getUnvailableStocks();

		Stock usb = new Stock("Usb", new BigDecimal("3.19"), 5);
		Stock mouse = new Stock("Mouse", new BigDecimal("33.49"), 10);
		a.add(mouse);
		a.add(usb);
		a.add(new Stock("Monitor", new BigDecimal("198.99"), 200));
		a.add(new Stock("Keyboard", new BigDecimal("50.00"), 67));
		a.add(new Stock("Battery", new BigDecimal("0.99"), 21));

		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);

		printStocks(aStock, uStock);

		a.sell(mouse, 10);

		printStocks(aStock, uStock);

		a.sell(usb, 5);
	}
}
