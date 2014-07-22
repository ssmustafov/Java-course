package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode} class.
 * 
 * @author smustafov
 */
public class HomogeneousTreeNodeTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#HomogeneousTreeNode(java.lang.Object)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeNodeWithNull() {
		new HomogeneousTreeNode<Integer>(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#HomogeneousTreeNode(java.lang.Object)}
	 * left child does have expected value.
	 */
	@Test
	public void testHomogeneousTreeNodeLeftChild() {
		HomogeneousTreeNode<Integer> tree = new HomogeneousTreeNode<Integer>(55);
		HomogeneousTreeNode<Integer> left = new HomogeneousTreeNode<Integer>(23);
		HomogeneousTreeNode<Integer> right = new HomogeneousTreeNode<Integer>(154);
		tree.setLeftChild(left);
		tree.setRightChild(right);
		int actual = tree.getLeftChild().getValue();
		int expected = 23;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#HomogeneousTreeNode(java.lang.Object)}
	 * right child does have expected value.
	 */
	@Test
	public void testHomogeneousTreeNodeRightChild() {
		HomogeneousTreeNode<Integer> tree = new HomogeneousTreeNode<Integer>(55);
		HomogeneousTreeNode<Integer> left = new HomogeneousTreeNode<Integer>(23);
		HomogeneousTreeNode<Integer> right = new HomogeneousTreeNode<Integer>(154);
		HomogeneousTreeNode<Integer> rightA = new HomogeneousTreeNode<Integer>(99);
		HomogeneousTreeNode<Integer> rightB = new HomogeneousTreeNode<Integer>(120);
		tree.setLeftChild(left);
		tree.setRightChild(right);
		tree.getRightChild().setLeftChild(rightA);
		tree.getRightChild().getLeftChild().setRightChild(rightB);
		int actual = tree.getRightChild().getLeftChild().getRightChild().getValue();
		int expected = 120;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#HomogeneousTreeNode(java.lang.Object)}
	 * right child with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeNodeRightChildNull() {
		HomogeneousTreeNode<Integer> tree = new HomogeneousTreeNode<Integer>(55);
		HomogeneousTreeNode<Integer> left = new HomogeneousTreeNode<Integer>(23);
		HomogeneousTreeNode<Integer> right = new HomogeneousTreeNode<Integer>(154);
		HomogeneousTreeNode<Integer> rightA = new HomogeneousTreeNode<Integer>(99);
		HomogeneousTreeNode<Integer> rightB = null;
		tree.setLeftChild(left);
		tree.setRightChild(right);
		tree.getRightChild().setLeftChild(rightA);
		tree.getRightChild().getLeftChild().setRightChild(rightB);
		tree.getRightChild().getLeftChild().getRightChild().getValue();
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#HomogeneousTreeNode(java.lang.Object)}
	 * left child with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeNodeLeftChildNull() {
		HomogeneousTreeNode<Integer> tree = new HomogeneousTreeNode<Integer>(55);
		HomogeneousTreeNode<Integer> left = new HomogeneousTreeNode<Integer>(23);
		HomogeneousTreeNode<Integer> right = new HomogeneousTreeNode<Integer>(154);
		HomogeneousTreeNode<Integer> rightA = null;
		HomogeneousTreeNode<Integer> rightB = new HomogeneousTreeNode<Integer>(99);
		tree.setLeftChild(left);
		tree.setRightChild(right);
		tree.getRightChild().setLeftChild(rightA);
		tree.getRightChild().getLeftChild().setRightChild(rightB);
		tree.getRightChild().getLeftChild().getRightChild().getValue();
	}

}
