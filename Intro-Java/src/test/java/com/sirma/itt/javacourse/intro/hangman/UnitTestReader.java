package com.sirma.itt.javacourse.intro.hangman;

/**
 * Works with a word. Created for unit testing purpose only.
 * 
 * @author smustafov
 */
public class UnitTestReader implements HangmanReader {

	private String word;
	private String[] userInput;
	private int userTry;

	/**
	 * Creates new unit test reader.
	 * 
	 * @param word
	 *            the word to guess
	 * @param userInput
	 *            user's input
	 */
	public UnitTestReader(String word, String[] userInput) {
		userTry = -1;
		this.word = word;
		this.userInput = userInput;
	}

	@Override
	public String getRandomWord() {
		return this.word;
	}

	@Override
	public String getUserInput() {
		if (userTry + 1 < userInput.length) {
			userTry++;
		}

		return userInput[userTry];
	}

	@Override
	public void printMessage(String message) {
		ConsoleHandler.printOnConsole(message);
	}

}
