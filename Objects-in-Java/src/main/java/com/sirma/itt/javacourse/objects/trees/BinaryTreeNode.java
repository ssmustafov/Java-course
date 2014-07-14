package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a binary tree node.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class BinaryTreeNode<T> {

	private T value;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;

	/**
	 * Creates a binary tree node with left and right child.
	 * 
	 * @param value
	 *            - the value of the node
	 * @param leftChild
	 *            - the left child of the node
	 * @param rightChild
	 *            - the right child of the node
	 */
	public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	/**
	 * Creates a binary tree node without any children.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public BinaryTreeNode(T value) {
		this(value, null, null);
	}

	/**
	 * @return - the value of the node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * @return - the left child of the node
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param value
	 *            - the value of the left child to be set
	 */
	public void setLeftChild(BinaryTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.leftChild = value;
	}

	/**
	 * @return - the right child of the node
	 */
	public BinaryTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param value
	 *            - the value of the right child to be set
	 */
	public void setRightChild(BinaryTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.rightChild = value;
	}

}
