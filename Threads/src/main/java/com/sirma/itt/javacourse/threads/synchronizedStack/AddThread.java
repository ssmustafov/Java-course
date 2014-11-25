package com.sirma.itt.javacourse.threads.synchronizedStack;

import java.util.Random;

/**
 * Thread for adding items to {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class AddThread extends Thread {
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
				System.out.println(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
