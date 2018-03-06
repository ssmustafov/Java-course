package com.sirma.itt.javacourse.ds.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Sinan Mustafov
 */
public class CircularlyLinkedListTest {

    @Test
    public void addFirst_Should_WorkProperly_WithOneElement() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addFirst_Should_WorkProperly_WithMultipleElements() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
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
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(10);

        assertEquals(Integer.valueOf(10), list.first());
        assertEquals(Integer.valueOf(10), list.last());
        assertEquals(1, list.size());
    }

    @Test
    public void addLast_Should_WorkProperly_WithMultipleElements() {
        CircularlyLinkedList<String> list = new CircularlyLinkedList<>();
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
        CircularlyLinkedList<String> list = new CircularlyLinkedList<>();

        assertEquals(0, list.size());
        assertNull(list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_LeaveEmptyList_When_HasOneElement() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(2);

        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void removeFirst_Should_WorkProperly_WithMultipleAdds() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
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
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        assertNull(list.first());
    }

    @Test
    public void last_Should_ReturnNull_When_ListIsEmpty() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        assertNull(list.last());
    }

    @Test
    public void should_WorkWithAlotOfElements() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();

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

    @Test
    public void toString_Should_ReturnEmptyStringLiteral_When_ListIsEmpty() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        assertEquals("empty", list.toString());
    }

    @Test
    public void should_WorkProperly_WithRoundRobinScheduling() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);

        assertEquals("50 40 30 20 10", list.toString());

        int circle = 6;
        int counter = 50;

        while (circle != 0) {
            Integer first = list.first();
            assertEquals(Integer.valueOf(counter), first);

            list.rotate();

            counter -= 10;
            if (counter == 0) {
                counter = 50;
            }

            circle--;
        }

        assertEquals("40 30 20 10 50", list.toString());
    }

}
