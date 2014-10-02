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
		RandomDiceReader r = new RandomDiceReader();
		HashDice a = new HashDice(20, 6, r);
		a.generate();
		System.out.println(a.toString());
	}
}
