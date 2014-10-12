package com.sirma.itt.javacourse.threads.producerConsumer;

import java.util.Date;

/**
 * Represents a producer.
 * 
 * @author Sinan
 */
public class Producer extends Thread {
	private StoreHouse queue;

	/**
	 * Creates a new producer.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 */
	public Producer(StoreHouse storeHouse) {
		this.queue = storeHouse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (true) {
				String message = new Date().toString();
				System.out.println("Producer : put -> " + message);
				queue.put(message);
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
