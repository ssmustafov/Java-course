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
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman#isWord(java.lang.String)} with
	 * null.
	 */
	@Test(expected = NullPointerException.class)
	public void testHangmanWithNull() {
		new Hangman(null);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman} with hanged user input.
	 */
	@Test
	public void testHangmanHang() {
		String[] userInput = { "a", "f", "e", "dad", "gds", "q" };
		UnitTestReader reader = new UnitTestReader("soldier", userInput);
		Hangman game = new Hangman(reader);
		game.run();
		if (game.isWon()) {
			fail("The user must be hanged");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman} with wining user input.
	 */
	@Test
	public void testHangmanWin() {
		String[] userInput = { "d", "f", "a", "developer" };
		UnitTestReader reader = new UnitTestReader("developer", userInput);
		Hangman game = new Hangman(reader);
		game.run();
		if (!game.isWon()) {
			fail("The user must win");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman} with no wrong guess.
	 */
	@Test
	public void testHangmanNoWrongGuess() {
		String[] userInput = { "E", "s", "L", "d" };
		UnitTestReader reader = new UnitTestReader("leeds", userInput);
		Hangman game = new Hangman(reader);
		game.run();
		if (game.getAttemptsToGuess() != 5) {
			fail("Attempts left to guest must be 5 but it is: " + game.getAttemptsToGuess());
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.Hangman} for left attempts to guess.
	 */
	@Test
	public void testHangmanLeftAttemptsOne() {
		String[] userInput = { "a", "c", "f", "L", "w", "computer" };
		UnitTestReader reader = new UnitTestReader("computer", userInput);
		Hangman game = new Hangman(reader);
		game.run();
		if (game.getAttemptsToGuess() != 1) {
			fail("Attempts left to guest must be 1 but it is: " + game.getAttemptsToGuess());
		}
	}
}
