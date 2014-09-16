package com.sirma.itt.javacourse.patterns.proxy;

import java.math.BigDecimal;

/**
 * Represents a bank account. Implements <code>Account</code> interface.
 * 
 * @author smustafov
 */
public class BankAccount implements Account {

	private static final BigDecimal ZERO = new BigDecimal("0.00");
	private BigDecimal balance;

	/**
	 * Creates a new bank account with given initial balance of Amount.
	 * 
	 * @param initialAmount
	 *            - starting amount of the account to be set
	 */
	public BankAccount(BigDecimal initialAmount) {
		if (initialAmount.compareTo(ZERO) == -1) {
			throw new IllegalArgumentException(
					"It is not possible to create an account with negative amount: "
							+ initialAmount.toString());
		}
		balance = initialAmount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deposit(BigDecimal amount) {
		if (amount.compareTo(ZERO) == -1) {
			throw new IllegalArgumentException("It is not possible to deposit negative amount: "
					+ amount.toString());
		}

		balance = balance.add(amount);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(balance) == 1) {
			throw new IllegalArgumentException(
					"Insufficient balance, you cannot withdraw. Your balance is: "
							+ balance.toString());
		}

		balance = balance.subtract(amount);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getCurrentBalance() {
		return balance;
	}

}
