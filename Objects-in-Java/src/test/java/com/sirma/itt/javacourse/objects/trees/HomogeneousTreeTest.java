package com.sirma.itt.javacourse.objects.trees;

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

}
