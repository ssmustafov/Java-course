package com.sirma.itt.javacourse.intro.hangman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Reads words from text file for the game. Implements HangmanReader interface. It works with the
 * console.
 * 
 * @author smustafov
 */
public class FileReader implements HangmanReader {

	private final ArrayList<String> wordsCollection;

	/**
	 * Initializes file reader.
	 * 
	 * @param fileName
	 *            file name of words
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	public FileReader(String fileName) throws IOException {
		if (fileName == null) {
			throw new IllegalArgumentException("The file name is null");
		}

		this.wordsCollection = this.readWordsFromFile(fileName);
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
	private ArrayList<String> readWordsFromFile(String fileName) throws IOException {
		ArrayList<String> words = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.length() >= 3) {
					words.add(line.toLowerCase());
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

		return words;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRandomWord() {
		int randomIndex = HangmanReader.RANDOM_GENERATOR.nextInt(this.wordsCollection.size());
		return this.wordsCollection.get(randomIndex);
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
