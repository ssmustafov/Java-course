package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Represents a consumer.
 * 
 * @author Sinan
 */
public class Consumer extends Thread {
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
	public void run() {
		try {
			while (true) {
				String message = (String) storeHouse.get();
				System.out.println(getName() + " : get -> " + message);
				sleep(time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
