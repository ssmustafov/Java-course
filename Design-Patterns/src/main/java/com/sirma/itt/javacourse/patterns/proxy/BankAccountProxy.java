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
	private static final BigDecimal INITIAL_AMOUNT = new BigDecimal("1000.00");
	private BankAccount realAccount;

	/**
	 * Checks if the real account is instantiated. If its not then instantiates it.
	 */
	private void checkAccount() {
		if (realAccount == null) {
			realAccount = new BankAccount(INITIAL_AMOUNT);
		}
	}

	/**
	 * Returns the minimal amount that can be used in a bank account.
	 * 
	 * @return - minimal amount that can be used in a bank account
	 */
	public BigDecimal getMinAmount() {
		return MIN_AMOUNT;
	}

	/**
	 * Returns the maximal amount that can be used in a bank account.
	 * 
	 * @return - maximal amount that can be used in a bank account
	 */
	public BigDecimal getMaxAmount() {
		return MAX_AMOUNT;
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
	public BigDecimal getCurrentBalance() {
		checkAccount();
		return realAccount.getCurrentBalance();
	}

}
