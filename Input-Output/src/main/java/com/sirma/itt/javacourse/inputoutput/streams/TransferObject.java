package com.sirma.itt.javacourse.inputoutput.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
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
	 *             - exception
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		if (numberOfBytes <= 0) {
			throw new IllegalArgumentException(
					"The number of bytes cannot be under or equal to zero");
		}
		if (offset < 0) {
			throw new IllegalArgumentException("The offset cannot be under zero");
		}

		byte[] buffer = new byte[numberOfBytes];
		int transferedBytes = 0;
		transferedBytes = inputStream.read(buffer, offset, numberOfBytes);
		outputStream.write(buffer);

		inputStream.skip(offset);
		return transferedBytes;
	}

}
