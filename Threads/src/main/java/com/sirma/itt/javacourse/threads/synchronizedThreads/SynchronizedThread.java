package com.sirma.itt.javacourse.threads.synchronizedThreads;

/**
 * @author smustafov
 */
public class SynchronizedThread extends Thread {
	private long start;
	private long end;

	/**
	 * Creates a new SynchronizedThread with given range.
	 * 
	 * @param start
	 *            - starting value of the range
	 * @param end
	 *            - ending value of the range
	 */
	public SynchronizedThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (long i = start; i <= end; i++) {
			synchronized (this) {
				System.out.print(Thread.currentThread().getName());
				System.out.print(" #");
				System.out.println(i);
				try {
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
