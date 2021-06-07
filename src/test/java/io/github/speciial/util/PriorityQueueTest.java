package io.github.speciial.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void testInsertAndExtract() {
        IndexedMinPriorityQueue queue = new IndexedMinPriorityQueue(10);

        queue.insert(0, 8.0);
        queue.insert(1, 2.5);
        queue.insert(2, 0.1);
        queue.insert(3, 3.0);
        queue.insert(4, 12.6);
        queue.insert(5, 11.3);

        assertEquals(2, queue.extract());
        assertEquals(1, queue.extract());
        assertEquals(3, queue.extract());
    }

    @Test
    void testDecreaseKey() {
        IndexedMinPriorityQueue queue = new IndexedMinPriorityQueue(10);

        queue.insert(0, 8.0);
        queue.insert(1, 2.5);
        queue.insert(2, 0.1);
        queue.insert(3, 3.0);
        queue.insert(4, 12.6);
        queue.insert(5, 11.3);

        queue.decreaseKey(4, 1.0);
        queue.decreaseKey(1, 0.01);
        queue.decreaseKey(5, 0.001);

        assertEquals(5, queue.extract());
        assertEquals(1, queue.extract());
        assertEquals(2, queue.extract());
        assertEquals(4, queue.extract());
        assertEquals(3, queue.extract());
    }

}