package com.sirma.itt.javacourse.patterns.proxy;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy} class.
 * 
 * @author smustafov
 */
public class BankAccountProxyTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#deposit(java.math.BigDecimal)}
	 * with negative amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDepositWithNegativeAmount() {
		Account acc = BankAccountFactory.createInstance();
		acc.deposit(new BigDecimal("-100000000"));
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#deposit(java.math.BigDecimal)}
	 * with positive amount and amount less than the minimum deposit amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDepositWithPositive() {
		Account acc = BankAccountFactory.createInstance();
		acc.deposit(new BigDecimal("9"));
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#withdraw(BigDecimal)}
	 * with negative amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawWithNegative() {
		Account acc = BankAccountFactory.createInstance();
		acc.withdraw(new BigDecimal("-10"));
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#withdraw(BigDecimal)}
	 * with above the maximum amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawWithMax() {
		Account acc = BankAccountFactory.createInstance();
		acc.withdraw(new BigDecimal("401"));
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#withdraw(BigDecimal)}
	 * with amount in the range of the bank account.
	 */
	@Test
	public void testWithdrawNormalCase() {
		Account acc = BankAccountFactory.createInstance();
		acc.withdraw(new BigDecimal("120.00"));

		BigDecimal actual = acc.getCurrentBalance();
		BigDecimal expected = new BigDecimal("880.00");

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy#deposit(BigDecimal)}
	 * with amount in the range of the bank account.
	 */
	@Test
	public void testDepositNormalCase() {
		Account acc = BankAccountFactory.createInstance();
		acc.deposit(new BigDecimal("155.20"));

		BigDecimal actual = acc.getCurrentBalance();
		BigDecimal expected = new BigDecimal("1155.20");

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.proxy.BankAccountProxy} with series of
	 * deposits and withdraws.
	 */
	@Test
	public void testSeriesDepositAndWithdraws() {
		Account acc = BankAccountFactory.createInstance();
		acc.deposit(new BigDecimal("200.00"));
		acc.withdraw(new BigDecimal("300.00"));
		acc.withdraw(new BigDecimal("300.00"));
		acc.withdraw(new BigDecimal("150.00"));
		acc.withdraw(new BigDecimal("300.00"));
		acc.deposit(new BigDecimal("100.00"));
		acc.deposit(new BigDecimal("50.00"));
		acc.withdraw(new BigDecimal("150.00"));

		BigDecimal actual = acc.getCurrentBalance();
		BigDecimal expected = new BigDecimal("150.00");

		assertEquals(expected, actual);
	}

}
