package com.sirma.itt.javacourse.intro.hangman;

import java.util.Random;

/**
 * Interface for reading words.
 * 
 * @author smustafov
 */
public interface HangmanReader {

	Random RANDOM_GENERATOR = new Random();

	/**
	 * Gets random word.
	 * 
	 * @return random word
	 */
	String getRandomWord();

}
