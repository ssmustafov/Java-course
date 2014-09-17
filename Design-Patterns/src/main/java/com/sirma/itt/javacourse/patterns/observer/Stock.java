package com.sirma.itt.javacourse.patterns.observer;

import java.math.BigDecimal;

/**
 * Represents a stock.
 * 
 * @author smustafov
 */
public class Stock {

	private String name;
	private BigDecimal price;
	private int quantity;

	/**
	 * Creates a new stock with given name, price and quantity.
	 * 
	 * @param name
	 *            - name of the stock
	 * @param price
	 *            - price of the stock
	 * @param quantity
	 *            - quantity of the stock
	 */
	public Stock(String name, BigDecimal price, int quantity) {
		this.name = name;
		this.price = price;
		this.setQuantity(quantity);
	}

	/**
	 * Returns the name of the stock.
	 * 
	 * @return - name of the stock
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the price of the stock.
	 * 
	 * @return - price of the stock
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Returns the quantity of the stock.
	 * 
	 * @return - quantity of the stock
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the stock.
	 * 
	 * @param quantity
	 *            - quantity of the stock to be set
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("The stock '" + getName()
					+ "' is not available for purchase");
		}

		this.quantity = quantity;
	}

}
