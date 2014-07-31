package com.sirma.itt.javacourse.regex.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.regex.regex.EmailValidator} class.
 * 
 * @author smustafov
 */
public class EmailValidatorTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.EmailValidator#isValidEmail(java.lang.String)}
	 * with series of valid emails containing all sort of valid characters.
	 */
	@Test
	public void testIsValidEmailSeries() {
		String email1 = "test.t-s@sir-ma.com";
		String email2 = "h1ello@sirma999.com";
		String email3 = "test@sirma.com";
		String email4 = "eee@s-sirma.com";
		String email5 = "eee@cc.british.museum";

		boolean actual1 = EmailValidator.isValidEmail(email1);
		boolean actual2 = EmailValidator.isValidEmail(email2);
		boolean actual3 = EmailValidator.isValidEmail(email3);
		boolean actual4 = EmailValidator.isValidEmail(email4);
		boolean actual5 = EmailValidator.isValidEmail(email5);
		boolean expected = true;

		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.EmailValidator#isValidEmail(java.lang.String)}
	 * with string containing whitespaces.
	 */
	@Test
	public void testIsValidEmailWhitespace() {
		String email = " te  st.t-s@si  r-ma.com ";

		boolean actual = EmailValidator.isValidEmail(email);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.EmailValidator#isValidEmail(java.lang.String)}
	 * with empty string.
	 */
	@Test
	public void testIsValidEmailWithEmptyString() {
		String email = "";

		boolean actual = EmailValidator.isValidEmail(email);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.EmailValidator#isValidEmail(java.lang.String)}
	 * with series of invalid emails.
	 */
	@Test
	public void testIsValidEmailSeriesOfInvalidEmails() {
		String email1 = "sinsn^619@mail.com";
		String email2 = "my-email.com";
		String email3 = "69myemail@mail.com";
		String email4 = "#mye$ma^i&l@.com";
		String email5 = "acbdfe";

		boolean actual1 = EmailValidator.isValidEmail(email1);
		boolean actual2 = EmailValidator.isValidEmail(email2);
		boolean actual3 = EmailValidator.isValidEmail(email3);
		boolean actual4 = EmailValidator.isValidEmail(email4);
		boolean actual5 = EmailValidator.isValidEmail(email5);
		boolean expected = false;

		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.regex.regex.EmailValidator#isValidEmail(java.lang.String)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsValidEmailWithNull() {
		String email = null;
		EmailValidator.isValidEmail(email);
	}

}
