package com.sirma.itt.javacourse.intro.hangman;

/**
 * @author smustafov
 */
public class ArrayReader implements HangmanReader {

	private String[] words;

	/**
	 * Sets words from given array.
	 * 
	 * @param words
	 *            the words to be loaded
	 */
	public ArrayReader(String[] words) {
		if (words.length < 0) {
			throw new IllegalArgumentException("The array's size is under zero");
		}

		this.words = words;
	}

	@Override
	public String getRandomWord() {
		int randomIndex = HangmanReader.RANDOM_GENERATOR.nextInt(this.words.length);
		return this.words[randomIndex];
	}
}
