package com.sirma.itt.javacourse.objects.trees;


/**
 * Represents heterogeneous tree which holds objects of type <code>Object</code>.
 * 
 * @author smustafov
 */
public class HeterogeneousTree {

	private HeterogeneousTreeNode root;
	private StringBuilder elementsAsString = new StringBuilder();

	/**
	 * Default constructor.
	 */
	public HeterogeneousTree() {

	}

	/**
	 * Creates heterogeneous tree.
	 * 
	 * @param root
	 *            - the root of the heterogeneous tree to be set
	 */
	public HeterogeneousTree(Object root) {
		if (root == null) {
			throw new IllegalArgumentException(HeterogeneousTreeNode.NULL_ERROR_MESSAGE);
		}

		this.root = new HeterogeneousTreeNode(root);
	}

	/**
	 * Sets the root of the tree.
	 * 
	 * @param root
	 *            - the root to be set to the tree
	 */
	public void setRoot(HeterogeneousTreeNode root) {
		this.root = root;
	}

	/**
	 * Returns the root node of the tree.
	 * 
	 * @return - the root of the tree
	 */
	public HeterogeneousTreeNode getRoot() {
		return root;
	}

	/**
	 * Adds new element in the heterogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 * @param node
	 *            - the recursive node
	 */
	private void insert(Object value, HeterogeneousTreeNode node) {
		HeterogeneousTreeNode currentNode = node;

		if (currentNode.getValue().hashCode() < value.hashCode()) {
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(new HeterogeneousTreeNode(value));
			} else {
				insert(value, currentNode.getRightChild());
			}
		} else {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(new HeterogeneousTreeNode(value));
			} else {
				insert(value, currentNode.getLeftChild());
			}
		}
	}

	/**
	 * Adds new element in the heterogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 */
	public void insert(Object value) {
		if (root == null) {
			setRoot(new HeterogeneousTreeNode(value));
			return;
		}
		insert(value, root);
	}

	/**
	 * Sorts the elements in the binary tree by in-order manner.
	 * 
	 * @param root
	 *            - the root of the binary tree
	 */
	private void inOrderSort(HeterogeneousTreeNode root) {
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
	private void preOrderSort(HeterogeneousTreeNode root) {
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
	private void postOrderSort(HeterogeneousTreeNode root) {
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
