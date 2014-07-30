package com.sirma.itt.javacourse.regex.regex;

/**
 * @author smustafov
 */
public class Run {

	public static void main(String[] args) {
		String regEx = "^[a-zA-z][a-zA-Z0-9]";
		String email = "email_619";
		if (email.matches(regEx)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
