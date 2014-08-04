package com.sirma.itt.javacourse.regex.annotations;

/**
 * @author Sinan
 */
public class Parent implements Comparable<Parent> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Parent o) {
		return this.getClass().getAnnotation(CustomAnnotation.class).id()
				- o.getClass().getAnnotation(CustomAnnotation.class).id();
	}

}
