package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Represents a regular truck engine. Implements <code>Engine</code> interface.
 * 
 * @author smustafov
 */
public class TruckEngine implements Engine {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		System.out.println("Im a Truck Engine");
	}

}
