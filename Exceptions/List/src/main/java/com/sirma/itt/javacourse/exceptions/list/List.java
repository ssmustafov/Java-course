package com.sirma.itt.javacourse.exceptions.list;

/**
 * Holds list of elements of type <code>Object</code> with fixed size.
 * 
 * @author smustafov
 */
public class List {

	private Object[] array;
	private int counter;

	/**
	 * Creates a new list with given size.
	 * 
	 * @param size
	 *            - the size of the list to be set
	 */
	public List(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The size of the list cannot be under zero");
		}

		array = new Object[size];
		counter = 0;
	}

	/**
	 * Adds new element to the list.
	 * 
	 * @param obj
	 *            - the element to be added
	 */
	public void add(Object obj) {
		if (array.length == counter) {
			throw new ListFullException();
		}

		array[counter] = obj;
		counter++;
	}

	/**
	 * Removes the last element of the list.
	 */
	public void remove() {
		if (counter == 0) {
			throw new ListEmptyException();
		}
		if (counter == array.length) {
			counter--;
		}

		if (array[counter] == null) {
			array[counter - 1] = null;
		} else {
			array[counter] = null;
		}
		counter--;
	}

	/**
	 * Returns the elements of the list.
	 * 
	 * @return - the elements of the list as string
	 */
	public String getAllElements() {
		StringBuilder result = new StringBuilder();
		result.append("[");

		for (int i = 0; i < counter - 1; i++) {
			result.append(array[i]);
			result.append(", ");
		}

		if (counter > 0) {
			result.append(array[counter - 1]);
		}

		result.append("]");

		return result.toString();
	}

	/**
	 * Returns the actual size of the list.
	 * 
	 * @return - the size of the list
	 */
	public int getListSize() {
		return counter;
	}

	/**
	 * Returns the capacity of the list.
	 * 
	 * @return - the capacity of the list
	 */
	public int getListCapacity() {
		return array.length;
	}

	/**
	 * Returns element at given index.
	 * 
	 * @param index
	 *            - the index of the element
	 * @return the object element at given index
	 */
	public Object get(int index) {
		if (index > array.length) {
			throw new ArrayIndexOutOfBoundsException("Index out of the range: " + index);
		}

		return array[index];
	}

}
