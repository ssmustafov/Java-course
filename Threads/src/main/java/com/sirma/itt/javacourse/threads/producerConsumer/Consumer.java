package com.sirma.itt.javacourse.threads.producerConsumer;

/**
 * Represents a consumer.
 * 
 * @author Sinan
 */
public class Consumer extends Thread {
	private StoreHouse queue;

	/**
	 * Creates a new consumer.
	 * 
	 * @param storeHouse
	 *            - the storehouse from which the consumer will get production
	 */
	public Consumer(StoreHouse storeHouse) {
		this.queue = storeHouse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (true) {
				String message = (String) queue.get();
				System.out.println(getName() + " : get -> " + message);
				sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
