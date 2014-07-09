package com.sirma.itt.javacourse.intro.hangman;

import java.io.IOException;

public class PlayHangman {

	public static void main(String[] args) throws IOException {
		String[] arr = { "as", "dasd", "gdeg" };
		HangmanReader arrReader = new ArrayReader(arr);

		HangmanReader fileReader = new FileReader("words.txt");
		Hangman game = new Hangman(fileReader);
		game.run();
	}
}
