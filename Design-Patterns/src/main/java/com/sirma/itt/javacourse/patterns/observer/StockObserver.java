package com.sirma.itt.javacourse.patterns.observer;

/**
 * @author smustafov
 */
public class StockObserver implements Observer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Stock stock) {
		if (stock.getQuantity() <= 0) {
			if (AvailableStock.containsStock(stock)) {
				AvailableStock.remove(stock);
			}

			if (!UnavaliableStock.containsStock(stock)) {
				UnavaliableStock.add(stock);
			}
		} else {
			if (UnavaliableStock.containsStock(stock)) {
				UnavaliableStock.remove(stock);
			}

			if (!AvailableStock.containsStock(stock)) {
				AvailableStock.add(stock);
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
		try {
			stock.setQuantity(stock.getQuantity() - quantity);
		} catch (IllegalArgumentException e) {
			System.err.println("The stock '" + stock.getName()
					+ "' is not available for purchase rigth now");
		}
		update(stock);
	}

}
