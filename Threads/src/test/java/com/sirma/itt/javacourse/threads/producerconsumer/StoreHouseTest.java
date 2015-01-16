package com.sirma.itt.javacourse.threads.producerconsumer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.threads.producerconsumer.StoreHouse} class.
 * 
 * @author Sinan
 */
public class StoreHouseTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.threads.producerconsumer.StoreHouse#StoreHouse(int)}
	 * with negative size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testStoreHouseWithNegativeSize() {
		new StoreHouse(-1);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.threads.producerconsumer.StoreHouse}.
	 */
	@Test
	public void testStoreHouse() {
		StoreHouse storeHouse = new StoreHouse(3);
		storeHouse.put("potato");
		storeHouse.put("tomato");
		storeHouse.put("cheese");

		assertEquals("potato", storeHouse.get());
		assertEquals("tomato", storeHouse.get());
		assertEquals("cheese", storeHouse.get());
		assertEquals(0, storeHouse.getLeftSize());
	}

}
