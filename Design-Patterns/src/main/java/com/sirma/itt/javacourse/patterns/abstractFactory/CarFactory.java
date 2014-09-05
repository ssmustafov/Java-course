package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Holds methods for creating vehicle parts of a Car. Concrete factory.
 * 
 * @author smustafov
 */
public class CarFactory implements VehicleFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Engine createEngine() {
		return new CarEngine();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tire createTire() {
		return new CarTire();
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
				className = "com.sirma.itt.javacourse.patterns.abstractFactory.CarEngine";
				break;

			case Tire:
				className = "com.sirma.itt.javacourse.patterns.abstractFactory.CarTire";
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
		} catch (InstantiationException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}

		return obj;
	}

}
