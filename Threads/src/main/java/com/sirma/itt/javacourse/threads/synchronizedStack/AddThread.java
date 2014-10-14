package com.sirma.itt.javacourse.threads.synchronizedStack;

/**
 * Thread for adding items to {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class AddThread extends Thread {
	private SynchronizedList list;

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
	public void run() {
		while (true) {
			list.remove();
			try {
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
