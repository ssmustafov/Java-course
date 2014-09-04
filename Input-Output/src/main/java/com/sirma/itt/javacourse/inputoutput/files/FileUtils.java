package com.sirma.itt.javacourse.inputoutput.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Holds methods for working with input output operations with files.
 * 
 * @author smustafov
 */
public class FileUtils {

	private static final String ENCODING = System.getProperty("file.encoding", "UTF-8");

	/**
	 * Writes a given string to given file.
	 * 
	 * @param fileName
	 *            - the full path of the file to be wrote
	 * @param str
	 *            - the string to be wrote to the file
	 */
	public void writeToTextFile(String fileName, String str) {
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

}
