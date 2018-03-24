package com.sirma.itt.javacourse.ds.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link LinkedStack}.
 *
 * @author Sinan Mustafov
 */
public class LinkedStackTest {

    @Test
    public void should_PushElement_OnTop() {
        LinkedStack<String> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());
        stack.push("abc");
        assertEquals("abc", stack.top());
        assertEquals(1, stack.size());
    }

    @Test
    public void should_ReturnNull_When_StackIsEmptyAndTryingToPop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void should_PopElements_FromTop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(4, stack.size());
        assertEquals(Integer.valueOf(40), stack.pop());
        assertEquals(Integer.valueOf(30), stack.pop());
        assertEquals(Integer.valueOf(20), stack.pop());
        assertEquals(Integer.valueOf(10), stack.pop());
    }

    @Test
    public void should_ReturnNull_When_StackIsEmptyForRetrievingTop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertNull(stack.top());
    }

}
