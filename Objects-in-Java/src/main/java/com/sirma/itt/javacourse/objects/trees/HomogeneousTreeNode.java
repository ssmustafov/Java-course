package com.sirma.itt.javacourse.objects.trees;

import java.util.ArrayList;

/**
 * Represents a homogeneous tree node.
 * 
 * @param <T>
 *            - the type of the values in the node
 * @author smustafov
 */
public class HomogeneousTreeNode<T> {

	private T value;
	private ArrayList<HomogeneousTreeNode<T>> children;
	private boolean hasParent;

	/**
	 * Creates a homogeneous tree node.
	 * 
	 * @param value
	 *            - the value of the node
	 */
	public HomogeneousTreeNode(T value) {
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
	public void addChild(HomogeneousTreeNode<T> child) {
		if (child == null) {
			throw new IllegalArgumentException("The given value is null");
		}
		if (child.hasParent) {
			throw new IllegalArgumentException("The node already has a parent");
		}

		child.hasParent = true;
		this.children.add(child);
	}

	/**
	 * @return - the children of the node.
	 */
	public ArrayList<HomogeneousTreeNode<T>> getChildren() {
		return this.children;
	}

	/**
	 * Gets the child of the node at given index.
	 * 
	 * @param index
	 *            - the index of the desired child.
	 * @return the child on the given position.
	 */
	public HomogeneousTreeNode<T> getChild(int index) {
		return this.children.get(index);
	}

}
