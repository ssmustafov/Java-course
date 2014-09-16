package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Factory method. Creates instances of the bank account proxy.
 * 
 * @author smustafov
 */
public final class BankAccountFactory {

	/**
	 * Protects from instantiation.
	 */
	private BankAccountFactory() {

	}

	/**
	 * Creates and returns new instance of the <code>BankAccountProxy</code>.
	 * 
	 * @return - new instance of bank account
	 */
	public static Account createInstance() {
		return new BankAccountProxy();
	}

}
