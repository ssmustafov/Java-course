package com.sirma.itt.javacourse.regex.regex;

/**
 * Holds methods for validating IBAN.
 * 
 * @author smustafov
 */
public final class IbanValidator {

	/**
	 * Protects from instantiation.
	 */
	private IbanValidator() {

	}

	/**
	 * Replaces valid bulgarian IBAN characters with '****'.
	 * 
	 * @param iban
	 *            - the IBAN to be replaced
	 * @return - the IBAN with replaced characters
	 */
	public static String replaceIban(String iban) {
		if (iban == null) {
			throw new IllegalArgumentException("The given string is null");
		}

		final String regEx = "BG[0-9]{2}BNBG[0-9]{4}[0-9]{4}[0-9]{4}";
		final String replecement = "****";
		String removedWhiteSpace = iban.replaceAll("\\s", "");
		String replacedIban = removedWhiteSpace.replaceAll(regEx, replecement);

		return replacedIban;
	}
}