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
	 * .
	 */
	@Test
	public void testAddChildSize() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>(10);
		node.addChild(new HomogeneousTreeNode<Integer>(7));
		int actual = node.getChildren().size();
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode#addChild(com.sirma.itt.javacourse.objects.trees.HomogeneousTreeNode)}
	 * .
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddChildWithNull() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>(10);
		node.addChild(null);
	}

}
