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
	 * Adds new element in the homogeneous tree.
	 * 
	 * @param value
	 *            - the value to be added to the tree
	 */
	public void insert(T value) {
		HeterogeneousTreeNode<T> node = new HeterogeneousTreeNode<T>(value);
		root.addChild(node);

	}

	/**
	 * Adds new element in the homogeneous tree.
	 * 
	 * @param index
	 *            - the index
	 * @param value
	 *            - the value to be added to the tree
	 */
	public void insert(T value, int index) {
		HeterogeneousTreeNode<T> child = new HeterogeneousTreeNode<T>(value);
		// root.addChild(node);
		// node.addChild(child);
		root.getChild(index).addChild(child);
	}

	/**
	 * Traverses tree in Depth First Search (DFS) manner.
	 * 
	 * @param root
	 *            - the root of the tree to be traversed.
	 * @param spaces
	 *            - the spaces used for representation of the parent-child relation.
	 */
	private void getDFS(HeterogeneousTreeNode<T> root, String spaces) {
		if (root == null) {
			return;
		}

		elementsAsString.append(spaces + root.getValue() + System.lineSeparator());
		HeterogeneousTreeNode<T> child = null;
		for (int i = 0; i < root.getChildren().size(); i++) {
			child = root.getChild(i);
			getDFS(child, spaces + "  ");
		}
	}

	/**
	 * @return - the tree as string in Depth First Search (DFS) manner
	 */
	public String getDFS() {
		elementsAsString.setLength(0);
		getDFS(root, new String());
		return elementsAsString.toString();
	}

}