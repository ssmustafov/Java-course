package com.sirma.itt.javacourse.regex.annotations;

/**
 * @author Sinan
 */
public class Human implements Comparable<Human> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Human otherObject) {
		return this.getClass().getAnnotation(HumanAnnotation.class).age()
				- otherObject.getClass().getAnnotation(HumanAnnotation.class).age();
	}

}
