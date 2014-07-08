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

	private String[] words;
	private Boolean[] isGuessedLetter;
	private String wordToBeGuessed;
	private int attempts = 5;

	// private int score;

	public Hangman() throws IOException {
		words = readWordsFromFile("words.txt");
		// score = 0;
		wordToBeGuessed = getWord();
		isGuessedLetter = new Boolean[wordToBeGuessed.length()];
		setVisibleLetters();
	}

	private void setVisibleLetters() {
		for (int i = 0; i < isGuessedLetter.length; i++) {
			isGuessedLetter[i] = false;
		}
		int randomIndex = getRandomNumber(wordToBeGuessed.length());
		char letter = wordToBeGuessed.charAt(randomIndex);
		checkLetter(letter);
	}

	private String[] readWordsFromFile(String fileName) throws IOException {
		ArrayList<String> words = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
				fileName), "UTF-8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			reader.close();
		}

		return (String[]) words.toArray(new String[words.size()]);
	}

	private String getWord() {
		int index = getRandomNumber(words.length);
		return words[index];
	}

	private String readLine() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		return line;
	}

	private void checkWord(String line) {
		if (line.toLowerCase().equals(wordToBeGuessed.toLowerCase())) {
			for (int i = 0; i < isGuessedLetter.length; i++) {
				isGuessedLetter[i] = true;
			}
		} else {
			this.attempts--;
		}
	}

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

	private Boolean isAttemptsOver() {
		if (this.attempts == 0) {
			return true;
		}
		return false;
	}

	private Boolean isWordGuessed() {
		for (int i = 0; i < isGuessedLetter.length; i++) {
			if (!isGuessedLetter[i]) {
				return false;
			}
		}
		return true;
	}

	private int getRandomNumber(int length) {
		return (int) Math.floor(Math.random() * length);
	}

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
