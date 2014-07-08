package com.sirma.itt.javacourse.intro.hangman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements the word guessing game called Hangman.
 * 
 * @author smustafov
 */
public class Hangman {

	/**
	 * All available words.
	 */
	private String[] words;

	/**
	 * Boolean array for checking which letters are guessed.
	 */
	private Boolean[] isGuessedLetter;

	/**
	 * The word which to be guessed.
	 */
	private String wordToBeGuessed;

	/**
	 * Possible attempts for guessing the word.
	 */
	private int attempts = 5;

	/**
	 * This constructor initializes the game. It loads words from text file and chooses random word
	 * to guess.
	 * 
	 * @param textFile
	 *            the text file containing words to be loaded
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	public Hangman(String textFile) throws IOException {
		words = readWordsFromFile(textFile);
		wordToBeGuessed = getWord();
		isGuessedLetter = new Boolean[wordToBeGuessed.length()];
		setVisibleLetters();
	}

	/**
	 * Called from the constructor when an object is instantiated to visualize one letter from the
	 * word.
	 */
	private void setVisibleLetters() {
		for (int i = 0; i < isGuessedLetter.length; i++) {
			isGuessedLetter[i] = false;
		}
		int randomIndex = getRandomNumber(wordToBeGuessed.length());
		char letter = wordToBeGuessed.charAt(randomIndex);
		checkLetter(letter);
	}

	/**
	 * Reads words with length at least 3 from text file.
	 * 
	 * @param fileName
	 *            the text file from which words to be read
	 * @return array of strings with words read from the file
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	private String[] readWordsFromFile(String fileName) throws IOException {
		ArrayList<String> words = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.length() >= 3) {
					words.add(line);
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		if (words.isEmpty()) {
			throw new IllegalArgumentException("The file " + fileName + " is empty");
		}

		return (String[]) words.toArray(new String[words.size()]);
	}

	/**
	 * Gets random word from the words.
	 * 
	 * @return a random word
	 */
	private String getWord() {
		int index = getRandomNumber(words.length);
		return words[index];
	}

	/**
	 * Reads line from the standart input.
	 * 
	 * @return read line as string
	 */
	private String readLine() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		return line;
	}

	/**
	 * Checks if the given parameter is the word to be guessed. If its not decreases the attempts of
	 * possible guesses.
	 * 
	 * @param line
	 *            the word to check
	 */
	private void checkWord(String line) {
		if (line.toLowerCase().equals(wordToBeGuessed.toLowerCase())) {
			for (int i = 0; i < isGuessedLetter.length; i++) {
				isGuessedLetter[i] = true;
			}
		} else {
			this.attempts--;
		}
	}

	/**
	 * Checks how many times the given letter contains in the word which is trying to guess.
	 * 
	 * @param letter
	 *            the letter to check
	 */
	private void checkLetter(char letter) {
		int index = wordToBeGuessed.toLowerCase().indexOf(letter);
		if (index == -1) {
			this.attempts--;
		}

		while (index != -1) {
			if (isGuessedLetter.length > index) {
				isGuessedLetter[index] = true;
				index = wordToBeGuessed.toLowerCase().indexOf(letter, index + 1);
			} else {
				break;
			}
		}
	}

	/**
	 * Checks if there are no more attempts left.
	 * 
	 * @return true if no more attempts left, false if there are still attempts available
	 */
	private Boolean isAttemptsOver() {
		if (this.attempts == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if all letters in the word is guessed.
	 * 
	 * @return true if all letters in the word is guessed, false if not all letters are guessed
	 */
	private Boolean isWordGuessed() {
		for (int i = 0; i < isGuessedLetter.length; i++) {
			if (!isGuessedLetter[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets random number from zero to given length.
	 * 
	 * @param length
	 *            the end range of the random number
	 * @return random number
	 */
	private int getRandomNumber(int length) {
		return (int) Math.floor(Math.random() * length);
	}

	/**
	 * This method contains all the logic for the game. It prints on the standart output and reads
	 * from the standart input.
	 */
	public void playGame() {
		while (true) {
			if (isAttemptsOver()) {
				System.out.println();
				System.out.println("YOU HAVE BEEN HANGED!");
				System.out.printf("The word was: %s\n", this.wordToBeGuessed);
				break;
			}

			if (isWordGuessed()) {
				System.out.println();
				System.out.println("YOU WIN!");
				break;
			}

			for (int i = 0; i < wordToBeGuessed.length(); i++) {
				if (isGuessedLetter[i]) {
					System.out.printf("%s ", wordToBeGuessed.charAt(i));
				} else if (wordToBeGuessed.charAt(i) == ' ') {
					System.out.printf(" ");
				} else {
					System.out.printf("_ ");
				}
			}
			System.out.println();
			System.out.printf("Remaining attempts: %d\n", this.attempts);

			String line = readLine();
			if (line.length() >= 2) {
				checkWord(line);
			} else {
				checkLetter(line.charAt(0));
			}
		}
	}

}
