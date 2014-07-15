package com.sirma.itt.javacourse.objects.trees;

import java.util.ArrayList;

/**
 * Represents a node for heterogeneous tree.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class HeterogeneousTreeNode<T> {

	private T value;
	private ArrayList<HeterogeneousTreeNode<T>> children;

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
		this.children = new ArrayList<>();
	}

	/**
	 * @return - the value of the node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Adds new child to the node.
	 * 
	 * @param child
	 *            - the child to be added
	 */
	public void addChild(HeterogeneousTreeNode<T> child) {
		if (child == null) {
			throw new IllegalArgumentException("The given value is null");
		}

		this.children.add(child);
	}

	/**
	 * @return - the children of the node.
	 */
	public ArrayList<HeterogeneousTreeNode<T>> getChildren() {
		return this.children;
	}

	/**
	 * Gets the child of the node at given index.
	 * 
	 * @param index
	 *            - the index of the desired child.
	 * @return the child on the given position.
	 */
	public HeterogeneousTreeNode<T> getChild(int index) {
		return this.children.get(index);
	}

}
