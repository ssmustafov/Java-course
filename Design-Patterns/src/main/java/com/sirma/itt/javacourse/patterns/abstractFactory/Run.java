package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Shows how the Abstract Factory can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		VehicleFactory carFactory = new CarFactory();
		Engine carEngine = carFactory.createEngine();
		carEngine.display();

		Tire carTire = carFactory.createTire();
		carTire.display();

		VehicleFactory truckFactory = new TruckFactory();
		Engine truckEngine = (Engine) truckFactory.createInstance(VehicleParts.Engine);
		truckEngine.display();
	}

}
