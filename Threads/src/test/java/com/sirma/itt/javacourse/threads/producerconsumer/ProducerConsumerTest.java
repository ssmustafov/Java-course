package com.sirma.itt.javacourse.threads.producerconsumer;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests Producer-Consumer task.
 * 
 * @author Sinan
 */
public class ProducerConsumerTest {

	private static final Logger LOGGER = LogManager.getLogger(ProducerConsumerTest.class);

	/**
	 * Sleeps for time.
	 * 
	 * @param sleepTime
	 *            - time to sleep
	 */
	private void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Tests by producer adding 3 stocks and consumer gets all 3 stocks.
	 */
	@Test
	public void testProducerConsumer() {
		StoreHouse storeHouse = new StoreHouse(5);
		Producer producer = new Producer(storeHouse, 1000);
		producer.start();

		sleep(3000);
		producer.interrupt();

		Consumer consumer = new Consumer(storeHouse, 1000);
		consumer.start();

		sleep(3045);
		consumer.interrupt();

		assertEquals(0, storeHouse.getLeftSize());
	}

}
