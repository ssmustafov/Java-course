package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents a security guard in a supermarket.
 * 
 * @author smustafov
 */
public class Guard extends Employee {

	/**
	 * Creates a new security guard.
	 * 
	 * @param name
	 *            - the name of the security guard
	 * @param age
	 *            - the age of the security guard
	 */
	public Guard(String name, int age) {
		super(name, age, Departments.Security);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void work() {
		System.out.println("Secure the market's premisses");
	}

}
