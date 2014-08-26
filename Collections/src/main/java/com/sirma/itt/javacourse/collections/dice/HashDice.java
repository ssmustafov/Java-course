package com.sirma.itt.javacourse.collections.dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * @author smustafov
 */
public class HashDice {

	private static final Random RANDOM_GENERATOR = new Random();
	private Map<String, List<Integer>> statistics;
	// private int m;
	private int n;

	/**
	 * Creates a new dice table.
	 * 
	 * @param m
	 *            - the sides of the dice
	 * @param n
	 *            - the times dices thrown
	 */
	public HashDice(int m, int n) {
		statistics = new HashMap<>();
		// this.m = m;
		this.n = n;
	}

	/**
	 * Returns a random number between 1-6 inclusive.
	 * 
	 * @return - the random number
	 */
	private int getRandomNumber() {
		final int start = 1;
		final int end = 6;

		int randomNumber = RANDOM_GENERATOR.nextInt((end - start) + 1) + start;
		return randomNumber;
	}

	/**
	 * Returns a random double dice.
	 * 
	 * @return - the generated random double dice
	 */
	private String getRandomDoubleDice() {
		int randomNumber1 = getRandomNumber();
		int randomNumber2 = getRandomNumber();

		StringBuilder sb = new StringBuilder();
		sb.append(randomNumber1);
		sb.append(",");
		sb.append(randomNumber2);

		return sb.toString();
	}

	/**
	 * Generates the dice combinations and rounds when they are thrown.
	 */
	public void generateStatistics() {
		for (int j = 0; j < n; j++) {
			String dices = getRandomDoubleDice();

			if (statistics.containsKey(dices)) {
				List<Integer> list = statistics.get(dices);
				list.add(j + 1);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(j + 1);
				statistics.put(dices, list);
			}
		}
	}

	/**
	 * Returns the generated statistics.
	 * 
	 * @return - the generated statistics
	 */
	public String getStatistics() {
		StringBuilder result = new StringBuilder();

		for (Entry<String, List<Integer>> entry : statistics.entrySet()) {
			List<Integer> rounds = entry.getValue();

			result.append("{");
			result.append(entry.getKey());
			result.append("}: ");
			result.append(rounds);
			result.append(System.lineSeparator());
		}

		return result.toString();
	}

}
