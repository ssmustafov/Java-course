package com.sirma.itt.javacourse.intro.hangman;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link com.sirma.itt.javacourse.intro.hangman.Hangman}.
 * 
 * @author smustafov
 */
public class HangmanTest {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.hangman.Hangman#Hangman(java.lang.String)}.
	 * 
	 * @throws IOException
	 *             expected exception
	 */
	@Test(expected = IOException.class)
	public void testHangmanWithNotExistingFile() throws IOException {
		Hangman game = new Hangman("asdf.txt");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.hangman.Hangman#Hangman(java.lang.String)}.
	 */
	@Test
	public void testHangmanWithExistingFile() throws IOException {
		Hangman game = new Hangman("words.txt");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.hangman.Hangman#Hangman(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHangmanWithEmptyFile() throws IOException {
		Hangman game = new Hangman("empty.txt");
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.hangman.Hangman#playGame()}.
	 */
	@Test
	public void testPlayGame() {
		fail("Not yet implemented");
	}

}
