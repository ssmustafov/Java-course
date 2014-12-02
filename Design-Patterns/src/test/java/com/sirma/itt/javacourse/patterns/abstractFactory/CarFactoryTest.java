package com.sirma.itt.javacourse.patterns.abstractFactory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.CarFactory}.
 * 
 * @author smustafov
 */
public class CarFactoryTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.CarFactory#createEngine()}.
	 */
	@Test
	public void testCreateCarEngine() {
		VehicleFactory factory = new CarFactory();
		Engine e = factory.createEngine();

		assertTrue(e instanceof CarEngine);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.abstractFactory.CarFactory#createTire()}.
	 */
	@Test
	public void testCreateCarTire() {
		VehicleFactory factory = new CarFactory();
		Tire t = factory.createTire();

		assertTrue(t instanceof CarTire);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.abstractFactory.CarFactory#createInstance(VehicleParts)}
	 * .
	 */
	@Test
	public void testCreateCarEngineByReflection() {
		VehicleFactory factory = new CarFactory();
		Engine t = (Engine) factory.createInstance(VehicleParts.Engine);

		assertTrue(t instanceof CarEngine);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.abstractFactory.CarFactory#createInstance(VehicleParts)}
	 * .
	 */
	@Test
	public void testCreateCarTireByReflection() {
		VehicleFactory factory = new CarFactory();
		Tire t = (Tire) factory.createInstance(VehicleParts.Tire);

		assertTrue(t instanceof CarTire);
	}

}
