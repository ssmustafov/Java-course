package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Interface for getting and setting numbers.
 * 
 * @author Sinan
 */
public interface Number {
	/**
	 * Sets a given integer number.
	 * 
	 * @param number
	 *            - an integer number to be set
	 */
	void setNumber(int number);

	/**
	 * Returns an integer number.
	 * 
	 * @return - an integer number
	 */
	int getNumber();
}
