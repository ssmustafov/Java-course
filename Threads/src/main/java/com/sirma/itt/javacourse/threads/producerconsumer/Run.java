package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Shows how the producer/consumer can be used.
 * 
 * @author Sinan
 */
public final class Run {
	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		StoreHouse q = new StoreHouse(5);
		Producer p = new Producer(q);
		p.start();

		Consumer mincho = new Consumer(q);
		mincho.setName("Consumer Mincho");
		mincho.start();

		Consumer pesho = new Consumer(q);
		pesho.setName("Consumer Pesho");
		pesho.start();
	}
}
