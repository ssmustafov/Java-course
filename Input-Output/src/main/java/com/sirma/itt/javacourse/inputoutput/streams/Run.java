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
	 * @throws IOException
	 *             - throws
	 */
	public static void main(String[] args) throws IOException {
		String str = "SomeSADDDDDDDDDDDDDDDDADdasdadsasddddddddd55555555555555";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		System.out.println(transfer.transfer(str.length(), 20));
	}

}
