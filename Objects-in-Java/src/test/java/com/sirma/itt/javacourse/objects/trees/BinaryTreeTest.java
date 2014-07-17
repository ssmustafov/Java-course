package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree} class.
 * 
 * @author smustafov
 */
public class BinaryTreeTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#doesElementExists(int)} with
	 * existing element.
	 */
	@Test
	public void testDoesElementExistsWithTrue() {
		BinaryTree tree = new BinaryTree();
		tree.insert(23);
		tree.insert(1);
		tree.insert(200);
		tree.insert(78);
		tree.insert(40);
		tree.insert(39);
		tree.insert(5);
		tree.insert(6);
		if (!tree.doesElementExists(39)) {
			fail("The element '39' must exists");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#doesElementExists(int)} with
	 * not existing element.
	 */
	@Test
	public void testDoesElementExistsWithFalse() {
		BinaryTree tree = new BinaryTree();
		tree.insert(23);
		tree.insert(1);
		tree.insert(200);
		tree.insert(78);
		tree.insert(40);
		tree.insert(39);
		tree.insert(5);
		tree.insert(6);
		if (tree.doesElementExists(10)) {
			fail("The element '10' must not exists");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree} with negative number if it
	 * exists.
	 */
	@Test
	public void testBinaryTreeWithNegativeNumbers() {
		BinaryTree tree = new BinaryTree();
		tree.insert(-23);
		tree.insert(1);
		tree.insert(-200);
		tree.insert(78);
		tree.insert(-40);
		tree.insert(-39);
		tree.insert(5);
		tree.insert(6);
		tree.insert(0);
		if (!tree.doesElementExists(-200)) {
			fail("The element '-200' must exists");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getInOrderSort()}.
	 */
	@Test
	public void testGetInOrderSort() {
		BinaryTree tree = new BinaryTree();
		tree.insert(23);
		tree.insert(1);
		tree.insert(200);
		tree.insert(78);
		tree.insert(40);
		tree.insert(39);
		tree.insert(5);
		tree.insert(6);
		String actual = tree.getInOrderSort();
		String expected = "1 5 6 23 39 40 78 200 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getInOrderSort()} with one
	 * element.
	 */
	@Test
	public void testGetInOrderSortWithOneElement() {
		BinaryTree tree = new BinaryTree();
		tree.insert(1);
		String actual = tree.getInOrderSort();
		String expected = "1 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getPreOrderSort()}.
	 */
	@Test
	public void testGetPreOrderSort() {
		BinaryTree tree = new BinaryTree();
		tree.insert(40);
		tree.insert(78);
		tree.insert(25);
		tree.insert(10);
		tree.insert(32);
		String actual = tree.getPreOrderSort();
		String expected = "40 25 10 32 78 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getPreOrderSort()} with one
	 * element.
	 */
	@Test
	public void testGetPreOrderSortWithOneElement() {
		BinaryTree tree = new BinaryTree();
		tree.insert(40);
		String actual = tree.getPreOrderSort();
		String expected = "40 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getPostOrderSort()}.
	 */
	@Test
	public void testGetPostOrderSort() {
		BinaryTree tree = new BinaryTree();
		tree.insert(40);
		tree.insert(78);
		tree.insert(25);
		tree.insert(10);
		tree.insert(32);
		String actual = tree.getPostOrderSort();
		String expected = "10 32 25 78 40 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#getPostOrderSort()} with one
	 * element.
	 */
	@Test
	public void testGetPostOrderSortWithOneElement() {
		BinaryTree tree = new BinaryTree();
		tree.insert(78);
		String actual = tree.getPostOrderSort();
		String expected = "78 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTree#insert(int)}. Tries to add
	 * existing element.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertExistingElement() {
		BinaryTree tree = new BinaryTree();
		tree.insert(40);
		tree.insert(78);
		tree.insert(25);
		tree.insert(78);
		tree.insert(10);
		tree.insert(32);
	}

}
