package com.sirma.itt.javacourse.inputoutput.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Holds methods for writing to a file from stream resource.
 * 
 * @author smustafov
 */
public class FileWriter {

	private static final char END_READING_SYMBOL = '.';
	private static final String ENCODING = "UTF-8";
	private Scanner scanner;
	private String fileName;
	private StringBuilder input;

	/**
	 * Creates a new file writer with given file name.
	 * 
	 * @param fileName
	 *            - the full path of the file in which will be writing
	 */
	public FileWriter(String fileName) {
		if (!Pattern.matches("[A-Za-z0-9\\\\/]*.txt$", fileName)) {
			throw new IllegalArgumentException("The given string is not a valid text file name");
		}
		if (fileName.isEmpty()) {
			throw new IllegalArgumentException("The given string is empty");
		}

		this.fileName = fileName;
		input = new StringBuilder();
		scanner = new Scanner(System.in);
	}

	/**
	 * Sets the input stream from where the data comes.
	 * 
	 * @param inputStream
	 *            - the input stream
	 */
	public void setStream(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	/**
	 * Writes readed input to the text file given in the constuctor.
	 */
	public void write() {
		while (true) {
			String line = scanner.nextLine();
			line = line.trim();

			if (line.length() == 1 && line.charAt(0) == END_READING_SYMBOL) {
				BufferedWriter writer = null;
				try {
					FileOutputStream fileOutputStream = new FileOutputStream(fileName);
					OutputStreamWriter outputStreamReader = new OutputStreamWriter(
							fileOutputStream, ENCODING);
					writer = new BufferedWriter(outputStreamReader);
					writer.write(input.toString());
				} catch (UnsupportedEncodingException e) {
					System.out.println(e.getMessage());
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} finally {
					if (writer != null) {
						try {
							writer.close();
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					}
				}

				break;
			}

			input.append(line);
			input.append(System.lineSeparator());
		}
	}

}