package com.sirma.itt.javacourse.patterns.observer;

import java.util.List;

/**
 * Observes available and unavailable stocks and depending on that sends the given stock to
 * <code>AvailableStock</code> or <code>UnavailableStock</code>.
 * 
 * @author smustafov
 */
public class StockObserver implements Observer {

	private final AvailableStock availableStocks = new AvailableStock();
	private final UnavaliableStock unavailableStocks = new UnavaliableStock();

	/**
	 * Adds given stock to the appropriate class. Depending if it has available quantity to list of
	 * available stocks and if it doesn't have available quantity to list of unavailable stocks.
	 * 
	 * @param stock
	 *            - stock to be added to appropriate class.
	 */
	private void update(Stock stock) {
		if (stock.getQuantity() <= 0) {
			if (availableStocks.containsStock(stock)) {
				availableStocks.remove(stock);
			}

			if (!unavailableStocks.containsStock(stock)) {
				unavailableStocks.add(stock);
			}
		} else {
			if (unavailableStocks.containsStock(stock)) {
				unavailableStocks.remove(stock);
			}

			if (!availableStocks.containsStock(stock)) {
				availableStocks.add(stock);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Stock stock) {
		update(stock);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sell(Stock stock, int quantity) {
		stock.setQuantity(stock.getQuantity() - quantity);
		update(stock);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeQuantity(Stock stock, int quantity) {
		stock.setQuantity(quantity);
		update(stock);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Stock> getUnvailableStocks() {
		return unavailableStocks.getUnvailableStocks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Stock> getAvailableStocks() {
		return availableStocks.getAvailableStocks();
	}

}
