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
		int thisHumanAge = this.getClass().getAnnotation(HumanComparator.class).age();
		int otherHumanAge = otherObject.getClass().getAnnotation(HumanComparator.class).age();
		return thisHumanAge - otherHumanAge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		int thisHumanAge = this.getClass().getAnnotation(HumanComparator.class).age();
		int otherHumanAge = obj.getClass().getAnnotation(HumanComparator.class).age();
		return thisHumanAge == otherHumanAge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int thisHumanAge = this.getClass().getAnnotation(HumanComparator.class).age();
		return thisHumanAge << 16;
	}

}
