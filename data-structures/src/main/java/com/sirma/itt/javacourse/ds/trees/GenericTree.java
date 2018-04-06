package com.sirma.itt.javacourse.ds.trees;

import java.util.*;

/**
 * Implementation of generic tree. Each node can have one parent and list of children.
 *
 * @author sinan
 * @implNote the implementation is divided into two classes - GenericTree which is the tree itself and internal
 * TreeNode which represents a node in the tree. This way functionalities are logically separated. Creating node,
 * adding children to a node and etc are realized in the TreeNode class. Functionalities related to the tree are in the
 * GenericTree class.
 */
public class GenericTree<E> {

    private Node<E> root;

    public GenericTree(E rootValue) {
        root = new Node<>(rootValue);
    }

    public GenericTree(E rootValue, GenericTree<E>... children) {
        this(rootValue);

        for (GenericTree<E> child : children) {
            root.addChild(child.root, root);
        }
    }

    // tree node methods

    public TreeNode<E> getRoot() {
        return root;
    }

    public boolean isRoot(TreeNode<E> node) {
        return root == node;
    }

    /**
     * Adds value as child to the given node.
     *
     * @param node       the node that a child will be added to
     * @param childValue the value of the child node
     */
    public void addChildToNode(TreeNode<E> node, E childValue) {
        Objects.requireNonNull(node);
        if (!(node instanceof Node)) {
            throw new IllegalArgumentException("Not valid node");
        }

        Node<E> internalNode = (Node<E>) node;
        internalNode.addChild(new Node<>(childValue), internalNode);
    }

    /**
     * Returns the height of the subtree for the given node. Meaning the max depth within all nodes.
     *
     * @param node the node
     * @return the height of the subtree for the given node
     * @implNote the algorithm is recursive and progresses in a top-down fashion, if the method is called with the root,
     * it will be called once for each node in the tree. The complexity of this algorithm is O(n).
     * The another approach for implementing this is to actually calculate the depth per node, but this will cost quadratic
     * worst case time - O(n^2)
     */
    public int height(TreeNode<E> node) {
        int height = 0;
        for (TreeNode<E> child : node.getChildren()) {
            height = Math.max(height, 1 + height(child));
        }
        return height;
    }

    private static class Node<E> implements TreeNode<E> {
        E value;
        TreeNode<E> parent;
        List<Node<E>> children = new ArrayList<>();

        Node(E value) {
            Objects.requireNonNull(value);
            this.value = value;
        }

        void addChild(Node<E> child, Node<E> parent) {
            if (child.parent != null) {
                throw new IllegalArgumentException("The child already has parent");
            }

            child.parent = parent;
            children.add(child);
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public int getChildrenCount() {
            return children.size();
        }

        @Override
        public List<TreeNode<E>> getChildren() {
            return Collections.unmodifiableList(children);
        }

        @Override
        public TreeNode<E> getParent() {
            return parent;
        }
    }

}
