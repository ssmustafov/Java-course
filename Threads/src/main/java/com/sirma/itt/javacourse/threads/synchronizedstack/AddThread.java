package com.sirma.itt.javacourse.threads.synchronizedstack;


/**
 * Thread for adding items to {@code SynchronizedStack}.
 * 
 * @author Sinan
 */
public class AddThread implements Runnable {

	private SynchronizedStack list;
	private Object itemToAdd;

	/**
	 * Creates a new thread for adding items to SynchronizedStack.
	 * 
	 * @param list
	 *            - list in which items will be added
	 * @param itemToAdd
	 *            - the item to be added to the list
	 */
	public AddThread(SynchronizedStack list, Object itemToAdd) {
		this.list = list;
		this.itemToAdd = itemToAdd;
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		list.addItem(itemToAdd);
	}
}
