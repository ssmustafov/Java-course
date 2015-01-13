package com.sirma.itt.javacourse.threads.synchronizedstack;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Thread for adding items to {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class AddThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(AddThread.class);
	private static final int MAX_WAIT_TIME = 3000;
	private SynchronizedList list;
	private Random random = new Random();

	/**
	 * Creates a new thread for adding items to SynchronizedList.
	 * 
	 * @param list
	 *            - list in which elements will be added
	 */
	public AddThread(SynchronizedList list) {
		this.list = list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		while (true) {
			list.remove();
			try {
				wait(random.nextInt(MAX_WAIT_TIME));
				LOGGER.info(list.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
