package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree} class.
 * 
 * @author smustafov
 */
public class HeterogeneousTreeTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#HeterogeneousTree()}
	 * without any data.
	 */
	@Test
	public void testEmptyHeterogeneousTree() {
		HeterogeneousTree<Integer> tree = new HeterogeneousTree<Integer>();
		if (tree.getRoot() != null) {
			fail("There are data in the tree but it must not");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#HeterogeneousTree()}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHeterogeneousTreeWithNull() {
		new HeterogeneousTree<Integer>(null);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#setRoot(HeterogeneousTreeNode)}
	 * .
	 */
	@Test
	public void testHeterogeneousTreeSetRoot() {
		HeterogeneousTree<Integer> tree = new HeterogeneousTree<Integer>();
		HeterogeneousTreeNode<Integer> node = new HeterogeneousTreeNode<Integer>(123);
		tree.setRoot(node);
		int actual = tree.getRoot().getValue();
		int expected = 123;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#insert(Object)} with
	 * different types.
	 */
	@Test
	public void testHeterogeneousTreeInsert() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>(50);
		tree.insert("Text");
		tree.insert(12.345f);
		tree.insert('Q');
		tree.insert(100);
		Object actual = tree.getRoot().getChild(2).getValue();
		Object expected = 'Q';

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#insert(Object)} with
	 * different types at given index.
	 */
	@Test
	public void testHeterogeneousTreeInsertAt() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>(50);
		tree.insert("Text");
		tree.insert(12.345f);
		tree.insert('Q');
		tree.insert(100);
		tree.insert(22, 1);
		Object actual = tree.getRoot().getChild(1).getChild(0).getValue();
		Object expected = 22;

		assertEquals(expected, actual);
	}

}
