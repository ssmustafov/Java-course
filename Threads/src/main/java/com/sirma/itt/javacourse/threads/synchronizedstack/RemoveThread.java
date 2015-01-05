package com.sirma.itt.javacourse.threads.synchronizedstack;

import java.util.Random;

/**
 * Thread for adding items to {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class RemoveThread extends Thread {
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
				System.out.println(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
