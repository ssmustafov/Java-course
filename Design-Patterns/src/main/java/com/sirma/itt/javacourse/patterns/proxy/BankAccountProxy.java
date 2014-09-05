package com.sirma.itt.javacourse.patterns.proxy;

import java.math.BigDecimal;

/**
 * Proxy of the <code>BankAccount</code> class. Clients must work with this class.
 * 
 * @author smustafov
 */
public class BankAccountProxy implements Account {

	private static final BigDecimal MIN_AMOUNT = new BigDecimal("10.00");
	private static final BigDecimal MAX_AMOUNT = new BigDecimal("400.00");
	private BankAccount realAccount;

	/**
	 * Checks if the real account is instantiated. If its not then instantiates it.
	 */
	private void checkAccount() {
		if (realAccount == null) {
			realAccount = new BankAccount();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deposit(BigDecimal amount) {
		if (amount.compareTo(MIN_AMOUNT) == -1) {
			throw new IllegalArgumentException("Minimum deposit amount is " + MIN_AMOUNT
					+ ". You have given: " + amount.toString());
		}

		checkAccount();
		realAccount.deposit(amount);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(MIN_AMOUNT) == -1) {
			throw new IllegalArgumentException("Minimum withdraw amount is " + MIN_AMOUNT
					+ ". You have given: " + amount.toString());
		}
		if (amount.compareTo(MAX_AMOUNT) == 1) {
			throw new IllegalArgumentException("Maximum withdraw amount is " + MAX_AMOUNT
					+ ". You have given: " + amount.toString());
		}

		checkAccount();
		realAccount.withdraw(amount);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal currentBalance() {
		checkAccount();
		return realAccount.currentBalance();
	}

}
