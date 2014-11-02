package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Represents an integer number.
 * 
 * @author Sinan
 */
public class Integer implements Number {
	private int number = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNumber(int number) {
		this.number = number;
	}
}
