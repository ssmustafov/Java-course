package com.sirma.itt.javacourse.intro.hangman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Keeps words in repository.
 * 
 * @author smustafov
 */
public class WordsRepository {

	private final Random randomGenerator = new Random();
	private String randomWord;
	private ArrayList<String> wordsCollection;

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
	 * Reads words from file and saves them.
	 * 
	 * @param fileName
	 *            the text file from which to get words
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	public WordsRepository(String fileName) throws IOException {
		if (fileName.isEmpty()) {
			throw new IllegalArgumentException("The given file name is empty");
		}

		this.wordsCollection = readWordsFromFile(fileName);
	}

	/**
	 * Gets random word from the words collection loaded from text file.
	 * 
	 * @return random word
	 */
	public String getRandomWord() {
		int randomIndex = this.randomGenerator.nextInt(this.wordsCollection.size());
		this.randomWord = this.wordsCollection.get(randomIndex);

		return this.randomWord;
	}
}
