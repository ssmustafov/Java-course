package com.sirma.itt.javacourse.intro.hangman;

import java.io.IOException;

public class PlayHangman {

	public static void main(String[] args) throws IOException {
		Hangman s = new Hangman("words.txt");
		s.run();
	}
}
