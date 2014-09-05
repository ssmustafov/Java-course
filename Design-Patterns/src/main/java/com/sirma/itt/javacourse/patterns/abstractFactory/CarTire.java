package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Represents a regular car tire. Implements <code>Tire</code> interface.
 * 
 * @author smustafov
 */
public class CarTire implements Tire {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		System.out.println("Im a Car Tire");
	}

}
