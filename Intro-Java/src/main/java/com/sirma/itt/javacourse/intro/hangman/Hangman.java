package com.sirma.itt.javacourse.intro.hangman;

import java.util.Arrays;

/**
 * Implements the word guessing game called Hangman.
 * 
 * @author smustafov
 */
public class Hangman {

	private static final String HANGED_MESSAGE = "YOU HAVE BEEN HANGED!!!";
	private static final String WON_MESSAGE = "YOU WON!!!";
	private static final String REMAINING_ATTEMPTS_MESSAGE = "Remaining attempts: ";
	private static final String WORD_MESSAGE = "The word was: ";
	private static final String HIDDEN_LETTER_SYMBOL = "_ ";

	private HangmanReader hangmanReader;
	private String wordToGuess;
	private Boolean[] isLettersGuessed;
	private int attemptsToGuess = 5;

	/**
	 * Initializes the game.
	 * 
	 * @param reader
	 *            the interface containing the words
	 */
	public Hangman(HangmanReader reader) {
		this.hangmanReader = reader;
		this.wordToGuess = this.hangmanReader.getRandomWord();
		this.isLettersGuessed = new Boolean[this.wordToGuess.length()];

		for (int i = 0; i < isLettersGuessed.length; i++) {
			this.isLettersGuessed[i] = false;
		}
		int randomIndex = (int) Math.floor(Math.random() * this.wordToGuess.length());
		this.setVisibleLetter(this.wordToGuess.charAt(randomIndex));
	}

	/**
	 * Visualizes one letter from the word if it exists. Uses string.
	 * 
	 * @param letter
	 *            the letter to visualize
	 */
	private void setVisibleLetter(String letter) {
		int index = this.wordToGuess.indexOf(letter);
		if (index == -1) {
			this.attemptsToGuess--;
		}

		while (index != -1) {
			if (this.isLettersGuessed.length > index) {
				this.isLettersGuessed[index] = true;
				index = this.wordToGuess.indexOf(letter, index + 1);
			} else {
				break;
			}
		}
	}

	/**
	 * Visualizes one letter from the word if it exists. Uses char.
	 * 
	 * @param letter
	 *            the letter to visualize
	 */
	private void setVisibleLetter(char letter) {
		int index = this.wordToGuess.indexOf(letter);
		if (index == -1) {
			this.attemptsToGuess--;
		}

		while (index != -1) {
			if (this.isLettersGuessed.length > index) {
				this.isLettersGuessed[index] = true;
				index = this.wordToGuess.indexOf(letter, index + 1);
			} else {
				break;
			}
		}
	}

	/**
	 * Checks if the current word is guessed.
	 * 
	 * @return true if the word is guessed or false if the word is not guessed
	 */
	private Boolean isWordGuessed() {
		for (int i = 0; i < isLettersGuessed.length; i++) {
			if (!this.isLettersGuessed[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if any attempts to guess left.
	 * 
	 * @return true if attempts left or false if no more attempts
	 */
	private Boolean areAttemptsToGuessOver() {
		if (this.attemptsToGuess == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the given string is the word to guess. If the given string is empty it does
	 * nothing.
	 * 
	 * @param str
	 *            the word to check if it is the current word to guess
	 */
	private void checkWord(String str) {
		if (str.isEmpty()) {
			return;
		}

		String word = str.toLowerCase();
		if (this.wordToGuess.equals(word)) {
			Arrays.fill(this.isLettersGuessed, true);
		} else {
			this.attemptsToGuess--;
		}
	}

	/**
	 * Checks the given string if it contains in the current word to guess. If the given string is
	 * empty it does nothing.
	 * 
	 * @param str
	 *            a letter to check if it contains in the current word to guess
	 */
	private void checkLetter(String str) {
		if (str.isEmpty()) {
			return;
		}

		String letter = str.toLowerCase();
		if (this.wordToGuess.contains(letter)) {
			this.setVisibleLetter(letter);
		} else {
			this.attemptsToGuess--;
		}
	}

	/**
	 * Checks if given string is word.
	 * 
	 * @param str
	 *            the string to be checked
	 * @return true if the parameter is word or false if the parameter is letter
	 */
	public Boolean isWord(String str) {
		if (str.length() >= 2) {
			return true;
		}
		return false;
	}

	/**
	 * Contains all the logic for the game.
	 */
	public void run() {
		while (true) {
			if (this.isWordGuessed()) {
				this.hangmanReader.printMessage(System.lineSeparator() + this.wordToGuess);
				this.hangmanReader.printMessage(System.lineSeparator() + WON_MESSAGE);
				break;
			}

			if (this.areAttemptsToGuessOver()) {
				this.hangmanReader.printMessage(System.lineSeparator() + HANGED_MESSAGE);
				this.hangmanReader.printMessage(System.lineSeparator() + WORD_MESSAGE
						+ this.wordToGuess);
				break;
			}

			for (int i = 0; i < this.wordToGuess.length(); i++) {
				if (this.isLettersGuessed[i]) {
					String letter = Character.toString(this.wordToGuess.charAt(i));
					this.hangmanReader.printMessage(letter);
				} else {
					this.hangmanReader.printMessage(HIDDEN_LETTER_SYMBOL);
				}
			}
			this.hangmanReader.printMessage(System.lineSeparator() + REMAINING_ATTEMPTS_MESSAGE
					+ this.attemptsToGuess);
			this.hangmanReader.printMessage(System.lineSeparator());

			String line = this.hangmanReader.readMessage();
			line = line.trim();
			if (this.isWord(line)) {
				this.checkWord(line);
			} else {
				this.checkLetter(line);
			}
		}
	}
}
