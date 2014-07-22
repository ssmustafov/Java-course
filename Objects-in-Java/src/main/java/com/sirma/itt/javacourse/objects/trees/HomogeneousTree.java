package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents a homogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the tree
 * @author smustafov
 */
public class HomogeneousTree<T> {

	private HomogeneousTreeNode<T> root;
	private StringBuilder elementsAsString = new StringBuilder();

	/**
	 * @return - the root
	 */
	public HomogeneousTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Checks if the homogeneous tree contains given element.
	 * 
	 * @param value
	 *            - the value to be check if it exists in the homogeneous tree
	 * @return - true if the value exists in the tree or false if it does not exists in the tree
	 */
	public boolean doesElementExists(T value) {
		HomogeneousTreeNode<T> node = root;
		while (node != null) {
			String valueAsString = value.toString();
			String nodeAsString = node.getValue().toString();
			if (valueAsString.compareTo(nodeAsString) == 0) {
				return true;
			} else if (valueAsString.compareTo(nodeAsString) < 0) {
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}

		return false;
	}

	/**
	 * Finds the right place to add a new node in the binary tree.
	 * 
	 * @param latestRoot
	 *            - the latest root in the binary tree
	 * @param node
	 *            - the new node to be added to the binary tree
	 */
	private void insert(HomogeneousTreeNode<T> latestRoot, HomogeneousTreeNode<T> node) {
		String latestRootAsString = latestRoot.getValue().toString();
		String nodeAsString = node.getValue().toString();
		if (latestRootAsString.compareTo(nodeAsString) > 0) {
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
	public void insert(T value) {
		if (doesElementExists(value)) {
			throw new IllegalArgumentException("The value '" + value
					+ "' exists in the binary tree");
		}

		HomogeneousTreeNode<T> node = new HomogeneousTreeNode<T>(value);
		if (root == null) {
			root = node;
		} else {
			insert(root, node);
		}
	}

	/**
	 * Traverses the tree.
	 * 
	 * @param node
	 *            - the node
	 */
	private void traverse(HomogeneousTreeNode<T> node) {
		if (node == null) {
			return;
		}

		traverse(node.getLeftChild());
		elementsAsString.append(node.getValue() + " ");
		traverse(node.getRightChild());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		elementsAsString.setLength(0);
		traverse(root);
		return elementsAsString.toString();
	}

}
