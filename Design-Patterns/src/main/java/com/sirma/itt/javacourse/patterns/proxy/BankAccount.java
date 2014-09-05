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
	 * Creates a new bank account with initial balance of 1000.
	 */
	public BankAccount() {
		balance = new BigDecimal("1000.00");
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
	public BigDecimal currentBalance() {
		return balance;
	}

}
