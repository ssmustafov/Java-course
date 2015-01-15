package com.sirma.itt.javacourse.threads.synchronizedstack;


/**
 * Thread for removing items from {@code SynchronizedList}.
 * 
 * @author Sinan
 */
public class RemoveThread implements Runnable {

	private SynchronizedStack list;

	/**
	 * Creates a new thread for removing item SynchronizedList.
	 * 
	 * @param list
	 *            - list from which items to be removed
	 */
	public RemoveThread(SynchronizedStack list) {
		this.list = list;
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		list.removeItem();
	}
}
