package com.sirma.itt.javacourse.patterns.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Holds methods for creating vehicle parts of a Truck. Concrete factory.
 * 
 * @author smustafov
 */
public class TruckFactory implements VehicleFactory {
	private static final Logger LOGGER = LogManager.getLogger(TruckFactory.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Engine createEngine() {
		return new TruckEngine();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tire createTire() {
		return new TruckTire();
	}

	/**
	 * Finds the class name of given part and returns its name.
	 * 
	 * @param part
	 *            - part which class name to be found
	 * @return - part's class name as string
	 */
	private String chooseClassName(VehicleParts part) {
		String className = "";
		switch (part) {
			case Engine:
				className = "com.sirma.itt.javacourse.patterns.abstractFactory.TruckEngine";
				break;

			case Tire:
				className = "com.sirma.itt.javacourse.patterns.abstractFactory.TruckTire";
				break;

			default:
				throw new IllegalArgumentException("It is given a invalid vehicle part: "
						+ part.toString());
		}

		return className;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object createInstance(VehicleParts part) {
		String className = chooseClassName(part);
		Object obj = null;

		try {
			obj = Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return obj;
	}

}
