package com.sirma.itt.javacourse.threads.producerconsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a consumer.
 * 
 * @author Sinan
 */
public class Consumer extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(Consumer.class);
	private static final int TIME_TO_WAIT = 3000;
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new consumer with default time to wait 3 seconds.
	 * 
	 * @param storeHouse
	 *            - the storehouse from which the consumer will get production
	 */
	public Consumer(StoreHouse storeHouse) {
		this(storeHouse, TIME_TO_WAIT);
	}

	/**
	 * Creates a new consumer with given time to wait.
	 * 
	 * @param storeHouse
	 *            - the storehouse from which the consumer will get production
	 * @param time
	 *            - time the consumer to wait
	 */
	public Consumer(StoreHouse storeHouse, int time) {
		this.storeHouse = storeHouse;
		this.time = time;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		try {
			while (true) {
				String message = (String) storeHouse.get();
				System.out.println(getName() + " : get -> " + message);
				wait(time);
			}
		} catch (InterruptedException e) {
			LOGGER.error("Sleep interrupted", e);
		}
	}
}
