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
	 * with number of bytes as zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTransferWithNumberOfBytesZero() {
		byte[] buffer = { 2, 3, 65 };
		ByteArrayInputStream input = new ByteArrayInputStream(buffer);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			transfer.transfer(0, 1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

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
			int actual = transfer.transfer(20, 10);
			int expected = -1;

			assertEquals(expected, actual);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}
	 * with valid normal case.
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

	/**
	 * Tests {@link com.sirma.itt.javacourse.inputoutput.streams.TransferObject#transfer(int, int)}
	 * with offset zero.
	 */
	@Test
	public void testTransferWithOffsetZero() {
		byte[] buffer = { 93, 11, 23, 65, 69, 43, 97, 66, 98, 101, 100, 5, 6, 4, 3, 67, 81, 18, 22,
				39, 100, 65, 55, 99 };
		ByteArrayInputStream input = new ByteArrayInputStream(buffer);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transfer = new TransferObject(input, output);

		try {
			int actual = transfer.transfer(20, 0);
			int expected = 20;

			assertEquals(expected, actual);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
