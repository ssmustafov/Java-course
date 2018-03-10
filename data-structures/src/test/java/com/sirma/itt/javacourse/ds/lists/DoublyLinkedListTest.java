package com.sirma.itt.javacourse.ds.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Sinan Mustafov
 */
public class DoublyLinkedListTest {

    @Test
    public void addFirst_Should_WorkProperly_WithOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addFirst_Should_WorkProperly_WithMultipleElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);

        assertEquals(Integer.valueOf(50), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(5, list.size());
    }

    @Test
    public void addLast_Should_WorkProperly_WithOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addLast_Should_WorkProperly_WithMultipleElements() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("first");
        list.addLast("second");
        list.addLast("third");
        list.addLast("forth");

        assertEquals("first", list.first());
        assertEquals("forth", list.last());
        assertEquals(4, list.size());
    }

    @Test
    public void removeFirst_Should_ReturnNull_When_ListIsEmpty() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        assertEquals(0, list.size());
        assertNull(list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_LeaveEmptyList_When_HasOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(2);

        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_WorkProperly_WithMultipleAdds() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(30);
        list.addLast(40);
        list.addFirst(50);

        assertEquals(Integer.valueOf(50), list.removeFirst());
        assertEquals("30 10 20 40", list.toString());
    }

    @Test
    public void first_Should_ReturnNull_When_ListIsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNull(list.first());
    }

    @Test
    public void last_Should_ReturnNull_When_ListIsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNull(list.last());
    }

    @Test
    public void should_WorkWithAlotOfElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        assertEquals(100, list.size());
        assertEquals(Integer.valueOf(0), list.first());
        assertEquals(Integer.valueOf(99), list.last());

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), list.removeFirst());
        }

        assertEquals(0, list.size());
        assertNull(list.first());
        assertNull(list.last());
    }
    
}
