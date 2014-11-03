package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Proxy for {@code Integer}.
 * 
 * @author Sinan
 */
public class IntegerProxy implements Number {
	private Integer integer = new Integer();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumber() {
		return integer.getNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNumber(int number) {
		integer.setNumber(number);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String number = "" + integer.getNumber();
		return number;
	}
}
