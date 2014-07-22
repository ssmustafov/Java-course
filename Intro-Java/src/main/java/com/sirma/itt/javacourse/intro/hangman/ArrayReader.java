package com.sirma.itt.javacourse.intro.hangman;

/**
 * Reads words from array of strings for the game. Implements HangmanReader interface. It works with
 * the console.
 * 
 * @author smustafov
 */
public class ArrayReader implements HangmanReader {

	private final String[] words;

	/**
	 * Sets words from given array.
	 * 
	 * @param words
	 *            the words to be loaded
	 */
	public ArrayReader(String[] words) {
		if (words.length <= 0) {
			throw new IllegalArgumentException("The array's size is under zero");
		}

		this.words = words;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRandomWord() {
		int randomIndex = HangmanReader.RANDOM_GENERATOR.nextInt(this.words.length);
		return this.words[randomIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUserInput() {
		return ConsoleHandler.readLineFromConsole();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printMessage(String message) {
		ConsoleHandler.printOnConsole(message);
	}

}
