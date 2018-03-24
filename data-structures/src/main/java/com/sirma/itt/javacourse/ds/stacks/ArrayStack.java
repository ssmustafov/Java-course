package com.sirma.itt.javacourse.ds.stacks;

/**
 * @author Sinan Mustafov
 */
public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 32;

    private E[] data;
    private int size;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (size == data.length) {
            throw new IllegalStateException("Stack is full");
        }

        data[size] = element;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E element = data[size - 1];
        data[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

}
