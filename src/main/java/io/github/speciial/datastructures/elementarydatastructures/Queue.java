package io.github.speciial.datastructures.elementarydatastructures;

import io.github.speciial.exceptions.OverflowException;
import io.github.speciial.exceptions.UnderflowException;

public class Queue {

    private final int capacity;

    private final double[] Q;

    private int head;
    private int tail;

    /**
     * Queue implementation based on CLRS 3rd Edition p. 234-235 using a ring buffer
     * with slight adjustments to make the internal array zero-based.
     *
     * NOTE: CLRS points out that this implementation can store at most n - 1 elements.
     * This forces us to allocate an array for capacity + 1 elements to guarantee the
     * specified capacity.
     *
     * @param capacity Max number of elements to store in the Queue.
     */
    public Queue(int capacity) {
        this.capacity = capacity + 1;

        this.Q = new double[capacity + 1];
        this.head = 0;
        this.tail = 0;
    }

    public boolean empty() {
        return head == tail;
    }

    public void enqueue(double element) {
        if ((tail + 1) == head || (head == 0 && tail == (capacity - 1))) {
            throw new OverflowException("Queue Overflow");
        }

        Q[tail] = element;
        tail++;
        if(tail == capacity) {
            tail = 0;
        }
    }

    public double dequeue() {
        if(tail == head) {
            throw new UnderflowException("Queue Underflow");
        }

        double x = Q[head];
        head++;
        if(head == (capacity)) {
            head = 0;
        }
        return x;
    }

}
