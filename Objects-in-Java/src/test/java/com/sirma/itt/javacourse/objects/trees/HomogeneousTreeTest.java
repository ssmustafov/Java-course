package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree} class.
 * 
 * @author smustafov
 */
public class HomogeneousTreeTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#HomogeneousTree(java.lang.Object)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeWithNull() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>();
		tree.insert(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#HomogeneousTree(java.lang.Object)}
	 * by adding existing element.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeAddExistsingElement() {
		HomogeneousTree<String> tree = new HomogeneousTree<String>();
		tree.insert("D");
		tree.insert("OS");
		tree.insert("A");
		tree.insert("P");
		tree.insert("Word");
		tree.insert("WORD");
		tree.insert("A");
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#doesElementExists(Object)} with
	 * existing element.
	 */
	@Test
	public void testHomogeneousTreeDoesElementExistsWithTrue() {
		HomogeneousTree<String> tree = new HomogeneousTree<String>();
		tree.insert("D");
		tree.insert("OS");
		tree.insert("A");
		tree.insert("P");
		tree.insert("Word");
		tree.insert("WORD");
		if (!tree.doesElementExists("OS")) {
			fail("The element 'OS' must exist in the tree");
		}
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#doesElementExists(Object)} with
	 * not existing element.
	 */
	@Test
	public void testHomogeneousTreeDoesElementExistsWithFalse() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>();
		tree.insert(56);
		tree.insert(12);
		tree.insert(2);
		tree.insert(69);
		tree.insert(59);
		tree.insert(100);
		if (tree.doesElementExists(5)) {
			fail("The element '5' must not exist in the tree");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#toString()} with one
	 * element.
	 */
	@Test
	public void testHomogeneousTreeToStringWithOneElement() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>();
		tree.insert(56);
		String actual = tree.toString();
		String expected = "56 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#toString()}.
	 */
	@Test
	public void testHomogeneousTreeToStringSimple() {
		HomogeneousTree<Character> tree = new HomogeneousTree<Character>();
		tree.insert('L');
		tree.insert('M');
		tree.insert('A');
		tree.insert('O');
		tree.insert('E');
		tree.insert('W');
		tree.insert('Q');
		tree.insert('C');
		String actual = tree.toString();
		String expected = "A C E L M O Q W ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#toString()} with
	 * <code>BigDecimal</code>.
	 */
	@Test
	public void testHomogeneousTreeWithBigDecimal() {
		HomogeneousTree<BigDecimal> tree = new HomogeneousTree<BigDecimal>();
		tree.insert(new BigDecimal("66.33"));
		tree.insert(new BigDecimal("23"));
		tree.insert(new BigDecimal("117.99"));
		tree.insert(new BigDecimal("20"));
		tree.insert(new BigDecimal("9"));
		tree.insert(new BigDecimal("78.33"));
		tree.insert(new BigDecimal("65.32389"));
		tree.insert(new BigDecimal("1.119"));
		String actual = tree.toString();
		String expected = "1.119 9 20 23 65.32389 66.33 78.33 117.99 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#toString()} with
	 * <code>BigInteger</code>.
	 */
	@Test
	public void testHomogeneousTreeWithBigInteger() {
		HomogeneousTree<BigInteger> tree = new HomogeneousTree<BigInteger>();
		tree.insert(new BigInteger("9879887978978645236"));
		tree.insert(new BigInteger("4731231254"));
		tree.insert(new BigInteger("6345681088080804544780"));
		tree.insert(new BigInteger("47312"));
		tree.insert(new BigInteger("567322656456"));
		tree.insert(new BigInteger("138084642186806086834"));
		String actual = tree.toString();
		String expected = "47312 4731231254 567322656456 9879887978978645236 138084642186806086834 6345681088080804544780 ";

		assertEquals(expected, actual);
	}

}
