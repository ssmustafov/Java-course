package com.sirma.itt.javacourse.ds.lists;

/**
 * Implementation of list backed with array that doubles its size when it becomes full.
 *
 * @author Sinan Mustafov
 */
public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int GROW_FACTOR = 2;

    private Object[] data;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        data = new Object[capacity];
    }

    /**
     * Adds the given value to the list. If the underlying array's capacity is full a new one with double the size is
     * created.
     *
     * @param value the value to add
     */
    public void add(E value) {
        if (size >= data.length) {
            grow();
        }

        data[size] = value;
        size++;
    }

    private void grow() {
        Object[] extended = new Object[data.length * GROW_FACTOR];
        System.arraycopy(data, 0, extended, 0, data.length);
        data = extended;
    }

    /**
     * Removes the element at the given index. It shifts the remaining elements to left in the array to avoid gaps.
     *
     * @param index the index of element to remove
     * @return the removed element
     */
    public E removeAt(int index) {
        checkBoundaries(index);

        E value = get(index);

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return value;
    }

    private void checkBoundaries(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds: " + index);
        }
    }

    public E get(int index) {
        return (E) data[index];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i < size - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
