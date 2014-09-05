package com.sirma.itt.javacourse.patterns.proxy;

import java.math.BigDecimal;

/**
 * Interface for bank account.
 * 
 * @author smustafov
 */
public interface Account {

	/**
	 * Deposits given amount to the account.
	 * 
	 * @param amount
	 *            - amount to be deposited
	 */
	void deposit(BigDecimal amount);

	/**
	 * Withdraws given amount of the account's balance.
	 * 
	 * @param amount
	 *            - amount to be withdrawer
	 */
	void withdraw(BigDecimal amount);

	/**
	 * Returns the current balance of the account.
	 * 
	 * @return - current balance of the account
	 */
	BigDecimal currentBalance();

}
