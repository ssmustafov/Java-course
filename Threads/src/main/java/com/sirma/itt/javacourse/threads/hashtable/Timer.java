package com.sirma.itt.javacourse.threads.hashtable;

/**
 * Represents a timer.
 * 
 * @author smustafov
 */
public class Timer implements Runnable {
	private boolean isUsed = false;
	private int seconds;

	/**
	 * Creates a new timer with given seconds.
	 * 
	 * @param seconds
	 *            - the time in seconds for timer to count
	 */
	public Timer(int seconds) {
		this.seconds = seconds;
		new Thread(this).start();
	}

	/**
	 * Sets that the key of the timer is used.
	 */
	public synchronized void setUsed() {
		isUsed = true;
	}

	/**
	 * Restarts the thread. (Notifies).
	 */
	public synchronized void restart() {
		notify();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		while (!isUsed) {
			try {
				wait(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (!isUsed) {
				break;
			}
		}

		// TODO: not finished
	}
}
