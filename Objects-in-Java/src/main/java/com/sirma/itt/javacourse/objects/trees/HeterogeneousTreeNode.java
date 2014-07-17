package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a node for heterogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class HeterogeneousTreeNode<T> {

	private T value;
	private HeterogeneousTreeNode<T> leftChild;
	private HeterogeneousTreeNode<T> rightChild;

	/**
	 * Creates a homogeneous tree node.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HeterogeneousTreeNode(T value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.value = value;
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
	public HeterogeneousTreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param child
	 *            - the child to be set
	 */
	public void setLeftChild(HeterogeneousTreeNode<T> child) {
		leftChild = child;
	}

	/**
	 * @return - the right child of the node
	 */
	public HeterogeneousTreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param child
	 *            - the child to be set
	 */
	public void setRightChild(HeterogeneousTreeNode<T> child) {
		rightChild = child;
	}

}