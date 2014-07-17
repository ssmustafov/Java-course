package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents heterogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the tree
 * @author smustafov
 */
public class HeterogeneousTree<T> {

	private HeterogeneousTreeNode<T> root;
	private StringBuilder elementsAsString = new StringBuilder();

	/**
	 * Default constructor.
	 */
	public HeterogeneousTree() {

	}

	/**
	 * Creates homogeneous tree.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HeterogeneousTree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		root = new HeterogeneousTreeNode<T>(value);
	}

	/**
	 * Sets the root of the tree.
	 * 
	 * @param root
	 *            - the root to be set to the tree
	 */
	public void setRoot(HeterogeneousTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Adds new element in the homogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 * @param node
	 *            - the node
	 */
	private void insert(T value, HeterogeneousTreeNode<T> node) {
		HeterogeneousTreeNode<T> currentNode = node;

		if (currentNode.getValue().hashCode() < value.hashCode()) {
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(new HeterogeneousTreeNode<T>(value));
			} else {
				insert(value, currentNode.getRightChild());
			}
		} else {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(new HeterogeneousTreeNode<T>(value));
			} else {
				insert(value, currentNode.getLeftChild());
			}
		}
	}

	/**
	 * Adds new element in the homogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 */
	public void insert(T value) {
		if (root == null) {
			setRoot(new HeterogeneousTreeNode<T>(value));
			return;
		}
		insert(value, root);
	}

	/**
	 * Returns the root node of the tree.
	 * 
	 * @return - the root of the tree
	 */
	public HeterogeneousTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Sorts the elements in the binary tree by in-order manner.
	 * 
	 * @param root
	 *            - the root of the binary tree
	 */
	private void inOrderSort(HeterogeneousTreeNode<T> root) {
		if (root == null) {
			return;
		}

		inOrderSort(root.getLeftChild());
		this.elementsAsString.append(root.getValue() + " ");
		inOrderSort(root.getRightChild());
	}

	/**
	 * Returns the elements of the binary tree sorted by in-order manner.
	 * 
	 * @return - the elements in the binary tree
	 */
	public String getInOrderSort() {
		this.elementsAsString.setLength(0);
		inOrderSort(root);
		return elementsAsString.toString();
	}

	/**
	 * Sorts the elements in the binary tree by pre-order manner.
	 * 
	 * @param root
	 *            - the root of the binary tree
	 */
	private void preOrderSort(HeterogeneousTreeNode<T> root) {
		if (root == null) {
			return;
		}

		this.elementsAsString.append(root.getValue() + " ");
		preOrderSort(root.getLeftChild());
		preOrderSort(root.getRightChild());
	}

	/**
	 * Returns the elements of the binary tree sorted by pre-order manner.
	 * 
	 * @return - the elements in the binary tree
	 */
	public String getPreOrderSort() {
		this.elementsAsString.setLength(0);
		preOrderSort(root);
		return elementsAsString.toString();
	}

	/**
	 * Sorts the elements in the binary tree by post-order manner.
	 * 
	 * @param root
	 *            - the root of the binary tree
	 */
	private void postOrderSort(HeterogeneousTreeNode<T> root) {
		if (root == null) {
			return;
		}

		postOrderSort(root.getLeftChild());
		postOrderSort(root.getRightChild());
		this.elementsAsString.append(root.getValue() + " ");
	}

	/**
	 * Returns the elements of the binary tree sorted by post-order manner.
	 * 
	 * @return - the elements in the binary tree
	 */
	public String getPostOrderSort() {
		this.elementsAsString.setLength(0);
		postOrderSort(root);
		return elementsAsString.toString();
	}

}