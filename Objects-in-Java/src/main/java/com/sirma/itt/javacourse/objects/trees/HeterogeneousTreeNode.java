package com.sirma.itt.javacourse.objects.trees;


/**
 * Represents a node for heterogeneous tree which holds objects of type <code>Object</code>.
 * 
 * @author smustafov
 */
public class HeterogeneousTreeNode {

	public static final String NULL_ERROR_MESSAGE = "The given value is null";
	private Object value;
	private HeterogeneousTreeNode leftChild;
	private HeterogeneousTreeNode rightChild;

	/**
	 * Creates a heterogeneous tree node.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HeterogeneousTreeNode(Object value) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}

		this.value = value;
	}

	/**
	 * @return - the value of the node
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @return - the left child of the node
	 */
	public HeterogeneousTreeNode getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child of the node.
	 * 
	 * @param child
	 *            - the child to be set
	 */
	public void setLeftChild(HeterogeneousTreeNode child) {
		leftChild = child;
	}

	/**
	 * @return - the right child of the node
	 */
	public HeterogeneousTreeNode getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child of the node.
	 * 
	 * @param child
	 *            - the child to be set
	 */
	public void setRightChild(HeterogeneousTreeNode child) {
		rightChild = child;
	}

}
