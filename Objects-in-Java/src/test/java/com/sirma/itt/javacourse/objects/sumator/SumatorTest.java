package com.sirma.itt.javacourse.objects.sumator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator} class.
 * 
 * @author smustafov
 */
public class SumatorTest {

	private Sumator sumator = new Sumator();
	private static final double DELTA = 1e-7;

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(byte, byte)} with zeros.
	 */
	@Test
	public void testSumByteWithZeros() {
		byte number1 = 0;
		byte number2 = 0;
		byte actual = sumator.sum(number1, number2);
		byte expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(byte, byte)} with negative
	 * numbers.
	 */
	@Test
	public void testSumByteWithNegativeNumbers() {
		byte number1 = -20;
		byte number2 = -10;
		byte actual = sumator.sum(number1, number2);
		byte expected = -30;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(byte, byte)} with Byte's
	 * bounds.
	 */
	@Test
	public void testSumByteWithBounds() {
		byte number1 = 63;
		byte number2 = 65;
		byte actual = sumator.sum(number1, number2);
		byte expected = -128;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(short, short)} with Short's
	 * bounds.
	 */
	@Test
	public void testSumShortWithBounds() {
		short number1 = 16383;
		short number2 = 16385;
		short actual = sumator.sum(number1, number2);
		short expected = -32768;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(short, short)} with zeros.
	 */
	@Test
	public void testSumShortWithZeros() {
		short number1 = 0;
		short number2 = 0;
		short actual = sumator.sum(number1, number2);
		short expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(short, short)} with
	 * negative numbers.
	 */
	@Test
	public void testSumShortWithNegativeNumbers() {
		short number1 = -300;
		short number2 = -500;
		short actual = sumator.sum(number1, number2);
		short expected = -800;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(int, int)} with zeros.
	 */
	@Test
	public void testSumIntWithZeros() {
		int actual = sumator.sum(0, 0);
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(int, int)} with negative
	 * numbers.
	 */
	@Test
	public void testSumIntWithNegativeNumbers() {
		int actual = sumator.sum(-25, -40);
		int expected = -65;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(int, int)} with Integer's
	 * bounds.
	 */
	@Test
	public void testSumIntWithBounds() {
		int actual = sumator.sum(1073741823, 1073741825);
		int expected = -2147483648;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(long, long)} with zeros.
	 */
	@Test
	public void testSumLongWithZeros() {
		long actual = sumator.sum(0L, 0L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(long, long)} with negative
	 * numbers.
	 */
	@Test
	public void testSumLongWithNegativeNumbers() {
		long actual = sumator.sum(-20L, -50L);
		long expected = -70L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(long, long)} with Long's
	 * bounds.
	 */
	@Test
	public void testSumLongWithBounds() {
		long actual = sumator.sum(4611686018427387903L, 4611686018427387905L);
		long expected = -9223372036854775808L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(float, float)} with zeros.
	 */
	@Test
	public void testSumFloatWithZeros() {
		float actual = sumator.sum(0.0f, 0.0f);
		float expected = 0.0f;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(float, float)} with
	 * negative numbers.
	 */
	@Test
	public void testSumFloatWithNegativeNumbers() {
		float actual = sumator.sum(-1.3f, -1.7f);
		float expected = -3.0f;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(double, double)} with
	 * zeros.
	 */
	@Test
	public void testSumDoubleWithZeros() {
		double actual = sumator.sum(0.0d, 0.0d);
		double expected = 0.0d;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(double, double)} with
	 * negative numbers.
	 */
	@Test
	public void testSumDoubleWithNegativeNumbers() {
		double actual = sumator.sum(-1.3d, -1.7d);
		double expected = -3.0d;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigInteger, java.math.BigInteger)}
	 * with zeros.
	 */
	@Test
	public void testSumBigIntegerWithZeros() {
		BigInteger number1 = new BigInteger("0");
		BigInteger number2 = new BigInteger("0");
		BigInteger actual = sumator.sum(number1, number2);
		BigInteger expected = new BigInteger("0");

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigInteger, java.math.BigInteger)}
	 * with negative numbers.
	 */
	@Test
	public void testSumBigIntegerWithNegativeNumbers() {
		BigInteger number1 = new BigInteger("-29857893979382453");
		BigInteger number2 = new BigInteger("-98799974934543890");
		BigInteger actual = sumator.sum(number1, number2);
		BigInteger expected = new BigInteger("-128657868913926343");

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigInteger, java.math.BigInteger)}
	 * with invalid parameters.
	 */
	@Test(expected = NumberFormatException.class)
	public void testSumBigIntegerWithInvalidParameters() {
		BigInteger number1 = new BigInteger("asd78939-==_=342@#3");
		BigInteger number2 = new BigInteger("~!@#$%^&*()_");
		sumator.sum(number1, number2);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigDecimal, java.math.BigDecimal)}
	 * with zeros.
	 */
	@Test
	public void testSumBigDecimalWithZeros() {
		BigDecimal number1 = new BigDecimal("0");
		BigDecimal number2 = new BigDecimal("0");
		BigDecimal actual = sumator.sum(number1, number2);
		BigDecimal expected = new BigDecimal("0");

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigDecimal, java.math.BigDecimal)}
	 * with negative numbers.
	 */
	@Test
	public void testSumBigDecimalWithNegativeNumbers() {
		BigDecimal number1 = new BigDecimal("-984988249809.2315484");
		BigDecimal number2 = new BigDecimal("-31586.31356498045");
		BigDecimal actual = sumator.sum(number1, number2);
		BigDecimal expected = new BigDecimal("-984988281395.54511338045");

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigDecimal, java.math.BigDecimal)}
	 * with invalid parameters.
	 */
	@Test(expected = NumberFormatException.class)
	public void testSumBigDecimalWithInvalidParameters() {
		BigDecimal number1 = new BigDecimal("-98!49882okhjfafa4980;9.2315484");
		BigDecimal number2 = new BigDecimal("-315=86.3135649@80as#fasfa45");
		sumator.sum(number1, number2);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with empty
	 * Strings.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSumStringEmpty() {
		sumator.sum("", "");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with
	 * numbers.
	 */
	@Test
	public void testSumStringWithNumbers() {
		String actual = sumator.sum("356", "24");
		String expected = "380";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with
	 * negative numbers.
	 */
	@Test
	public void testSumStringWithNegativeNumbers() {
		String actual = sumator.sum("-400", "-600");
		String expected = "-1000";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with real
	 * numbers.
	 */
	@Test
	public void testSumStringWithRealNumbers() {
		String actual = sumator.sum("52.47", "23.99");
		String expected = "76.46";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with big
	 * numbers.
	 */
	@Test
	public void testSumStringWithBigNumbers() {
		String actual = sumator.sum("963875973959735395", "23947898752859843598");
		String expected = "24911774726819578993";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with
	 * invalid numbers.
	 */
	@Test(expected = NumberFormatException.class)
	public void testSumStringWithInvalidNumbers() {
		sumator.sum("7e^2d123", "4a.00");
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(String, String)} with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSumStringWithNull() {
		sumator.sum(null, "simple text");
	}

}
