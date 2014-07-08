package com.sirma.itt.javacourse.intro.hangman;

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
		new Hangman("askihsdfuiudf.txt");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.hangman.Hangman#Hangman(java.lang.String)}.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test
	public void testHangmanWithExistingFile() throws IOException {
		new Hangman("words.txt");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.hangman.Hangman#Hangman(java.lang.String)}.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHangmanWithEmptyFile() throws IOException {
		new Hangman("empty.txt");
	}

}
