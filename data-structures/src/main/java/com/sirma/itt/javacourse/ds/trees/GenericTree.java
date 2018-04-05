package com.sirma.itt.javacourse.ds.trees;

import java.util.*;

/**
 * Implementation of generic tree. Each node can have one parent and list of children.
 *
 * @author sinan
 */
public class GenericTree<E> {

    private Node<E> root;

    public GenericTree(E rootValue) {
        root = new Node<>(rootValue);
    }

    public GenericTree(E rootValue, GenericTree<E>... children) {
        this(rootValue);

        for (GenericTree<E> child : children) {
            root.addChild(child.root);
        }
    }

    public E getRoot() {
        if (root != null) {
            return root.value;
        }
        return null;
    }

    // tree node methods

    public TreeNode<E> getRootNode() {
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
        internalNode.addChild(new Node<>(childValue));
    }

    private static class Node<E> implements TreeNode<E> {
        E value;

        boolean hasParent;

        List<Node<E>> children = new ArrayList<>();

        Node(E value) {
            Objects.requireNonNull(value);
            this.value = value;
        }

        void addChild(Node<E> child) {
            if (child.hasParent) {
                throw new IllegalArgumentException("The node already has parent");
            }

            child.hasParent = true;
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
    }

}
