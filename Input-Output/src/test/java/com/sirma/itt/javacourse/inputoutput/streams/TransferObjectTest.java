package com.sirma.itt.javacourse.inputoutput.streams;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject} class.
 * 
 * @author smustafov
 */
public class TransferObjectTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}
	 * with negative number of bytes.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTransferWithNegativeNumberOfBytes() {
		byte[] buffer = { 2, 3, 65 };
		ByteArrayInputStream input = new ByteArrayInputStream(buffer);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			transfer.transfer(-1, 1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}
	 * with negative offset.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTransferWithNegativeOffset() {
		byte[] buffer = { 0, 0, 0, 5, 65, 93, 98 };
		ByteArrayInputStream input = new ByteArrayInputStream(buffer);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			transfer.transfer(2, -5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}
	 * with empty buffer.
	 */
	@Test
	public void testTransferEmptyBuffer() {
		byte[] buffer = {};
		ByteArrayInputStream input = new ByteArrayInputStream(buffer);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			int actual = transfer.transfer(20, 20);
			int expected = -1;

			assertEquals(expected, actual);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}.
	 */
	@Test
	public void testTransfer() {
		String str = "Lorem ipsum dolor sit amet, ei alii iuvaret sea, cum quot iriure torquatos in, ex oratio signiferumque vel.";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			int actual = transfer.transfer(100, 10);
			int expected = 90;

			assertEquals(expected, actual);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
