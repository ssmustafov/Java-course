package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode} class.
 * 
 * @author smustafov
 */
public class BinaryTreeNodeTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode#BinaryTreeNode(java.lang.Object)}
	 * with given value without children.
	 */
	@Test
	public void testBinaryTreeNode() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(2);
		int actual = node.getValue();
		int expected = 2;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode#setLeftChild(com.sirma.itt.javacourse.objects.trees.BinaryTreeNode)}
	 * .
	 */
	@Test
	public void testSetLeftChild() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(100);
		node.setLeftChild(new BinaryTreeNode<Integer>(22));
		int actual = node.getLeftChild().getValue();
		int expected = 22;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode#setLeftChild(com.sirma.itt.javacourse.objects.trees.BinaryTreeNode)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetLeftChildWithNull() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(100);
		node.setLeftChild(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode#setRightChild(com.sirma.itt.javacourse.objects.trees.BinaryTreeNode)}
	 * .
	 */
	@Test
	public void testSetRightChild() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(44);
		node.setRightChild(new BinaryTreeNode<Integer>(120));
		int actual = node.getRightChild().getValue();
		int expected = 120;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.BinaryTreeNode#setRightChild(com.sirma.itt.javacourse.objects.trees.BinaryTreeNode)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetRightChildWithNull() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(44);
		node.setRightChild(null);
	}

}
