package com.sirma.itt.javacourse.inputoutput.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Holds methods for reversing given file.
 * 
 * @author smustafov
 */
public class FileReverser {

	private StringBuilder buffer;

	/**
	 * Creates a new FileReverser.
	 */
	public FileReverser() {
		buffer = new StringBuilder();
	}

	/**
	 * Reverses the content of given text file and stores it to the same file.
	 * 
	 * @param fileName
	 *            - the full path of the text file to be reversed
	 */
	public void reverseTextFile(String fileName) {
		buffer.setLength(0);
		BufferedReader reader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,
					FileUtils.ENCODING);
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
		FileUtils.writeToTextFile(fileName, buffer.toString());
	}
}
