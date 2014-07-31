package com.sirma.itt.javacourse.regex.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer} class.
 * 
 * @author smustafov
 */
public class ReplacerTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * empty string.
	 */
	@Test
	public void testReplaceWithEmptyString() {
		String str = "";
		String actual = Replacer.replace(str);
		String expected = "";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * empty tag.
	 */
	@Test
	public void testReplaceWithEmptyTag() {
		String str = "<x></x>";
		String actual = Replacer.replace(str);
		String expected = "<x/>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * valid nested tags.
	 */
	@Test
	public void testReplaceWithValidNestedTags() {
		String str = "<x><b></b><x>Hello world</x><b>sdfsdf</b><x>Goodmorning</x><x>69</x><x>sdfsdfsdf</x></x>";
		String actual = Replacer.replace(str);
		String expected = "<x><b></b><x/><b>sdfsdf</b><x/><x/><x/></x>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * valid tag.
	 */
	@Test
	public void testReplaceWithValidTag() {
		String str = "<x>Hello world</x>";
		String actual = Replacer.replace(str);
		String expected = "<x/>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * unclosed tag.
	 */
	@Test
	public void testReplaceWithUnclosedTag() {
		String str = "<x>Hello world";
		String actual = Replacer.replace(str);
		String expected = "<x>Hello world";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * unopened tag.
	 */
	@Test
	public void testReplaceWithUnopenedTag() {
		String str = "Hello world</x>";
		String actual = Replacer.replace(str);
		String expected = "Hello world</x>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} without
	 * tag x.
	 */
	@Test
	public void testReplaceWithoutTagX() {
		String str = "<xs><strong><u>Underline</u></strong></xs>";
		String actual = Replacer.replace(str);
		String expected = "<xs><strong><u>Underline</u></strong></xs>";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} without
	 * any tags.
	 */
	@Test
	public void testReplaceWithoutAnyTags() {
		String str = "Hello x world < than zero and > than million";
		String actual = Replacer.replace(str);
		String expected = "Hello x world < than zero and > than million";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.regex.Replacer#replace(java.lang.String)} with
	 * null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReplaceWithNull() {
		Replacer.replace(null);
	}

}
