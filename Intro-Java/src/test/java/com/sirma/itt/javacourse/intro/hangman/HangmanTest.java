package com.sirma.itt.javacourse.intro.hangman;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman}.
 * 
 * @author smustafov
 */
public class HangmanTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman#isWord(java.lang.String)}.
	 */
	@Test
	public void testIsWord() {
		String[] arr = { "jdasdasd" };
		ArrayReader reader = new ArrayReader(arr);

		Hangman hangMan = new Hangman(reader);
		if (!hangMan.isWord(arr[0])) {
			fail("The given string is not a word");
		}
	}

}
