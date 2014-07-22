package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents a cashier in a supermarket.
 * 
 * @author smustafov
 */
public class Cashier extends Employee {

	/**
	 * Creates a new cashier.
	 * 
	 * @param name
	 *            - the name of the cashier
	 * @param age
	 *            - the age of the cashier
	 */
	public Cashier(String name, int age) {
		super(name, age, Departments.Cashier);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void work() {
		System.out.println("Paymaster");
	}

}
