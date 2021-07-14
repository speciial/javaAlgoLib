package io.github.speciial.elementarydatastructures;

public class LinkedList {

    private Element head = null;

    /**
     * LinkedList implementation base on CLRS 3rd edition p. 236-241.
     *
     * NOTE: to work properly the keys for the elements need to be distinct.
     */
    public LinkedList() {
    }

    public Element search(double key) {
        Element x = head;
        while (x != null && x.key != key) {
            x = x.next;
        }
        return x;
    }

    public void insert(Element x) {
        x.next = head;
        if (head != null) {
            head.prev = x;
        }
        head = x;
        x.prev = null;
    }

    public void delete(Element x) {
        if (x.prev != null) {
            x.prev.next = x.next;
        } else {
            head = x.next;
        }
        if (x.next != null) {
            x.next.prev = x.prev;
        }
    }

    public Element maximum() {
        Element max = head;
        Element x = head;
        while (x != null) {
            if (max.key < x.key) {
                max = x;
            }
            x = x.next;
        }
        return max;
    }

    public Element minimum() {
        Element min = head;
        Element x = head;
        while (x != null) {
            if (min.key > x.key) {
                min = x;
            }
            x = x.next;
        }
        return min;
    }

    public static class Element {
        Element next;
        Element prev;

        double key;

        public Element(double key) {
            this.key = key;
        }
    }

}
