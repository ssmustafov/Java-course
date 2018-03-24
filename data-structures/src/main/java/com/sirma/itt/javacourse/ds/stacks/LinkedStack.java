package com.sirma.itt.javacourse.ds.stacks;

import com.sirma.itt.javacourse.ds.lists.SinglyLinkedList;

/**
 * Stack implemented with singly linked list.
 *
 * @author Sinan Mustafov
 */
public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public int size() {
        return list.size();
    }

}
