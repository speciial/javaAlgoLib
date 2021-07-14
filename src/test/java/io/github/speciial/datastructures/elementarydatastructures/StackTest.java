package io.github.speciial.datastructures.elementarydatastructures;

import io.github.speciial.exceptions.OverflowException;
import io.github.speciial.exceptions.UnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testSinglePush() {
        Stack stack = new Stack(1);
        stack.push(3.0);

        assertFalse(stack.empty());
    }

    @Test
    void testMultiplePush() {
        Stack stack = new Stack(3);
        stack.push(1.0);
        stack.push(2.5);
        stack.push(5.8);

        assertFalse(stack.empty());
    }

    @Test
    void testPushOverflow() {
        Stack stack = new Stack(2);
        stack.push(2.4);
        stack.push(2.5);

        assertThrows(OverflowException.class, () -> stack.push(2.6));
    }

    @Test
    void testSinglePop() {
        Stack stack = new Stack(5);
        stack.push(5.0);
        stack.push(6.0);
        stack.push(99.0);

        assertEquals(99.0, stack.pop());
    }

    @Test
    void testMultiplePop() {
        Stack stack = new Stack(5);
        stack.push(3.5);
        stack.push(6.5);
        stack.push(14.5);

        assertEquals(14.5, stack.pop());

        stack.push(22.0);

        assertEquals(22.0, stack.pop());
        assertEquals(6.5, stack.pop());
        assertEquals(3.5, stack.pop());
    }

    @Test
    void testUnderflow() {
        Stack stack = new Stack(5);
        stack.push(18.0);
        stack.push(23.4);
        stack.push(1.0);
        stack.push(1000.0);
        stack.push(6.0);

        while(!stack.empty()) {
            stack.pop();
        }

        assertThrows(UnderflowException.class, () -> stack.pop());
    }

}