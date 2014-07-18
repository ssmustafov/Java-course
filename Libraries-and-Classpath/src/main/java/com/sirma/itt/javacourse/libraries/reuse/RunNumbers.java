package com.sirma.itt.javacourse.libraries.reuse;

import com.sirma.itt.javacourse.intro.numbers.CommonDivisor;
import com.sirma.itt.javacourse.intro.numbers.LargeNumbers;

/**
 * Uses the code from Intro-Java project as jar libraries.
 * 
 * @author smustafov
 */
public final class RunNumbers {

	/**
	 * Default constructor.
	 */
	private RunNumbers() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		System.out.println(CommonDivisor.findGreatestCommonDivisor(23, 99));
		System.out.println(CommonDivisor.findLeastCommonMultiple(16, 84));
		System.out.println(LargeNumbers.sumTwoNumbers("23974924729749823", "432988923472492"));
	}

}
