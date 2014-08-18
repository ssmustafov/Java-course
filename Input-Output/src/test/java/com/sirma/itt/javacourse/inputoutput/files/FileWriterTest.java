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
 * Tests {@link com.sirma.itt.javacourse.inputoutput.files.FileWriter} class.
 * 
 * @author smustafov
 */
public class FileWriterTest {

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
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.files.FileWriter#write()} with valid input.
	 */
	@Test
	public void testWriteNormalCase() {
		String path = FOLDER + "testWriteNormalCase.txt";
		FileWriter w = new FileWriter(path);
		String str = "this is test" + System.lineSeparator() + ".";
		byte[] data = str.getBytes();
		InputStream input = new ByteArrayInputStream(data);
		w.setStream(input);
		w.write();

		String actual = readContentFromFile(path);
		String expected = "this is test";
		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.files.FileWriter#write()} with empty input.
	 */
	@Test
	public void testWriteEmptyInput() {
		String path = FOLDER + "testWriteEmptyInput.txt";
		FileWriter w = new FileWriter(path);
		String str = "" + System.lineSeparator() + ".";
		byte[] data = str.getBytes();
		InputStream input = new ByteArrayInputStream(data);
		w.setStream(input);
		w.write();

		String actual = readContentFromFile(path);
		String expected = "";
		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.files.FileWriter#write()} with two lines.
	 */
	@Test
	public void testWriteTwoLines() {
		String path = FOLDER + "testWriteTwoLines.txt";
		FileWriter w = new FileWriter(path);
		String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
				+ System.lineSeparator()
				+ "Lorem Ipsum has been the industry's standard dummy text "
				+ System.lineSeparator() + ".";
		byte[] data = str.getBytes();
		InputStream input = new ByteArrayInputStream(data);
		w.setStream(input);
		w.write();

		String actual = readContentFromFile(path);
		String expected = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has been the industry's standard dummy text";
		assertEquals(expected, actual);
	}

}
