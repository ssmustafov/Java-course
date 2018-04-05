package com.sirma.itt.javacourse.ds.trees;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link TreeTraversal}.
 *
 * @author Sinan Mustafov
 */
public class TreeTraversalTest {

    @Test
    public void should_CorrectlyApplyDFS() {
        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        assertEquals(Integer.valueOf(7), tree.getRoot());

        List<Integer> nodes = TreeTraversal.traverseDFS(tree.getRootNode());
        assertEquals(Arrays.asList(7, 19, 1, 12, 31, 21, 14, 23, 6), nodes);
    }

    @Test
    public void should_CorrectlyApplyBFS() {
        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        assertEquals(Integer.valueOf(7), tree.getRoot());

        List<Integer> nodes = TreeTraversal.traverseBFS(tree.getRootNode());
        assertEquals(Arrays.asList(7, 19, 21, 14, 1, 12, 31, 23, 6), nodes);
    }

}
