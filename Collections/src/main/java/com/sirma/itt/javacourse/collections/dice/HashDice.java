package com.sirma.itt.javacourse.collections.dice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Holds methods for generating dice combinations. It works with two dices.
 * 
 * @author smustafov
 */
public class HashDice {

	private Map<String, Set<Integer>> statistics;
	private int counter;
	private DiceReader diceReader;

	/**
	 * Creates a new dice table.
	 * 
	 * @param counter
	 *            - the times dices to be thrown
	 * @param diceReader
	 *            - the dice reader that implements <code>DiceReader</code>
	 */
	public HashDice(DiceReader diceReader, int counter) {
		if (counter <= 0) {
			throw new IllegalArgumentException(
					"The parameter 'counter' cannot be equal or under to zero");
		}

		statistics = new LinkedHashMap<>();
		this.diceReader = diceReader;
		this.counter = counter;
	}

	/**
	 * Returns a random double dice.
	 * 
	 * @return - the generated random double dice
	 */
	private String getRandomDoubleDice() {
		String randomNumber1 = diceReader.getDice();
		String randomNumber2 = diceReader.getDice();

		StringBuilder sb = new StringBuilder();
		sb.append(randomNumber1);
		sb.append(",");
		sb.append(randomNumber2);

		return sb.toString();
	}

	/**
	 * Generates the dices combinations and rounds when they are thrown.
	 */
	public void generateStatistics() {
		for (int j = 0; j < counter; j++) {
			String dices = getRandomDoubleDice();

			if (statistics.containsKey(dices)) {
				Set<Integer> set = statistics.get(dices);
				set.add(j);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(j);
				statistics.put(dices, set);
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

		for (Entry<String, Set<Integer>> entry : statistics.entrySet()) {
			Set<Integer> rounds = entry.getValue();

			result.append("{");
			result.append(entry.getKey());
			result.append("}: ");
			result.append(rounds);
			result.append(System.lineSeparator());
		}

		return result.toString();
	}

}
