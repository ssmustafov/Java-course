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
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * with adding null child.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddChildWithNull() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>(10);
		node.addChild(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * the value of one node.
	 */
	@Test
	public void testOneNode() {
		HomogeneousTreeNode<String> node = new HomogeneousTreeNode<String>("data");
		String actual = node.getValue();
		String expected = "data";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * how many child the node has.
	 */
	@Test
	public void testNumberOfChildren() {
		HomogeneousTreeNode<String> node = new HomogeneousTreeNode<String>("Node");
		HomogeneousTreeNode<String> child1 = new HomogeneousTreeNode<String>("Child1");
		HomogeneousTreeNode<String> child2 = new HomogeneousTreeNode<String>("Child2");
		node.addChild(child1);
		node.addChild(child2);
		int actual = node.getChildren().size();
		int expected = 2;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * with getting child at given index.
	 */
	@Test
	public void testChildAt() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>(12);
		HomogeneousTreeNode<Integer> child1 = new HomogeneousTreeNode<Integer>(9);
		HomogeneousTreeNode<Integer> child2 = new HomogeneousTreeNode<Integer>(313565);
		node.addChild(child1);
		node.addChild(child2);
		int actual = node.getChild(1).getValue();
		int expected = 313565;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * with getting child at out of bound index.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testChildAtNoExisting() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>(12);
		node.getChild(1).getValue();
	}

}
