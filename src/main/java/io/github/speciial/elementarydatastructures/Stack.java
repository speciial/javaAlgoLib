package io.github.speciial.elementarydatastructures;

import io.github.speciial.exceptions.OverflowException;
import io.github.speciial.exceptions.UnderflowException;

public class Stack {

    private final int capacity;

    private final double[] S;
    private int top;

    /**
     * Stack implementation based on CLRS 3rd edition p. 232-233 with slight adjustment
     * to make internal array zero-based.
     *
     * @param capacity Max number of elements to store in the stack.
     */
    public Stack(int capacity) {
        this.capacity = capacity;

        this.S = new double[capacity];
        this.top = 0;
    }

    public boolean empty() {
        return top == 0;
    }

    public void push(double element) {
        if (top >= (capacity)) {
            throw new OverflowException("Stack Overflow");
        }
        S[top] = element;
        ++top;
    }

    public double pop() {
        if (empty()) {
            throw new UnderflowException("Stack Underflow");
        }
        --top;
        return S[top];
    }

}
