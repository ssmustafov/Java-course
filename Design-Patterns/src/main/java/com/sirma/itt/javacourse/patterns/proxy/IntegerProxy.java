package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Proxy for {@code Integer}.
 * 
 * @author Sinan
 */
public class IntegerProxy implements Number {
	private Integer integer;

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
		if (number > java.lang.Integer.MAX_VALUE && number < java.lang.Integer.MAX_VALUE) {
			integer.setNumber(number);
		} else {
			throw new IllegalArgumentException(String.format(
					"The given integer cannot fit in this structure. The range is: [%d, %d]",
					java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return java.lang.Integer.toString(getNumber());
	}
}
