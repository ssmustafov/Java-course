package com.sirma.itt.javacourse.intro.hangman;

import java.util.Arrays;

/**
 * Implements the word guessing game called Hangman.
 * 
 * @author smustafov
 */
public class Hangman {

	private HangmanReader wordsRepository;
	private String wordToGuess;
	private Boolean[] isLettersGuessed;
	private int attemptsToGuess = 5;

	/**
	 * Initializes the game.
	 * 
	 * @param wordsRepository
	 *            the interface containing the words
	 */
	public Hangman(HangmanReader wordsRepository) {
		this.wordsRepository = wordsRepository;
		this.wordToGuess = this.wordsRepository.getRandomWord();
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
	 * Contains all the logic for the game. It works with the console.
	 */
	public void run() {
		while (true) {
			if (this.isWordGuessed()) {
				ConsoleRender.printOnConsole("\n" + this.wordToGuess);
				ConsoleRender.printOnConsole("\nYOU WON!\n");
				break;
			}

			if (this.areAttemptsToGuessOver()) {
				ConsoleRender.printOnConsole("\nYOU HAVE BEEN HANGED\n");
				ConsoleRender.printOnConsole("The word was: " + this.wordToGuess);
				ConsoleRender.printOnConsole("\n");
				break;
			}

			for (int i = 0; i < this.wordToGuess.length(); i++) {
				if (this.isLettersGuessed[i]) {
					ConsoleRender.printOnConsole(this.wordToGuess.charAt(i));
				} else {
					ConsoleRender.printOnConsole("_ ");
				}
			}
			ConsoleRender.printOnConsole("\nRemaining attempts to guess: " + this.attemptsToGuess);
			ConsoleRender.printOnConsole("\n");

			String line = ConsoleRender.readLineFromConsole();
			line = line.trim();
			if (this.isWord(line)) {
				this.checkWord(line);
			} else {
				this.checkLetter(line);
			}
		}
	}
}
