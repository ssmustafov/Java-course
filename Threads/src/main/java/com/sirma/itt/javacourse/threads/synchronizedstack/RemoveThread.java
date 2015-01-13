package com.sirma.itt.javacourse.threads.synchronizedstack;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Thread for removing items from {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class RemoveThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(RemoveThread.class);
	private static final int MAX_WAIT_TIME = 3000;
	private SynchronizedList list;
	private Random random = new Random();

	/**
	 * Creates a new thread for removing item SynchronizedList.
	 * 
	 * @param list
	 *            - list from which items to be removed
	 */
	public RemoveThread(SynchronizedList list) {
		this.list = list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		while (true) {
			list.add(random.nextInt());
			try {
				wait(random.nextInt(MAX_WAIT_TIME));
				LOGGER.info(list.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
