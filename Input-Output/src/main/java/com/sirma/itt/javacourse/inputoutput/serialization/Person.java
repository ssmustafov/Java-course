package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.Serializable;

/**
 * Represents a person.
 * 
 * @author smustafov
 */
public class Person implements Serializable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 4454925699489410151L;
	private String name;
	private int age;

	/**
	 * Creates a new person.
	 * 
	 * @param name
	 *            - the name of the person to be set
	 * @param age
	 *            - the age of the person to be set
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method for age.
	 * 
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
