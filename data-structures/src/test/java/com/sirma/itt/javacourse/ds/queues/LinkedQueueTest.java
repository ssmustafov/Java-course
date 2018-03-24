package com.sirma.itt.javacourse.ds.queues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link LinkedQueue}.
 *
 * @author Sinan Mustafov
 */
public class LinkedQueueTest {

    @Test
    public void should_EnqueueElementToTheEnd() {
        LinkedQueue<String> queue = new LinkedQueue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals(3, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void should_ReturnNull_When_DequeueEmptyQueue() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertNull(queue.dequeue());
    }

}
