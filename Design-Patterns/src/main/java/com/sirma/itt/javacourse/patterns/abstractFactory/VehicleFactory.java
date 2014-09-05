package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Abstract factory interface. Defines contract for creating separate parts of a vehicle.
 * 
 * @author smustafov
 */
public interface VehicleFactory {

	/**
	 * Creates and returns new Engine depending on the implementation.
	 * 
	 * @return - new engine
	 */
	Engine createEngine();

	/**
	 * Creates and returns new Tire depending on the implementation.
	 * 
	 * @return - new tire
	 */
	Tire createTire();

	/**
	 * Creates and returns a vehicle part by using reflection.
	 * 
	 * @param part
	 *            - part of the vehicle to be created
	 * @return - new vehicle part
	 */
	Object createInstance(VehicleParts part);

}
