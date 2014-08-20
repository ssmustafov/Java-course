package com.sirma.itt.javacourse.inputoutput.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Holds methods for transferring bytes through streams from one to another.
 * 
 * @author smustafov
 */
public class TransferObject {

	private InputStream inputStream;
	private OutputStream outputStream;

	/**
	 * Creates a new TransferObject.
	 * 
	 * @param inputStream
	 *            - the input stream
	 * @param outputStream
	 *            - the output stream
	 */
	public TransferObject(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	/**
	 * Transfers bytes from <code>InputStream</code> to <code>OutputStream</code>.
	 * 
	 * @param numberOfBytes
	 *            - how many bytes to be transfered
	 * @param offset
	 *            - the offset of bytes from the start in the stream
	 * @return - number of transfered bytes
	 * @throws IOException
	 *             - if it cannot transfer bytes throws this exception
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		if (numberOfBytes <= 0) {
			throw new IllegalArgumentException(
					"The number of bytes cannot be under or equal to zero");
		}
		if (offset < 0) {
			throw new IllegalArgumentException("The offset cannot be under zero");
		}

		byte[] bytes = new byte[numberOfBytes];
		int transferedBytes = 0;

		try {
			inputStream.skip(offset);
			transferedBytes = inputStream.read(bytes, offset, numberOfBytes - offset);
			outputStream.write(bytes);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}

		return transferedBytes;
	}

}
