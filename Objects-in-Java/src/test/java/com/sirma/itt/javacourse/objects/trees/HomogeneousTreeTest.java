package com.sirma.itt.javacourse.objects.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree} class.
 * 
 * @author smustafov
 */
public class HomogeneousTreeTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree#HomogeneousTree(java.lang.Object)}
	 * with null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHomogeneousTreeWithNull() {
		new HomogeneousTree<String>(null);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.objects.trees.HomogeneousTree} root value.
	 */
	@Test
	public void testHomogeneousTreeRoot() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>(20);
		HomogeneousTreeNode<Integer> root = tree.getRoot();
		int actual = root.getValue();
		int expected = 20;

		assertEquals(expected, actual);
	}

}
