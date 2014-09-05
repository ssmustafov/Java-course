package com.sirma.itt.javacourse.patterns.abstractFactory;

/**
 * Represents a regular car engine. Implements <code>Engine</code> interface.
 * 
 * @author smustafov
 */
public class CarEngine implements Engine {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void display() {
		System.out.println("Im a Car Engine");
	}

}
