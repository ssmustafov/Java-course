package com.sirma.itt.javacourse.ds.queues;

import com.sirma.itt.javacourse.ds.lists.SinglyLinkedList;

/**
 * Queue implementation with singly linked list.
 *
 * @author Sinan Mustafov
 */
public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public int size() {
        return list.size();
    }

}
