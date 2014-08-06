package com.sirma.itt.javacourse.exceptions.sumator;

/**
 * Handles exceptions.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Default constructor.
	 */
	private Run() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		try {
			Sumator sumator = new Sumator();
			// System.out.println(sumator.sum("", ""));
			System.out.println(sumator.sum("321^", "123"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
