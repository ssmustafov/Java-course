package com.sirma.itt.javacourse.regex.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.regex.regex.IbanValidator} class.
 * 
 * @author smustafov
 */
public class IbanValidatorTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * valid Iban.
	 */
	@Test
	public void testReplaceIbanWithValidIban() {
		String iban = "BG80 BNBG 9661 1020 3456 7843";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "**** 7843";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * valid a lot of white space.
	 */
	@Test
	public void testReplaceWithAlotOfWhiteSpace() {
		String iban = "BG       80 BN BG 9661 1020 3456 7843";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "**** 7843";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * valid Iban and unneeded string.
	 */
	@Test
	public void testReplaceIbanWithValidIbanAndString() {
		String iban = "<bankAccounts><iban>BG80 BNBG 9661 1020 3456 7840</iban></bankAccounts>";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "<bankAccounts><iban>**** 7840</iban></bankAccounts>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * invalid Iban and unneeded string.
	 */
	@Test
	public void testReplaceIbanWithInValidIbanAndString() {
		String iban = "<iban>GB35MIBG40253432144670</iban>";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "<iban>GB35MIBG40253432144670</iban>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * invalid iban.
	 */
	@Test
	public void testReplaceIbanWithInvalidIban() {
		String iban = "AL47 2121 1009 0000 0002 3569 8741";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "AL47 2121 1009 0000 0002 3569 8741";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * empty string.
	 */
	@Test
	public void testReplaceIbanWithEmptyString() {
		String iban = "";
		String actual = IbanValidator.replaceIban(iban);
		String expected = "";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReplaceIbanWithNull() {
		IbanValidator.replaceIban(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.IbanValidator#replaceIban(java.lang.String)} with
	 * text.
	 */
	@Test
	public void testReplaceIbanSpecial() {
		String iban = "<bankAccounts><iban>GR16 0110 1050 0000 1054 7023 795</iban>"
				+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>"
				+ "<iban>SA80 8000 0375 6080 1019 0160</iban>"
				+ "<iban>CH51 0868 6001 2565 1500 1</iban>"
				+ "<iban>BG80 BNBG 9661 1020 3456 7840</iban>"
				+ "<iban>IL30 01BG 0300 0009 6339 234</iban>"
				+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>"
				+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>"
				+ "<iban>BG80BNBG9661102034567843</iban></bankAccounts>";

		String actual = IbanValidator.replaceIban(iban);
		String expected = "<bankAccounts><iban>GR16 0110 1050 0000 1054 7023 795</iban>"
				+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>"
				+ "<iban>SA80 8000 0375 6080 1019 0160</iban>"
				+ "<iban>CH51 0868 6001 2565 1500 1</iban>" + "<iban>**** 7840</iban>"
				+ "<iban>IL30 01BG 0300 0009 6339 234</iban>"
				+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>"
				+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>"
				+ "<iban>****7843</iban></bankAccounts>";

		assertEquals(expected, actual);
	}

}
