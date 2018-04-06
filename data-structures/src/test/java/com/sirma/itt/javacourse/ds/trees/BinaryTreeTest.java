package com.sirma.itt.javacourse.ds.trees;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for {@link BinaryTree}.
 *
 * @author Sinan Mustafov
 */
public class BinaryTreeTest {

    @Test
    public void should_ConstructProperRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);
        assertEquals(Integer.valueOf(10), binaryTree.getRoot().getValue());
        assertNull(binaryTree.getRoot().getParent());
        assertNull(binaryTree.getRoot().getLeft());
        assertNull(binaryTree.getRoot().getRight());
        assertEquals(0, binaryTree.getRoot().getChildrenCount());
        assertEquals(Collections.emptyList(), binaryTree.getRoot().getChildren());
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_When_TryingToAddSecondRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);
        binaryTree.addRoot(20);
    }

    @Test
    public void addLeft_Should_ProperlyAddLeftChildToANode() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTreeNode<Integer> root = binaryTree.addRoot(14);
        BinaryTreeNode<Integer> left = binaryTree.addLeft(root, 19);

        assertEquals(Integer.valueOf(19), left.getValue());
        assertEquals(root, left.getParent());
        assertEquals(1, root.getChildrenCount());
        assertNull(left.getLeft());
        assertNull(left.getRight());
    }

    @Test(expected = IllegalStateException.class)
    public void addLeft_Should_ThrowException_When_ParentAlreadyHasLeftChild() {
        BinaryTree<String> binaryTree = new BinaryTree<>("R");
        BinaryTreeNode<String> root = binaryTree.getRoot();
        binaryTree.addLeft(root, "L");
        binaryTree.addLeft(root, "LL");
    }

    @Test
    public void addRight_Should_ProperlyAddRightChildToANode() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTreeNode<Integer> root = binaryTree.addRoot(14);
        binaryTree.addLeft(root, 10);
        BinaryTreeNode<Integer> right = binaryTree.addRight(root, 19);

        assertEquals(Integer.valueOf(19), right.getValue());
        assertEquals(root, right.getParent());
        assertEquals(2, root.getChildrenCount());
        assertNull(right.getLeft());
        assertNull(right.getRight());
    }

    @Test(expected = IllegalStateException.class)
    public void addRight_Should_ThrowException_When_ParentAlreadyHasRightChild() {
        BinaryTree<String> binaryTree = new BinaryTree<>("Root");
        BinaryTreeNode<String> root = binaryTree.getRoot();
        binaryTree.addRight(root, "R");
        binaryTree.addRight(root, "RR");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_When_ParentIsInvalidNode() {
        BinaryTree<String> binaryTree = new BinaryTree<>("Root");
        binaryTree.addRight(null, "rightChild");
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_When_NoRootNodeInitialized() {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.addRight(new TestNode<>(), "right");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_When_NotBinaryTreeNodePassed() {
        BinaryTree<String> binaryTree = new BinaryTree<>("root");
        binaryTree.addRight(new TestNode<>(), "right");
    }

    private static class TestNode<E> implements BinaryTreeNode<E> {
        @Override
        public BinaryTreeNode<E> getLeft() {
            return null;
        }

        @Override
        public BinaryTreeNode<E> getRight() {
            return null;
        }

        @Override
        public E getValue() {
            return null;
        }

        @Override
        public int getChildrenCount() {
            return 0;
        }

        @Override
        public List<? extends TreeNode<E>> getChildren() {
            return null;
        }

        @Override
        public BinaryTreeNode<E> getParent() {
            return null;
        }
    }

}
