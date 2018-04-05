package com.sirma.itt.javacourse.ds.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ArrayList}.
 *
 * @author Sinan Mustafov
 */
public class ArrayListTest {

    @Test
    public void should_CreateEmptyListInitially() {
        ArrayList<String> list = new ArrayList<>();
        assertEquals(0, list.size());
        assertEquals(16, list.capacity());
        assertTrue(list.isEmpty());
    }

    @Test
    public void should_WorkProperly_With_OneElement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");

        assertEquals("first", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void should_WorkProperly_With_MultipleElements() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        assertEquals(5, list.size());
        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
        assertEquals("third", list.get(2));
        assertEquals("fourth", list.get(3));
        assertEquals("fifth", list.get(4));
    }

    @Test
    public void should_GrowCapacity_When_Filled() {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        assertEquals(5, list.size());
        assertEquals(8, list.capacity());
        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
        assertEquals("third", list.get(2));
        assertEquals("fourth", list.get(3));
        assertEquals("fifth", list.get(4));
    }

    @Test
    public void should_NotGrowCapacity_When_NotNeeded() {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("first");
        list.add("second");

        assertEquals(2, list.size());
        assertEquals(2, list.capacity());
        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_When_RemovingFromNegativeIndex() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");

        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowException_When_RemovingFromOutOfBoundIndex() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");

        list.removeAt(1);
    }

    @Test
    public void should_ProperlyRemove_FromListWithOneElement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");

        assertEquals("first", list.removeAt(0));
        assertEquals(0, list.size());
    }

    @Test
    public void should_ProperlyRemove_FromListWithMultipleElements() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(Integer.valueOf(4), list.removeAt(3));
        assertEquals(3, list.size());
        assertEquals("1 2 3", list.toString());
    }

    @Test
    public void should_ProperlyShiftElementsToLeft_When_RemovingFromMiddle() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(Integer.valueOf(3), list.removeAt(2));
        assertEquals(4, list.size());
        assertEquals("1 2 4 5", list.toString());
    }

    @Test
    public void should_ProperlyShiftElementsToLeft_When_RemovingTheFirstElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(Integer.valueOf(1), list.removeAt(0));
        assertEquals(4, list.size());
        assertEquals("2 3 4 5", list.toString());
    }

}
