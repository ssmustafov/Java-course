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
	 * by setting the root without constructor.
	 */
	@Test
	public void testHeterogeneousTreeSetRoot() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>();
		HeterogeneousTreeNode<Object> node = new HeterogeneousTreeNode<Object>(123);
		tree.setRoot(node);
		Object actual = tree.getRoot().getValue();
		Object expected = 123;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#insert(Object)}.
	 */
	@Test
	public void testHeterogeneousTreeInsert() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>("root");
		tree.insert(2);
		tree.insert("text");
		tree.insert(12.987);
		tree.insert(4127909247827L);
		Object actual = tree.getRoot().getValue();
		Object expected = "root";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getInOrderSort()}.
	 */
	@Test
	public void testGetInOrderSort() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>("root");
		tree.insert(23);
		tree.insert('Q');
		tree.insert("rightchild");
		tree.insert(100);
		tree.insert(1.999f);
		String actual = tree.getInOrderSort();
		String expected = "rightchild 23 Q 100 root 1.999 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getInOrderSort()} with
	 * one element in the tree.
	 */
	@Test
	public void testGetInOrderSortWithOneElement() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>();
		tree.insert(23);
		String actual = tree.getInOrderSort();
		String expected = "23 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getPreOrderSort()}.
	 */
	@Test
	public void testGetPreOrderSort() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>("root");
		tree.insert(23);
		tree.insert('Q');
		tree.insert("rightchild");
		tree.insert(100);
		tree.insert(1.999f);
		String actual = tree.getPreOrderSort();
		String expected = "root 23 rightchild Q 100 1.999 ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getPreOrderSort()} wit
	 * one element in the tree.
	 */
	@Test
	public void testGetPreOrderSortWithOneElement() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>();
		tree.insert('Q');
		String actual = tree.getPreOrderSort();
		String expected = "Q ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getPostOrderSort()}.
	 */
	@Test
	public void testGetPostOrderSort() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>("root");
		tree.insert(23);
		tree.insert('Q');
		tree.insert("rightchild");
		tree.insert(100);
		tree.insert(1.999f);
		String actual = tree.getPostOrderSort();
		String expected = "rightchild 100 Q 23 1.999 root ";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HeterogeneousTree#getPostOrderSort()}
	 * with one element in the tree.
	 */
	@Test
	public void testGetPostOrderSortWithOneElement() {
		HeterogeneousTree<Object> tree = new HeterogeneousTree<Object>("root");
		String actual = tree.getPostOrderSort();
		String expected = "root ";

		assertEquals(expected, actual);
	}

}
