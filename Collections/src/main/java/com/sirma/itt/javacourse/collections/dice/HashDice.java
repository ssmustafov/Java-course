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

	private Map<String, Set<Integer>> statistics = new LinkedHashMap<>();
	private DiceReader reader;
	private int numberOfThrows;
	private int sides;

	/**
	 * Creates a new hash dice.
	 * 
	 * @param numberOfThrows
	 *            - times the dices to be thrown
	 * @param sides
	 *            - number of sides of the dices
	 * @param reader
	 *            - the dice reader that implements <code>DiceReader</code>
	 */
	public HashDice(int numberOfThrows, int sides, DiceReader reader) {
		if (numberOfThrows <= 0) {
			throw new IllegalArgumentException(
					"The parameter 'numberOfThrows' cannot be equal or under to zero");
		}
		if (sides <= 0) {
			throw new IllegalArgumentException(
					"The parameter 'sides' cannot be equal or under to zero");
		}

		this.numberOfThrows = numberOfThrows;
		this.sides = sides;
		this.reader = reader;
	}

	/**
	 * Throws two dices.
	 * 
	 * @return the thrown dices as string
	 */
	public String throwDices() {
		String num1 = reader.throwDice(sides);
		String num2 = reader.throwDice(sides);
		StringBuilder result = new StringBuilder();
		result.append(num1);
		result.append(",");
		result.append(num2);

		return result.toString();
	}

	/**
	 * Generates the dices combinations and rounds when they are thrown.
	 */
	public void generate() {
		for (int i = 0; i < numberOfThrows; i++) {
			String dices = throwDices();

			if (statistics.containsKey(dices)) {
				Set<Integer> set = statistics.get(dices);
				set.add(i);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(i);
				statistics.put(dices, set);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
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
