package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents a cleaner in a supermarket.
 * 
 * @author smustafov
 */
public class Cleaner extends Employee {

	/**
	 * Creates a new cleaner.
	 * 
	 * @param name
	 *            - the name of the cleaner
	 * @param age
	 *            - the age of the cleaner
	 */
	public Cleaner(String name, int age) {
		super(name, age, Departments.Laborer);
	}

	@Override
	public void work() {
		System.out.println("Cleaning the market");
	}

}
