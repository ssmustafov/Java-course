package com.sirma.itt.javacourse.patterns.observer;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.pool.StockObserver} class.
 * 
 * @author smustafov
 */
public class ObserverTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.StockObserver} by trying to sell stock
	 * with quantity more than the actual quantity.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSellStockMoreThanQuantity() {
		Observer a = new StockObserver();

		Stock usb = new Stock("Usb", new BigDecimal("3.19"), 5);
		a.add(usb);
		a.sell(usb, 6);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.StockObserver} by trying to sell stock
	 * when there is no available quantity.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSellStockWhenNoQuantity() {
		Observer a = new StockObserver();

		Stock mouse = new Stock("Mouse", new BigDecimal("33.49"), 10);
		a.add(mouse);
		a.sell(mouse, 6);
		a.sell(mouse, 1);
		a.sell(mouse, 1);
		a.sell(mouse, 2);
		a.sell(mouse, 1);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.StockObserver} to check if it distributes
	 * the stocks in right class when stock's quantity is unavailable.
	 */
	@Test
	public void testDistributingToClasses() {
		Observer a = new StockObserver();
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
		a.sell(mouse, 10);

		int actualAvailable = a.getAvailableStocks().size();
		int actualUnavailable = a.getUnvailableStocks().size();
		int expectedAvailable = 3;
		int expectedUnavailable = 2;

		assertEquals(expectedAvailable, actualAvailable);
		assertEquals(expectedUnavailable, actualUnavailable);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.StockObserver} to check if it distributes
	 * the stocks in right class when stock is unavailable and it becomes available.
	 */
	@Test
	public void testUnavailableStockToAvailable() {
		Observer a = new StockObserver();
		Stock usb = new Stock("Usb", new BigDecimal("3.19"), 5);
		Stock mouse = new Stock("Mouse", new BigDecimal("33.49"), 10);

		a.add(mouse);
		a.add(usb);
		a.add(new Stock("Keyboard", new BigDecimal("50.00"), 67));

		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(usb, 1);
		a.sell(mouse, 10);
		a.changeQuantity(usb, 100);

		int actualAvailable = a.getAvailableStocks().size();
		int actualUnavailable = a.getUnvailableStocks().size();
		int expectedAvailable = 2;
		int expectedUnavailable = 1;

		assertEquals(expectedAvailable, actualAvailable);
		assertEquals(expectedUnavailable, actualUnavailable);
	}

}
