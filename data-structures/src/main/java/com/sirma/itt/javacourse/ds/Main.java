package com.sirma.itt.javacourse.ds;

import com.sirma.itt.javacourse.ds.lists.SinglyLinkedList;

/**
 * @author Sinan Mustafov
 */
public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        System.out.println(list);
    }

}
