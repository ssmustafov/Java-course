package com.sirma.itt.javacourse.inputoutput.files;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.inputoutput.files.FileReverser} class.
 * 
 * @author smustafov
 */
public class FileReverseTest {

	private static final String FOLDER = "src\\test\\resources\\";

	/**
	 * Reads content from given text file.
	 * 
	 * @param fileName
	 *            - the tex file from to be readed
	 * @return - the readed content as string
	 */
	private String readContentFromFile(String fileName) {
		StringBuilder sb = new StringBuilder();

		BufferedReader reader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return sb.toString();
	}

	/**
	 * Writes given string to given file.
	 * 
	 * @param fileName
	 *            - the full path of the file
	 * @param content
	 *            - the content to be saved to the file
	 */
	private void writeToFile(String fileName, String content) {
		FileWriter w = new FileWriter(fileName);

		String str = content + System.lineSeparator() + ".";
		byte[] data = str.getBytes();
		InputStream input = new ByteArrayInputStream(data);
		w.setStream(input);
		w.write();
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.inputoutput.files.FileReverser#reverseTextFile(java.lang.String)}
	 * with normal case.
	 */
	@Test
	public void testReverseTextFileNormalCase() {
		FileReverser fileReverser = new FileReverser();
		String fileName = FOLDER + "testReverseTextFileNormalCase.txt";
		writeToFile(fileName, "This is testing for java");
		fileReverser.reverseTextFile(fileName);

		String actual = readContentFromFile(fileName);
		String expected = "avaj rof gnitset si sihT";
		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.inputoutput.files.FileReverser#reverseTextFile(java.lang.String)}
	 * with empty file.
	 */
	@Test
	public void testReverseTextFileEmpty() {
		FileReverser fileReverser = new FileReverser();
		String fileName = FOLDER + "testReverseTextFileEmpty.txt";
		writeToFile(fileName, "");
		fileReverser.reverseTextFile(fileName);

		String actual = readContentFromFile(fileName);
		String expected = "";
		assertEquals(expected, actual);
	}

}
