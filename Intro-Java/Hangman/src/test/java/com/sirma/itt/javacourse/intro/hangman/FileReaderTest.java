package com.sirma.itt.javacourse.intro.hangman;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader} class.
 * 
 * @author smustafov
 */
public class FileReaderTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader#FileReader(String)} with empty
	 * file.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFileReaderWithEmptyFile() throws IOException {
		new FileReader("empty.txt");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader#FileReader(String)} with empty
	 * string.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = FileNotFoundException.class)
	public void testFileReaderWithEmptyString() throws IOException {
		new FileReader("");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader#FileReader(String)} with not
	 * existing file.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = FileNotFoundException.class)
	public void testFileReaderWithNotExistFile() throws IOException {
		new FileReader("sohfjskhfehbo.txt");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader#FileReader(String)} with
	 * existing file.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test
	public void testFileReaderWithExistingFile() throws IOException {
		new FileReader("wordsBG.txt");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.hangman.FileReader#FileReader(String)} with null.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	@Test(expected = NullPointerException.class)
	public void testFileReaderWithNull() throws IOException {
		new FileReader(null);
	}

}
