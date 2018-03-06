package com.sirma.itt.javacourse.ds.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Sinan Mustafov
 */
public class SinglyLinkedListTest {

    @Test
    public void addFirst_Should_WorkProperly_WithOneElement() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addFirst_Should_WorkProperly_WithMultipleElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addLast_Should_WorkProperly_WithMultipleElements() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        assertEquals(0, list.size());
        assertNull(list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_LeaveEmptyList_When_HasOneElement() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(2);

        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_WorkProperly_WithMultipleAdds() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertNull(list.first());
    }

    @Test
    public void last_Should_ReturnNull_When_ListIsEmpty() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertNull(list.last());
    }

    @Test
    public void should_WorkWithAlotOfElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

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
