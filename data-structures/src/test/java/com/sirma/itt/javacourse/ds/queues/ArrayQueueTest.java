package com.sirma.itt.javacourse.ds.queues;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ArrayQueue}.
 *
 * @author Sinan Mustafov
 */
public class ArrayQueueTest {

    @Test
    public void should_EnqueueElementToTheEnd() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals(3, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test(expected = IllegalStateException.class)
    public void should_ThrowException_When_QueueIsFullWhenEnqueue() {
        ArrayQueue<String> queue = new ArrayQueue<>(2);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
    }

    @Test
    public void should_ReturnNull_When_DequeueEmptyQueue() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertNull(queue.dequeue());
    }

}
