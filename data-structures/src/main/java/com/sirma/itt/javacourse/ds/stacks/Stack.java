package com.sirma.itt.javacourse.ds.stacks;

/**
 * Represents last-in first-out (LIFO) collection of objects.
 *
 * @param <E> type of the objects in the stack
 * @author Sinan Mustafov
 */
public interface Stack<E> {

    /**
     * Pushes element at the top of the stack.
     *
     * @param element the element to be inserted at the top
     */
    void push(E element);

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at top of the stack or null if its empty
     */
    E pop();

    /**
     * Returns, but does not remove the element at the top of the stack.
     *
     * @return the element at the top of the stack or null if empty
     */
    E top();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     *
     * @return true if the stack is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

}
