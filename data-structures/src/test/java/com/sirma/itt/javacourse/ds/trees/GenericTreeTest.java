package com.sirma.itt.javacourse.ds.trees;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link GenericTree}.
 *
 * @author Sinan Mustafov
 */
public class GenericTreeTest {

    // node tests

    @Test
    public void node_Should_HaveZeroChildren_When_NoChildren() {
        GenericTree<Integer> tree = new GenericTree<>(10);
        TreeNode<Integer> rootNode = tree.getRootNode();

        assertEquals(Integer.valueOf(10), rootNode.getValue());
        assertEquals(0, rootNode.getChildrenCount());
        assertEquals(Collections.emptyList(), rootNode.getChildren());
    }

    @Test
    public void node_Should_HaveCorrectChildren() {
        GenericTree<String> tree = new GenericTree<>("a");
        TreeNode<String> rootNode = tree.getRootNode();
        tree.addChildToNode(rootNode, "b");

        assertEquals("a", rootNode.getValue());
        assertEquals(1, rootNode.getChildrenCount());
    }

    @Test
    public void nodeIsExternal_Should_ReturnTrue_When_NodeHaveNoChildren() {
        GenericTree<Integer> leafSubTree = new GenericTree<>(12);

        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        leafSubTree,
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        TreeNode<Integer> node = leafSubTree.getRootNode();

        assertTrue(node.isExternal());
        assertFalse(node.isInternal());
    }

    @Test
    public void nodeIsExternal_Should_ReturnFalse_When_NodeHaveChildren() {
        GenericTree<Integer> subTree = new GenericTree<>(14,
                new GenericTree<>(23),
                new GenericTree<>(6));

        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                subTree);

        TreeNode<Integer> node = subTree.getRootNode();

        assertFalse(node.isExternal());
        assertTrue(node.isInternal());
    }

    @Test
    public void nodeIsRoot_Should_ReturnFalse_When_HasParent() {
        GenericTree<Integer> subTree = new GenericTree<>(14);
        GenericTree<Integer> tree = new GenericTree<>(7, subTree);

        assertFalse(subTree.getRootNode().isRoot());
    }

    @Test
    public void nodeIsRoot_Should_ReturnTrue_When_HasNoParent() {
        GenericTree<Integer> subTree = new GenericTree<>(14);
        GenericTree<Integer> tree = new GenericTree<>(7, subTree);

        assertTrue(tree.getRootNode().isRoot());
    }

    @Test
    public void nodeDepth_Should_ReturnZero_When_Root() {
        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        new GenericTree<>(6)));

        assertEquals(0, tree.depth(tree.getRootNode()));
    }

    @Test
    public void nodeDepth_Should_CalculateProperly() {
        GenericTree<Integer> oneLevelSubTree = new GenericTree<>(21);
        GenericTree<Integer> twoLevelSubTree = new GenericTree<>(6);

        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                oneLevelSubTree,
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        twoLevelSubTree));

        assertEquals(1, tree.depth(oneLevelSubTree.getRootNode()));
        assertEquals(2, tree.depth(twoLevelSubTree.getRootNode()));
    }

    @Test
    public void nodeHeight_Should_ReturnZero_When_OnlyRoot() {
        GenericTree<Integer> tree = new GenericTree<>(21);
        assertEquals(0, tree.height(tree.getRootNode()));
    }

    @Test
    public void nodeHeight_Should_CalculateProperly() {
        GenericTree<Integer> subTree = new GenericTree<>(6);

        GenericTree<Integer> tree = new GenericTree<>(7,
                new GenericTree<>(19,
                        new GenericTree<>(1),
                        new GenericTree<>(12),
                        new GenericTree<>(31)),
                new GenericTree<>(21),
                new GenericTree<>(14,
                        new GenericTree<>(23),
                        subTree));
        assertEquals(2, tree.height(tree.getRootNode()));

        tree.addChildToNode(subTree.getRootNode(), 100);
        assertEquals(3, tree.height(tree.getRootNode()));
    }

    // tree tests

    @Test
    public void isRoot_Should_ReturnFalse_When_PassedNodeIsNotRootNode() {
        GenericTree<Integer> child = new GenericTree<>(50);
        GenericTree<Integer> tree = new GenericTree<>(14, child);

        assertFalse(tree.isRoot(child.getRootNode()));
    }

    @Test
    public void isRoot_Should_ReturnTrue_When_PassedNodeIsRootNode() {
        GenericTree<Integer> child = new GenericTree<>(50);
        GenericTree<Integer> tree = new GenericTree<>(14, child);

        assertTrue(tree.isRoot(tree.getRootNode()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addChildToNode_Should_ThrowException_When_NotValidNodeIsPassed() {
        GenericTree<String> tree = new GenericTree<>("a");
        TestNode<String> node = new TestNode<>();
        tree.addChildToNode(node, "b");
    }

    private static class TestNode<E> implements TreeNode<E> {
        @Override
        public E getValue() {
            return null;
        }

        @Override
        public int getChildrenCount() {
            return 0;
        }

        @Override
        public List<TreeNode<E>> getChildren() {
            return null;
        }

        @Override
        public TreeNode<E> getParent() {
            return null;
        }
    }

}
