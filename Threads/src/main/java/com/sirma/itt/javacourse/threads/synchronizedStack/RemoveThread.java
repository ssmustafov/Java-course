package com.sirma.itt.javacourse.threads.synchronizedStack;

import java.util.Random;

/**
 * Thread for adding items to {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class RemoveThread extends Thread {
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
	public void run() {
		while (true) {
			list.add(random.nextInt());
			try {
				Thread.sleep(random.nextInt(1000));
				System.out.println(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
