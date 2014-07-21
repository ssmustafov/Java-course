package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a binary tree.
 * 
 * @author smustafov
 */
public class BinaryTree {

	private BinaryTreeNode<Integer> root;
	private final StringBuilder elementsAsString = new StringBuilder();

	/**
	 * Checks if the binary tree contains given element.
	 * 
	 * @param value
	 *            - the value to be check if it exists in the binary tree
	 * @return - true if the value exists in the tree or false if it does not exists in the tree
	 */
	public boolean doesElementExists(int value) {
		String[] elementsAsString = getInOrderSort().split(" ");
		for (int i = 0; i < elementsAsString.length; i++) {
			if (elementsAsString[i].equals(Integer.toString(value))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the right place in the binary tree to add a new node.
	 * 
	 * @param latestRoot
	 *            - the latest root in the binary tree
	 * @param node
	 *            - the new node to be added to the binary tree
	 */
	private void insert(BinaryTreeNode<Integer> latestRoot, BinaryTreeNode<Integer> node) {
		if (latestRoot.getValue() > node.getValue()) {
			if (latestRoot.getLeftChild() == null) {
				latestRoot.setLeftChild(node);
			} else {
				insert(latestRoot.getLeftChild(), node);
			}
		} else {
			if (latestRoot.getRightChild() == null) {
				latestRoot.setRightChild(node);
			} else {
				insert(latestRoot.getRightChild(), node);
			}
		}
	}

	/**
	 * Adds new element in the binary tree.
	 * 
	 * @param value
	 *            - the value of the node to be added to the tree
	 */
	public void insert(int value) {
		if (doesElementExists(value)) {
			throw new IllegalArgumentException("The value '" + value
					+ "' exists in the binary tree");
		}

		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(value);
		if (root == null) {
			root = node;
		} else {
			insert(root, node);
		}
	}

	/**
	 * Sorts the elements in the binary tree by in-order manner.
	 * 
	 * @param root
	 *            - the root of the binary tree
	 */
	private void inOrderSort(BinaryTreeNode<Integer> root) {
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
	private void preOrderSort(BinaryTreeNode<Integer> root) {
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
	private void postOrderSort(BinaryTreeNode<Integer> root) {
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
