package com.sirma.itt.javacourse.ds.lists;

import java.util.function.Consumer;

/**
 * Singly linked list implementation. Keeps reference to head and tail of the list. On empty list operations return null.
 * <p>
 * Supported operations:
 * <ul>
 * <li>addFirst - adds element to the head of the list</li>
 * <li>addLast - adds element to the tail of the list</li>
 * <li>removeFirst - removes the head element</li>
 * <li>first - returns the element in the head</li>
 * <li>last - returns the element in the tail</li>
 * </ul>
 * <p>
 * Removing the last element from the list is not supported, because with singly linked list, we cannot delete the last
 * node in a fast manner. Such operation would take N steps - O(n), where N is the size of the list. If such operation is desired,
 * more efficient approach would be to use doubly linked list, where it would take constant time O(1).
 *
 * @param <E> type of the elements in the list
 * @author Sinan Mustafov
 * @implNote all methods have constant - O(1) complexity, except the forEach and toString methods, which have
 * linear - O(n) complexity.
 * <p>
 * This implementation is not synchronized.
 */
public class SinglyLinkedList<E> implements Cloneable {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Adds element to the head of the list
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    /**
     * Adds element to the tail of the list
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        Node<E> node = new Node<>(e, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
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

        E e = head.element;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return e;
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
        return head.element;
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
        Node<E> current = head;
        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        forEach(e -> builder.append(e).append(" "));

        // remove one space at the end
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof SinglyLinkedList) {
            SinglyLinkedList<?> otherList = (SinglyLinkedList<?>) obj;
            if (size != otherList.size) {
                return false;
            }

            Node<?> e1 = head;
            Node<?> e2 = otherList.head;
            while (e1 != null) {
                if (!e1.element.equals(e2.element)) {
                    return false;
                }
                e1 = e1.next;
                e2 = e2.next;
            }
            return true;
        }

        return false;
    }

    @Override
    public SinglyLinkedList<E> clone() {
        try {
            SinglyLinkedList<E> cloned = (SinglyLinkedList<E>) super.clone();

            if (size > 0) {
                cloned.head = new Node<>(head.element, null);
                Node<E> walk = head.next;
                Node<E> clonedTail = cloned.head;

                while (walk != null) {
                    Node<E> node = new Node<>(walk.element, null);
                    clonedTail.next = node;
                    clonedTail = node;
                    walk = walk.next;
                }
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            // should not reach here, because the class is cloneable
            throw new InternalError(e);
        }
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

