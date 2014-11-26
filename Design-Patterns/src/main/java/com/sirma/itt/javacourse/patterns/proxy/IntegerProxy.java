package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Proxy for {@code Integer}.
 * 
 * @author Sinan
 */
public class IntegerProxy implements Number {
	public static final int MAX_VALUE = 2147483647;
	public static final int MIN_VALUE = -2147483648;
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
		if (number > MIN_VALUE && number < MAX_VALUE) {
			integer.setNumber(number);
		} else {
			throw new IllegalArgumentException(String.format(
					"The given integer cannot fit in this structure. The range is: [%d, %d]",
					MIN_VALUE, MAX_VALUE));
		}
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
