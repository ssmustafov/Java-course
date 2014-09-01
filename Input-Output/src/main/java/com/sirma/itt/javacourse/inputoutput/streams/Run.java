package com.sirma.itt.javacourse.inputoutput.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Shows how the stream classes can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		String str = "SomeSADDDDDDDDDDDDDDDDADdasdadsasddddddddd55555555555555";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			System.out.println(transfer.transfer(str.length(), 20));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
