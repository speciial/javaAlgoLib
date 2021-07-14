package io.github.speciial.elementarydatastructures;

import io.github.speciial.elementarydatastructures.LinkedList.Element;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testSingleInsert() {
        LinkedList list = new LinkedList();
        Element x = new Element(1.0);

        list.insert(x);
        Element found = list.search(x.key);

        assertNotNull(found);
        assertEquals(x.key, found.key);
    }

    @Test
    void testMultipleInsert() {
        LinkedList list = new LinkedList();
        Element x = new Element(1.0);
        Element y = new Element(2.0);
        Element z = new Element(3.0);

        list.insert(x);
        list.insert(y);
        list.insert(z);

        Element foundX = list.search(x.key);
        assertNotNull(foundX);
        assertEquals(x.key, foundX.key);

        Element foundY = list.search(y.key);
        assertNotNull(foundY);
        assertEquals(y.key, foundY.key);

        Element foundZ = list.search(z.key);
        assertNotNull(foundZ);
        assertEquals(z.key, foundZ.key);
    }

    @Test
    void testSingleDelete() {
        LinkedList list = new LinkedList();
        Element x = new Element(9.0);

        list.insert(x);

        list.delete(x);
        Element found = list.search(x.key);
        assertNull(found);
    }

    @Test
    void testMultipleDelete() {
        LinkedList list = new LinkedList();
        Element x = new Element(16.0);
        Element y = new Element(17.0);
        Element z = new Element(18.0);

        list.insert(x);
        list.insert(y);
        list.insert(z);

        list.delete(y);
        assertNull(list.search(y.key));

        list.delete(x);
        assertNull(list.search(x.key));

        list.delete(z);
        assertNull(list.search(z.key));
    }

    @Test
    void testMaximumOnEmptyList() {
        LinkedList list = new LinkedList();
        Element x = new Element(99.0);

        list.insert(x);
        list.delete(x);

        assertNull(list.maximum());
    }

    @Test
    void testMaximumOnFilledList() {
        LinkedList list = new LinkedList();
        Element max = new Element(9999.0);

        list.insert(new Element(1.0));
        list.insert(new Element(3.0));
        list.insert(new Element(4.0));
        list.insert(max);
        list.insert(new Element(5.0));
        list.insert(new Element(6.0));

        Element foundMax = list.maximum();
        assertEquals(max, foundMax);
    }

    @Test
    void testMinimumOnEmptyList() {
        LinkedList list = new LinkedList();
        Element x = new Element(-99.0);

        list.insert(x);
        list.delete(x);

        assertNull(list.minimum());
    }

    @Test
    void testMinimumOnFilledList() {
        LinkedList list = new LinkedList();
        Element min = new Element(-9999.0);

        list.insert(new Element(1.0));
        list.insert(new Element(3.0));
        list.insert(min);
        list.insert(new Element(4.0));
        list.insert(new Element(5.0));
        list.insert(new Element(6.0));

        Element foundMin = list.minimum();
        assertEquals(min, foundMin);
    }

}