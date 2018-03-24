package com.sirma.itt.javacourse.ds.stacks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ArrayStack}.
 *
 * @author Sinan Mustafov
 */
public class ArrayStackTest {

    @Test
    public void should_PushElement_OnTop() {
        ArrayStack<String> stack = new ArrayStack<>();

        assertTrue(stack.isEmpty());
        stack.push("abc");
        assertEquals("abc", stack.top());
        assertEquals(1, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_WhenStackIsFullAndTryingToPush() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
    }

    @Test
    public void should_ReturnNull_When_StackIsEmptyAndTryingToPop() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void should_PopElements_FromTop() {
        ArrayStack<Integer> stack = new ArrayStack<>();
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
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertNull(stack.top());
    }

}
