package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a homogeneous tree node.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class HomogeneousTreeNode<T> {

	private static final String NULL_VALUE_ERROR_MESSAGE = "The given value is null";
	private T value;
	private HomogeneousTreeNode<T> leftChild;
	private HomogeneousTreeNode<T> rightChild;

	/**
	 * Creates a homogeneous tree node.
	 * 
	 * @param value
	 *            - the value of the node
	 * @param leftChild
	 *            - the left child of the node
	 * @param rightChild
	 *            - the right child of the node
	 */
	public HomogeneousTreeNode(T value, HomogeneousTreeNode<T> leftChild, HomogeneousTreeNode<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_VALUE_ERROR_MESSAGE);
		}

		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	/**
	 * Creates a homogeneous tree node without any children.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HomogeneousTreeNode(T value) {
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
	public HomogeneousTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param value
	 *            - the value of the left child to be set
	 */
	public void setLeftChild(HomogeneousTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_VALUE_ERROR_MESSAGE);
		}

		this.leftChild = value;
	}

	/**
	 * @return - the right child of the node
	 */
	public HomogeneousTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param value
	 *            - the value of the right child to be set
	 */
	public void setRightChild(HomogeneousTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_VALUE_ERROR_MESSAGE);
		}

		this.rightChild = value;
	}

}
