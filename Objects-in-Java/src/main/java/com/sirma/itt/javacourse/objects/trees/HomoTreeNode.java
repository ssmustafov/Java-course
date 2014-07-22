package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a homogeneous tree node.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class HomoTreeNode<T> {

	private T value;
	private HomoTreeNode<T> leftChild;
	private HomoTreeNode<T> rightChild;

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
	public HomoTreeNode(T value, HomoTreeNode<T> leftChild,
			HomoTreeNode<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
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
	public HomoTreeNode(T value) {
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
	public HomoTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param value
	 *            - the value of the left child to be set
	 */
	public void setLeftChild(HomoTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.leftChild = value;
	}

	/**
	 * @return - the right child of the node
	 */
	public HomoTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param value
	 *            - the value of the right child to be set
	 */
	public void setRightChild(HomoTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.rightChild = value;
	}

}
