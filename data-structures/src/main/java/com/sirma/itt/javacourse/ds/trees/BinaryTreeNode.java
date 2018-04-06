package com.sirma.itt.javacourse.ds.trees;

/**
 * Represents binary tree node with left and right children.
 *
 * @param <E> type of the element value in the binary tree node
 * @author Sinan Mustafov
 */
public interface BinaryTreeNode<E> extends TreeNode<E> {

    /**
     * Returns the binary tree node of the left child for the given node.
     *
     * @return the binary tree node of the left child for the given node
     */
    BinaryTreeNode<E> getLeft();

    /**
     * Returns the binary tree node of the right child for the given node.
     *
     * @return the binary tree node of the right child for the given node
     */
    BinaryTreeNode<E> getRight();

    @Override
    BinaryTreeNode<E> getParent();

}
