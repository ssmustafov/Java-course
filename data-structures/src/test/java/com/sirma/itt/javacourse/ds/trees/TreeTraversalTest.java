package com.sirma.itt.javacourse.ds.trees;

import org.junit.Test;

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
    public void should_CorrectlyApplyDFS_ToGenericTree() {
        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        TreeNode<Integer> rootNode = tree.getRoot();
        assertEquals(Integer.valueOf(7), rootNode.getValue());

        List<Integer> nodes = TreeTraversal.traverseDFS(rootNode);
        assertEquals(Arrays.asList(7, 19, 1, 12, 31, 21, 14, 23, 6), nodes);
    }

    @Test
    public void should_CorrectlyApplyBFS_ToGenericTree() {
        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        TreeNode<Integer> rootNode = tree.getRoot();
        assertEquals(Integer.valueOf(7), rootNode.getValue());

        List<Integer> nodes = TreeTraversal.traverseBFS(rootNode);
        assertEquals(Arrays.asList(7, 19, 21, 14, 1, 12, 31, 23, 6), nodes);
    }

    @Test
    public void should_CorrectlyApplyDFS_ToBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(14,
                new BinaryTree<>(19,
                        new BinaryTree<>(23),
                        new BinaryTree<>(6,
                                new BinaryTree<>(10),
                                new BinaryTree<>(21))),
                new BinaryTree<>(15,
                        new BinaryTree<>(3),
                        null));

        BinaryTreeNode<Integer> rootNode = binaryTree.getRoot();
        assertEquals(Integer.valueOf(14), rootNode.getValue());

        List<Integer> nodes = TreeTraversal.traverseDFS(rootNode);
        assertEquals(Arrays.asList(14, 19, 23, 6, 10, 21, 15, 3), nodes);
    }

    @Test
    public void should_CorrectlyApplyBFS_ToBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(14,
                new BinaryTree<>(19,
                        new BinaryTree<>(23),
                        new BinaryTree<>(6,
                                new BinaryTree<>(10),
                                new BinaryTree<>(21))),
                new BinaryTree<>(15,
                        new BinaryTree<>(3),
                        null));

        BinaryTreeNode<Integer> rootNode = binaryTree.getRoot();
        assertEquals(Integer.valueOf(14), rootNode.getValue());

        List<Integer> nodes = TreeTraversal.traverseBFS(rootNode);
        assertEquals(Arrays.asList(14, 19, 15, 23, 6, 3, 10, 21), nodes);
    }

    @Test
    public void should_CorrectlyTraverseInOrder() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(14,
                new BinaryTree<>(19,
                        new BinaryTree<>(23),
                        new BinaryTree<>(6,
                                new BinaryTree<>(10),
                                new BinaryTree<>(21))),
                new BinaryTree<>(15,
                        new BinaryTree<>(3),
                        null));

        List<Integer> nodes = TreeTraversal.traverseInOrder(binaryTree.getRoot());
        assertEquals(Arrays.asList(23, 19, 10, 6, 21, 14, 3, 15), nodes);
    }

    @Test
    public void should_CorrectlyTraversePreOrder() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(14,
                new BinaryTree<>(19,
                        new BinaryTree<>(23),
                        new BinaryTree<>(6,
                                new BinaryTree<>(10),
                                new BinaryTree<>(21))),
                new BinaryTree<>(15,
                        new BinaryTree<>(3),
                        null));

        List<Integer> nodes = TreeTraversal.traversePreOrder(binaryTree.getRoot());
        assertEquals(Arrays.asList(14, 19, 23, 6, 10, 21, 15, 3), nodes);
    }

    @Test
    public void should_CorrectlyTraversePostOrder() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(14,
                new BinaryTree<>(19,
                        new BinaryTree<>(23),
                        new BinaryTree<>(6,
                                new BinaryTree<>(10),
                                new BinaryTree<>(21))),
                new BinaryTree<>(15,
                        new BinaryTree<>(3),
                        null));

        List<Integer> nodes = TreeTraversal.traversePostOrder(binaryTree.getRoot());
        assertEquals(Arrays.asList(23, 10, 21, 6, 19, 3, 15, 14), nodes);
    }

}
