package com.sirma.itt.javacourse.ds.queues;

/**
 * Represents first-in first-ou (FIFO) collection of objects.
 *
 * @param <E> type of the objects in the queue
 * @author Sinan Mustafov
 */
public interface Queue<E> {

    /**
     * Adds element at the end of the queue.
     *
     * @param element the element to be added
     */
    void enqueue(E element);

    /**
     * Removes and returns the first element in the queue.
     *
     * @return the first element in the queue
     */
    E dequeue();

    /**
     * Returns, but does not remove the first element in the queue.
     *
     * @return the first element in the queue or null if its empty
     */
    E first();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    int size();

    /**
     * Returns whether the queue is empty or not.
     *
     * @return true if the queue is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

}
