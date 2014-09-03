package com.sirma.itt.javacourse.inputoutput.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Holds methods for reversing given file.
 * 
 * @author smustafov
 */
public class FileReverser {

	private static final String ENCODING = System.getProperty("file.encoding", "UTF-8");
	private StringBuilder buffer;

	/**
	 * Creates a new FileReverser.
	 */
	public FileReverser() {
		buffer = new StringBuilder();
	}

	/**
	 * Writes a given string to given file.
	 * 
	 * @param fileName
	 *            - the full path of the file to be writed
	 * @param str
	 *            - the string to be writed to the file
	 */
	private void writeToTextFile(String fileName, String str) {
		BufferedWriter writer = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			OutputStreamWriter outputStreamReader = new OutputStreamWriter(fileOutputStream,
					ENCODING);
			writer = new BufferedWriter(outputStreamReader);
			writer.write(str);
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	/**
	 * Reverses the content of given text file.
	 * 
	 * @param fileName
	 *            - the full path of the text file to be reversed
	 */
	public void reverseTextFile(String fileName) {
		BufferedReader reader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, ENCODING);
			reader = new BufferedReader(inputStreamReader);

			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}

		buffer.reverse();
		writeToTextFile(fileName, buffer.toString());
	}
}
