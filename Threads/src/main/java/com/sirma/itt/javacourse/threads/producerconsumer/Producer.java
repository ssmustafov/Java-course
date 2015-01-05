package com.sirma.itt.javacourse.threads.producerconsumer;

import java.util.Date;

/**
 * Represents a producer.
 * 
 * @author Sinan
 */
public class Producer extends Thread {
	private static final int TIME_TO_WAIT = 700;
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new producer with default time to wait 700ms.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 */
	public Producer(StoreHouse storeHouse) {
		this(storeHouse, TIME_TO_WAIT);
	}

	/**
	 * Creates a new producer with given time to wait.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 * @param time
	 *            - time the producer to wait
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
