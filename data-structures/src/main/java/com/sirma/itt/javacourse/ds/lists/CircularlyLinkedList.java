package com.sirma.itt.javacourse.ds.lists;

import java.util.function.Consumer;

/**
 * Circularly linked list, which is essentially a singly linked list in which the next reference of tail node points to
 * the head of the list, rather than to null. Operations return null if list is empty.
 * <p>
 * Supported operations:
 * <ul>
 * <li>addFirst - adds element to the head of the list</li>
 * <li>addLast - adds element to the tail of the list</li>
 * <li>removeFirst - removes the head element</li>
 * <li>first - returns the element in the head</li>
 * <li>last - returns the element in the tail</li>
 * <li>rotate - moves the first element to the end of the list</li>
 * </ul>
 * <p>
 * Removing the last element from the list is not supported, because with singly linked list, we cannot delete the last
 * node in a fast manner. Such operation would take N steps - O(n), where N is the size of the list. If such operation is desired,
 * more efficient approach would be to use doubly linked list, where it would take constant time O(1).
 * <p>
 * The rotate operation provides efficient way - O(1), to 'circle' the list, because in some situations using removeFirst method
 * and addLast could be inefficient. For example the Round-Robin Scheduling algorithm.
 * <p>
 * For additional optimization only reference to the tail node is kept, without the head. So long as we keep a reference
 * to the tail node, we can locate the head as tail.next. It makes the code simpler and a bit more efficient.
 *
 * @param <E> type of the elements in the list
 * @author Sinan Mustafov
 * @implNote all methods have constant - O(1) complexity, except the forEach and toString methods, which have
 * linear - O(n) complexity.
 * <p>
 * This implementation is not synchronized.
 */
public class CircularlyLinkedList<E> {

    private Node<E> tail;
    private int size;

    /**
     * Adds element to the head of the list
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.next = tail; // link to itself
        } else {
            Node<E> node = new Node<>(e, tail.next);
            tail.next = node;
        }
        size++;
    }

    /**
     * Adds element to the tail of the list
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        addFirst(e);
        tail = tail.next;
    }

    /**
     * Removes and returns the head element from the list
     *
     * @return the head element of the list
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> head = tail.next;
        if (head == tail) {
            // remove the last node
            tail = null;
        } else {
            tail.next = head.next;
        }

        size--;
        return head.element;
    }

    /**
     * Moves the first element to the end of the list if the list is not empty.
     */
    public void rotate() {
        if (!isEmpty()) {
            // the head becomes the new tail
            tail = tail.next;
        }
    }

    /**
     * Returns (does not remove) the head element of the list
     *
     * @return the head element of the list
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        // the head is after the tail
        return tail.next.element;
    }

    /**
     * Returns (does not remove) the tail element of the list
     *
     * @return the tail element of the list
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.element;
    }

    /**
     * Returns whether the list is empty or not.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Traverses each element in the list and applies the given consumer function on each.
     *
     * @param consumer function to apply to every element in the list
     */
    public void forEach(Consumer<E> consumer) {
        if (!isEmpty()) {
            Node<E> current = tail;
            do {
                current = current.next;
                consumer.accept(current.element);
            } while (current != tail);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }

        StringBuilder builder = new StringBuilder();

        forEach(e -> builder.append(e).append(" "));
        // remove one space at the end
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    /**
     * Represents one node of the singly linked list.
     *
     * @param <E> type of the element of the node
     */
    private static class Node<E> {
        // data value
        E element;

        // the next node linked to this one
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

}
