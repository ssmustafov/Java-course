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

		if (children == null) {
			children = new ArrayList<HeterogeneousTreeNode<T>>();
		}
		this.children.add(child);
	}

	/**
	 * @return - the children of the node.
	 */
	public ArrayList<HeterogeneousTreeNode<T>> getChildren() {
		if (children == null) {
			return new ArrayList<HeterogeneousTreeNode<T>>();
		}
		return children;
	}

	/**
	 * Inserts a node at specified position in the child list.
	 * 
	 * @param index
	 *            - the position to insert at
	 * @param child
	 *            - the node to insert
	 */
	public void insertChildAt(int index, HeterogeneousTreeNode<T> child) {
		children.add(index, child);
	}

	/**
	 * Removes a child from the node at given index.
	 * 
	 * @param index
	 *            - the position of the child to be removed
	 */
	public void removeChildAt(int index) {
		children.remove(index);
	}

	/**
	 * @return - number of children in the node
	 */
	public int getChildrenCount() {
		if (children == null) {
			return 0;
		}
		return children.size();
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