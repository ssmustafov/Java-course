package com.sirma.itt.javacourse.ds.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of binary tree. Each node can have one parent, left and right child nodes.
 *
 * @author Sinan Mustafov
 */
public class BinaryTree<E> {

    private Node<E> root;

    public BinaryTree() {
    }

    public BinaryTree(E value) {
        addRoot(value);
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        Node<E> leftChild = left != null ? left.root : null;
        Node<E> rightChild = right != null ? right.root : null;

        root = new Node<>(value, null, leftChild, rightChild);
    }

    public BinaryTreeNode<E> addRoot(E value) {
        if (root != null) {
            throw new IllegalStateException("Binary tree is not empty");
        }

        root = new Node<>(value);
        return root;
    }

    public BinaryTreeNode<E> addLeft(BinaryTreeNode<E> parent, E value) {
        checkRootInit();

        Node<E> parentNode = validate(parent);
        if (parentNode.left != null) {
            throw new IllegalStateException("Binary tree node already has left child");
        }

        Node<E> child = new Node<>(value, parentNode);
        parentNode.left = child;
        return child;
    }

    public BinaryTreeNode<E> addRight(BinaryTreeNode<E> parent, E value) {
        checkRootInit();

        Node<E> parentNode = validate(parent);
        if (parentNode.right != null) {
            throw new IllegalStateException("Binary tree node already has right child");
        }

        Node<E> child = new Node<>(value, parentNode);
        parentNode.right = child;
        return child;
    }

    private void checkRootInit() {
        if (root == null) {
            throw new IllegalStateException("Binary tree has no root node initialized");
        }
    }

    private Node<E> validate(BinaryTreeNode<E> node) {
        if (!(node instanceof Node)) {
            throw new IllegalArgumentException("Not valid binary tree node");
        }
        return (Node<E>) node;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    private static class Node<E> implements BinaryTreeNode<E> {
        private E value;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this(value, null, null, null);
        }

        public Node(E value, Node<E> parent) {
            this(value, parent, null, null);
        }

        public Node(E value, Node<E> parent, Node<E> left, Node<E> right) {
            Objects.requireNonNull(value);

            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public BinaryTreeNode<E> getLeft() {
            return left;
        }

        @Override
        public BinaryTreeNode<E> getRight() {
            return right;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public int getChildrenCount() {
            int count = 0;
            if (left != null) {
                count++;
            }
            if (right != null) {
                count++;
            }
            return count;
        }

        @Override
        public List<BinaryTreeNode<E>> getChildren() {
            List<BinaryTreeNode<E>> children = new ArrayList<>(2);
            if (left != null) {
                children.add(left);
            }
            if (right != null) {
                children.add(right);
            }
            return Collections.unmodifiableList(children);
        }

        @Override
        public BinaryTreeNode<E> getParent() {
            return parent;
        }
    }

}
