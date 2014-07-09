package com.sirma.itt.javacourse.intro.hangman;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.hangman.WordsRepository} class.
 * 
 * @author smustafov
 */
public class WordsRepositoryTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.WordsRepository#WordsRepository(String)}
	 * with empty string.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWordsRepositoryWithEmptyFile() throws IOException {
		new HangmanOld("empty.txt");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.WordsRepository#WordsRepository(String)}
	 * with not existing file.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = IOException.class)
	public void testWordsRepositoryWithNotExistFile() throws IOException {
		new HangmanOld("sohfjskhfehbo.txt");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.WordsRepository#WordsRepository(String)}
	 * with existing file.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test
	public void testWordsRepositoryWithExistingFile() throws IOException {
		new HangmanOld("words.txt");
	}

}
