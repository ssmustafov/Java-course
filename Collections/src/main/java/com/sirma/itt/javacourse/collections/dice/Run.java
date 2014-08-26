package com.sirma.itt.javacourse.collections.dice;

/**
 * Shows how the HashDice class can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		HashDice h = new HashDice(4, 20);
		h.generateStatistics();
		System.out.println(h.getStatistics());
	}

}
