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
		new HeterogeneousTreeNode(null);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#getValue()} by
	 * checking the value of the node.
	 */
	@Test
	public void testHeterogeneousTreeNodeGetValue() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode("node");
		String actual = node.getValue().toString();
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
		HeterogeneousTreeNode node = new HeterogeneousTreeNode(55);
		HeterogeneousTreeNode leftChild = new HeterogeneousTreeNode(49);
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
		HeterogeneousTreeNode node = new HeterogeneousTreeNode("root");
		HeterogeneousTreeNode rightChild = new HeterogeneousTreeNode("rightchild");
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
		HeterogeneousTreeNode node = new HeterogeneousTreeNode("root");
		HeterogeneousTreeNode childA = new HeterogeneousTreeNode("rightchild");
		HeterogeneousTreeNode childB = new HeterogeneousTreeNode(23);
		HeterogeneousTreeNode childC = new HeterogeneousTreeNode(1.999f);
		HeterogeneousTreeNode childD = new HeterogeneousTreeNode('Q');
		HeterogeneousTreeNode childE = new HeterogeneousTreeNode(100);

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
