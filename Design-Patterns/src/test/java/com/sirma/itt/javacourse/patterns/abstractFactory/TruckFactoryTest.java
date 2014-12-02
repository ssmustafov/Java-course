package com.sirma.itt.javacourse.patterns.abstractFactory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.TruckFactory}.
 * 
 * @author smustafov
 */
public class TruckFactoryTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.TruckFactory#createEngine()}.
	 */
	@Test
	public void testCreateTruckEngine() {
		VehicleFactory factory = new TruckFactory();
		Engine e = factory.createEngine();

		assertTrue(e instanceof TruckEngine);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.TruckFactory#createTire()}.
	 */
	@Test
	public void testCreateTruckTire() {
		VehicleFactory factory = new TruckFactory();
		Tire t = factory.createTire();

		assertTrue(t instanceof TruckTire);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.abstractFactory.TruckFactory#createInstance(VehicleParts)}
	 * .
	 */
	@Test
	public void testCreateCarEngineByReflection() {
		VehicleFactory factory = new TruckFactory();
		Engine t = (Engine) factory.createInstance(VehicleParts.Engine);

		assertTrue(t instanceof TruckEngine);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.abstractFactory.TruckFactory#createInstance(VehicleParts)}
	 * .
	 */
	@Test
	public void testCreateCarTireByReflection() {
		VehicleFactory factory = new TruckFactory();
		Tire t = (Tire) factory.createInstance(VehicleParts.Tire);

		assertTrue(t instanceof TruckTire);
	}

}
