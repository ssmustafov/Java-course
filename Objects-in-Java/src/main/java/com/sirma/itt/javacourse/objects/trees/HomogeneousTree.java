package com.sirma.itt.javacourse.objects.trees;

/**
 * Represents homogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the tree
 * @author smustafov
 */
public class HomogeneousTree<T> {

	private HomogeneousTreeNode<T> root;
	private StringBuilder elementsAsString = new StringBuilder();

	/**
	 * Creates tree.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HomogeneousTree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.root = new HomogeneousTreeNode<T>(value);
	}

	/**
	 * Adds new element in the homogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 */
	public void insert(T value) {
		HomogeneousTreeNode<T> node = new HomogeneousTreeNode<T>(value);
		if (root == null) {
			root = node;
		} else {
			this.root.addChild(node);
		}
	}

	/**
	 * Traverses tree in Depth First Search (DFS) manner.
	 * 
	 * @param root
	 *            - the root of the tree to be traversed.
	 * @param spaces
	 *            - the spaces used for representation of the parent-child relation.
	 */
	private void getDFS(HomogeneousTreeNode<T> root, String spaces) {
		if (root == null) {
			return;
		}

		this.elementsAsString.append(spaces + root.getValue() + System.lineSeparator());
		HomogeneousTreeNode<T> child = null;
		for (int i = 0; i < root.getChildren().size(); i++) {
			child = root.getChild(i);
			getDFS(child, spaces + "  ");
		}
	}

	/**
	 * @return - the tree as string in Depth First Search (DFS) manner
	 */
	public String getDFS() {
		this.elementsAsString.setLength(0);
		this.getDFS(this.root, new String());
		return this.elementsAsString.toString();
	}
}
