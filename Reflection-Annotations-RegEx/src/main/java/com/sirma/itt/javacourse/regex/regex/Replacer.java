package com.sirma.itt.javacourse.regex.regex;

/**
 * @author smustafov
 */
public final class Replacer {

	/**
	 * Protects from instantiation.
	 */
	private Replacer() {

	}

	/**
	 * Replaces all tags &lt;x&gt;...&lt;/x&gt; with &lt;x/&gt;.
	 * 
	 * @param str
	 *            - the string to be replaced
	 * @return replaced string
	 */
	public static String replace(String str) {
		if (str == null) {
			throw new IllegalArgumentException("The given string is null");
		}

		// <x>[A-Za-z0-9\\s]*</x> lazy
		final String regEx = "<x>[^<]*[^>]</x>";
		final String replacement = "<x/>";
		String replaced = str.replaceAll(regEx, replacement);

		return replaced;
	}

}
