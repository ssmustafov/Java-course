package com.sirma.itt.javacourse.ds.lists;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void equals_ShouldReturnFalse_When_ArgIsNull() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertFalse(list.equals(null));
    }

    @Test
    public void equals_ShouldReturnFalse_When_ArgIsNotSinglyLinkedList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertFalse(list.equals(new DoublyLinkedList<>()));
    }

    @Test
    public void equals_ShouldReturnFalse_When_SizeOfListsDifferent() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("first");

        SinglyLinkedList<String> otherList = new SinglyLinkedList<>();

        assertFalse(list.equals(otherList));
    }

    @Test
    public void equals_ShouldReturnFalse_When_DifferentTypeElements() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("first");
        SinglyLinkedList<Integer> otherList = new SinglyLinkedList<>();
        otherList.addFirst(1);

        assertFalse(list.equals(otherList));
    }

    @Test
    public void equals_ShouldReturnTrue_When_SameReference() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("first");

        assertTrue(list.equals(list));
    }

    @Test
    public void equals_ShouldReturnTrue_When_SameElements() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("first");
        SinglyLinkedList<String> otherList = new SinglyLinkedList<>();
        otherList.addFirst("first");

        assertTrue(list.equals(otherList));
        assertTrue(otherList.equals(list));
    }

    @Test
    public void equals_ShouldReturnTrue_When_TransitiveEquals() {
        SinglyLinkedList<String> x = new SinglyLinkedList<>();
        x.addFirst("first");

        SinglyLinkedList<String> y = new SinglyLinkedList<>();
        y.addFirst("first");

        SinglyLinkedList<String> z = new SinglyLinkedList<>();
        z.addFirst("first");

        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertTrue(x.equals(z));
    }

    @Test
    public void equals_ShouldReturnTrue_When_WithMultipleEqualElements() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("A");
        list.addFirst("b");
        list.addFirst("C");
        list.addFirst("d");
        list.addFirst("E");
        list.addFirst("f");
        list.addFirst("G");

        SinglyLinkedList<String> otherList = new SinglyLinkedList<>();
        otherList.addFirst("A");
        otherList.addFirst("b");
        otherList.addFirst("C");
        otherList.addFirst("d");
        otherList.addFirst("E");
        otherList.addFirst("f");
        otherList.addFirst("G");

        assertTrue(list.equals(otherList));
        assertTrue(otherList.equals(list));
    }

    @Test
    public void clone_ShouldMakeShallowCopy() {
        Person first = new Person("John");
        Person second = new Person("Joe");
        Person third = new Person("Jane");
        int size = 3;

        SinglyLinkedList<Person> list = new SinglyLinkedList<>();
        list.addLast(first);
        list.addLast(second);
        list.addLast(third);

        SinglyLinkedList<Person> cloned = list.clone();
        assertEquals(size, cloned.size());

        Person clonedFirst = cloned.removeFirst();
        Person clonedSecond = cloned.removeFirst();
        Person clonedThird = cloned.removeFirst();

        assertTrue(first == clonedFirst);
        assertTrue(second == clonedSecond);
        assertTrue(third == clonedThird);
    }

    /**
     * Helper class used for testing list cloning.
     */
    private static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }
    }

}
