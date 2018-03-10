package com.sirma.itt.javacourse.ds.lists;

import java.util.function.Consumer;

/**
 * Doubly linked list implementation. In order to avoid some special cases when operating near the boundaries of the
 * doubly linked list, two special nodes are used: header node at the beginning of the list and a trailer node at the
 * end of the list. These nodes are called sentinels or guards, and they do not store any elements.
 * Operations return null if list is empty.
 * <p>
 * Supported operations:
 * <ul>
 * <li>addFirst - adds element to the head of the list</li>
 * <li>addLast - adds element to the tail of the list</li>
 * <li>removeFirst - removes the head element</li>
 * <li>removeLast - removes the tail element</li>
 * <li>first - returns the element in the head</li>
 * <li>last - returns the element in the tail</li>
 * </ul>
 * <p>
 * The slight extra memory devoted to the sentinels greatly simplifies the logic for the operations. The header and
 * the trailer nodes never change, only the nodes between them change. This way every element is guaranteed to be stored
 * in a node that has neighbours on each side.
 *
 * @param <E> type of the elements in the list
 * @author Sinan Mustafov
 * @implNote all methods have constant - O(1) complexity, except the forEach and toString methods, which have
 * linear - O(n) complexity.
 * <p>
 * This implementation is not synchronized.
 */
public class DoublyLinkedList<E> {

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    /**
     * Creates new empty doubly linked list.
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    /**
     * Adds element to the head of the list
     *
     * @param element the element to add
     */
    public void addFirst(E element) {
        addBetween(element, header, header.next);
    }

    /**
     * Adds element to the tail of the list
     *
     * @param element the element to add
     */
    public void addLast(E element) {
        addBetween(element, trailer.prev, trailer);
    }

    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(element, predecessor, successor);
        predecessor.next = node;
        successor.prev = node;
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
        return removeNode(header.next);
    }

    /**
     * Removes and returns the tail element of the list
     *
     * @return the tail element of the list
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return removeNode(trailer.prev);
    }

    private E removeNode(Node<E> node) {
        Node<E> predecessor = node.prev;
        Node<E> successor = node.next;
        predecessor.next = successor;
        successor.prev = predecessor;
        size--;
        return node.element;
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
        return header.next.element;
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
        return trailer.prev.element;
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
        Node<E> current = header.next;
        while (current != trailer) {
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

    /**
     * Represents one node of the doubly linked list.
     *
     * @param <E> type of the element of the node
     */
    private static class Node<E> {
        // the data value stored in this node
        E element;

        // reference to the previous node
        Node<E> prev;

        // reference to the next node
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

    }

}
