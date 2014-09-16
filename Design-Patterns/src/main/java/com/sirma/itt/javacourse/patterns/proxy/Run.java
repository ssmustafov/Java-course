package com.sirma.itt.javacourse.patterns.proxy;

import java.math.BigDecimal;

/**
 * Shows how to use the Proxy pattern.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		Account account = BankAccountFactory.createInstance();
		System.out.println(account.getCurrentBalance());
		account.deposit(new BigDecimal("200.70"));
		System.out.println(account.getCurrentBalance());
		account.withdraw(new BigDecimal("350.00"));
		System.out.println(account.getCurrentBalance());
	}
}
