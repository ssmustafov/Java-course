package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode} class.
 * 
 * @author smustafov
 */
public class HeterogeneousTreeNodeTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#HeterogeneousTreeNode(java.lang.Object)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHeterogeneousTreeNodeWithNull() {
		new HeterogeneousTreeNode<Object>(null);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#getValue()} by
	 * checking the value of the node.
	 */
	@Test
	public void testHeterogeneousTreeNodeGetValue() {
		HeterogeneousTreeNode<String> node = new HeterogeneousTreeNode<String>("node");
		String actual = node.getValue();
		String expected = "node";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#setLeftChild(HeterogeneousTreeNode)}
	 * .
	 */
	@Test
	public void testHeterogeneousTreeNodeSetLeftChild() {
		HeterogeneousTreeNode<Object> node = new HeterogeneousTreeNode<Object>(55);
		HeterogeneousTreeNode<Object> leftChild = new HeterogeneousTreeNode<Object>(49);
		node.setLeftChild(leftChild);
		Object actual = node.getLeftChild().getValue();
		Object expected = 49;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#setRightChild(HeterogeneousTreeNode)}
	 * .
	 */
	@Test
	public void testHeterogeneousTreeNodeSetRightChild() {
		HeterogeneousTreeNode<Object> node = new HeterogeneousTreeNode<Object>("root");
		HeterogeneousTreeNode<Object> rightChild = new HeterogeneousTreeNode<Object>("rightchild");
		node.setRightChild(rightChild);
		Object actual = node.getRightChild().getValue();
		Object expected = "rightchild";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode} with simple nodes.
	 */
	@Test
	public void testHeterogeneousTreeNodeSimple() {
		HeterogeneousTreeNode<Object> node = new HeterogeneousTreeNode<Object>("root");
		HeterogeneousTreeNode<Object> childA = new HeterogeneousTreeNode<Object>("rightchild");
		HeterogeneousTreeNode<Object> childB = new HeterogeneousTreeNode<Object>(23);
		HeterogeneousTreeNode<Object> childC = new HeterogeneousTreeNode<Object>(1.999f);
		HeterogeneousTreeNode<Object> childD = new HeterogeneousTreeNode<Object>('Q');
		HeterogeneousTreeNode<Object> childE = new HeterogeneousTreeNode<Object>(100);

		node.setLeftChild(childD);
		childA.setRightChild(childC);
		childA.setLeftChild(childE);
		childB.setRightChild(childA);
		node.setRightChild(childB);
		Object actual = node.getRightChild().getRightChild().getLeftChild().getValue();
		Object expected = 100;

		assertEquals(expected, actual);
	}
}
