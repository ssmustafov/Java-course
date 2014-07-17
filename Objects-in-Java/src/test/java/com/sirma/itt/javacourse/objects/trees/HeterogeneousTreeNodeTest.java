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
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#HeterogeneousTreeNode(java.lang.Object)}
	 * by checking the value of the node.
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
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#addChild(HeterogeneousTreeNode)}
	 * by adding null child to the node.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHeterogeneousTreeNodeAddNullChild() {
		HeterogeneousTreeNode<String> node = new HeterogeneousTreeNode<String>("node");
		node.addChild(null);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#getChildrenCount()}
	 * by adding 3 children to the node.
	 */
	@Test
	public void testHeterogeneousTreeNodeGetChildrenCount() {
		HeterogeneousTreeNode<String> node = new HeterogeneousTreeNode<String>("node");
		HeterogeneousTreeNode<String> child1 = new HeterogeneousTreeNode<String>("child1");
		HeterogeneousTreeNode<String> child2 = new HeterogeneousTreeNode<String>("child2");
		HeterogeneousTreeNode<String> child3 = new HeterogeneousTreeNode<String>("child3");
		node.addChild(child1);
		node.addChild(child2);
		node.addChild(child3);
		int actual = node.getChildrenCount();
		int expected = 3;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#removeChildAt(int)}
	 * by removing one child from the node.
	 */
	@Test
	public void testHeterogeneousTreeNodeRemoveChild() {
		HeterogeneousTreeNode<Integer> node = new HeterogeneousTreeNode<Integer>(45);
		HeterogeneousTreeNode<Integer> child1 = new HeterogeneousTreeNode<Integer>(12);
		HeterogeneousTreeNode<Integer> child2 = new HeterogeneousTreeNode<Integer>(19);
		HeterogeneousTreeNode<Integer> child3 = new HeterogeneousTreeNode<Integer>(38);
		node.addChild(child1);
		node.addChild(child2);
		node.addChild(child3);
		node.removeChildAt(1);
		int actual = node.getChildrenCount();
		int expected = 2;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTreeNode#insertChildAt(int, HeterogeneousTreeNode)}
	 * by adding child to the zero index.
	 */
	@Test
	public void testHeterogeneousTreeNodeInsertChild() {
		HeterogeneousTreeNode<Integer> node = new HeterogeneousTreeNode<Integer>(45);
		HeterogeneousTreeNode<Integer> child1 = new HeterogeneousTreeNode<Integer>(12);
		HeterogeneousTreeNode<Integer> child2 = new HeterogeneousTreeNode<Integer>(19);
		HeterogeneousTreeNode<Integer> child3 = new HeterogeneousTreeNode<Integer>(38);
		node.addChild(child1);
		node.addChild(child2);
		node.insertChildAt(0, child3);

		int actual = node.getChild(0).getValue();
		int expected = 38;

		assertEquals(expected, actual);
	}

}
