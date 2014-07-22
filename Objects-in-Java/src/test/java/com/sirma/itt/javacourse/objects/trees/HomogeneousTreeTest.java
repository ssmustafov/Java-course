package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		HomogeneousTree<String> tree = new HomogeneousTree<String>();
		tree.insert("L");
		tree.insert("M");
		tree.insert("A");
		tree.insert("O");
		tree.insert("E");
		tree.insert("W");
		tree.insert("Q");
		tree.insert("C");
		String actual = tree.toString();
		String expected = "A C E L M O Q W ";

		assertEquals(expected, actual);
	}

}
