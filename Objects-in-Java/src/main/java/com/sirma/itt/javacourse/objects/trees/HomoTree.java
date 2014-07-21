package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents homogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the tree
 * @author smustafov
 */
public class HomoTree<T> {

	private HomoTreeNode<T> root;

	/**
	 * @return - the root
	 */
	public HomoTreeNode<T> getRoot() {
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
		HomoTreeNode<T> node = root;
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
	 * Finds the right place in the binary tree to add a new node.
	 * 
	 * @param latestRoot
	 *            - the latest root in the binary tree
	 * @param node
	 *            - the new node to be added to the binary tree
	 */
	private void insert(HomoTreeNode<T> latestRoot, HomoTreeNode<T> node) {
		if (latestRoot.getValue().toString().compareTo(node.getValue().toString()) > 0) {
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

		HomoTreeNode<T> node = new HomoTreeNode<T>(value);
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
	public void traverse(HomoTreeNode<T> node) {
		if (node == null) {
			return;
		}

		System.out.println(node.getValue());
		traverse(node.getLeftChild());
		traverse(node.getRightChild());
	}

}
