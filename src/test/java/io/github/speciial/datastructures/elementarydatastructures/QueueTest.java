package io.github.speciial.datastructures.elementarydatastructures;

import io.github.speciial.exceptions.OverflowException;
import io.github.speciial.exceptions.UnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testSingleEnqueue() {
        Queue queue = new Queue(1);
        queue.enqueue(1.0);

        assertFalse(queue.empty());
    }

    @Test
    void testMultipleEnqueue() {
        Queue queue = new Queue(3);
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);

        assertFalse(queue.empty());
    }

    @Test
    void testDequeueOnSingleElementQueue() {
        Queue queue = new Queue(1);
        queue.enqueue(1.0);
        assertEquals(1.0, queue.dequeue());

        queue.enqueue(2.0);
        assertEquals(2.0, queue.dequeue());

        queue.enqueue(3.0);
        assertEquals(3.0, queue.dequeue());
    }

    @Test
    void testMultipleDequeue() {
        Queue queue = new Queue(5);
        queue.enqueue(1.0);
        queue.enqueue(2.0);
        queue.enqueue(3.0);
        queue.enqueue(4.0);

        assertEquals(1.0, queue.dequeue());
        assertEquals(2.0, queue.dequeue());

        queue.enqueue(5.0);
        queue.enqueue(6.0);

        assertEquals(3.0, queue.dequeue());
        assertEquals(4.0, queue.dequeue());
        assertEquals(5.0, queue.dequeue());
        assertEquals(6.0, queue.dequeue());

        assertTrue(queue.empty());
    }

    @Test
    void testQueueOverflow() {
        Queue queue1 = new Queue(1);
        queue1.enqueue(1000.0);
        assertThrows(OverflowException.class, () -> queue1.enqueue(2000.0));

        Queue queue2 = new Queue(5);
        queue2.enqueue(16.0);
        queue2.enqueue(17.0);
        queue2.enqueue(18.0);
        queue2.enqueue(19.0);
        queue2.enqueue(20.0);
        assertThrows(OverflowException.class, () -> queue2.enqueue(2000.0));
    }

    @Test
    void testQueueUnderflow() {
        Queue queue1 = new Queue(1);
        queue1.enqueue(1000.0);
        queue1.dequeue();
        assertThrows(UnderflowException.class, () -> queue1.dequeue());

        Queue queue2 = new Queue(5);
        queue2.enqueue(16.0);
        queue2.enqueue(17.0);
        queue2.enqueue(18.0);
        queue2.enqueue(19.0);
        queue2.enqueue(20.0);

        while (!queue2.empty()) {
            queue2.dequeue();
        }
        assertThrows(UnderflowException.class, () -> queue2.dequeue());
    }

}