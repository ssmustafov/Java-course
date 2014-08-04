package com.sirma.itt.javacourse.regex.annotations;

/**
 * Represents human. Implements <code>Comparable</code> interface, so the classes who extends this
 * class can be ordered by <code>HumanAnnotation</code>.
 * 
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
