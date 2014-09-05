package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Represents a regular truck tire. Implements <code>Tire</code> interface.
 * 
 * @author smustafov
 */
public class TruckTire implements Tire {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		System.out.println("Im a Truck Tire");
	}

}
