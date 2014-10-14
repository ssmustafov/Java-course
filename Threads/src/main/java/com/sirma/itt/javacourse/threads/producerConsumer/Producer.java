package com.sirma.itt.javacourse.threads.producerConsumer;

import java.util.Date;

/**
 * Represents a producer.
 * 
 * @author Sinan
 */
public class Producer extends Thread {
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new producer.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 */
	public Producer(StoreHouse storeHouse) {
		this.storeHouse = storeHouse;
		time = 500;
	}

	/**
	 * Creates a new producer with given time to wait.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 * @param time
	 *            - time the poducer to wait
	 */
	public Producer(StoreHouse storeHouse, int time) {
		this.storeHouse = storeHouse;
		this.time = time;
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
				storeHouse.put(message);
				sleep(time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
