package com.sirma.itt.javacourse.ds.queues;

/**
 * Queue implementation with circular array.
 *
 * @author Sinan Mustafov
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 32;

    private E[] data;
    private int frontIndex;
    private int size;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        int pos = (frontIndex + size) % data.length;
        data[pos] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E element = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[frontIndex];
    }

    @Override
    public int size() {
        return size;
    }

}
