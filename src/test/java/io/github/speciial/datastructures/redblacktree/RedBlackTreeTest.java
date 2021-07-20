package io.github.speciial.datastructures.redblacktree;

import org.junit.jupiter.api.Test;

import static io.github.speciial.datastructures.redblacktree.RedBlackTree.*;
import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    // TODO: For now, this will just test against the API of the RedBlackTree but
    //  there are some testing mechanisms to ensure that the structure of the
    //  tree is correct and does not violate the rules. This will be included later.

    @Test
    void testSingleInsert() {
        RedBlackTree tree = new RedBlackTree();
        Node x = new Node(1.0);

        tree.insert(x);

        Node found = tree.search(x.key);
        assertNotNull(found);
        assertEquals(x.key, found.key);
    }

    @Test
    void testMultipleInsert() {
        RedBlackTree tree = new RedBlackTree();
        Node x = new Node(16.0);
        Node y = new Node(17.0);
        Node z = new Node(18.0);
        Node w = new Node(19.0);
        Node v = new Node(99.0);

        tree.insert(x);
        tree.insert(y);
        tree.insert(z);
        tree.insert(w);
        tree.insert(v);

        Node foundX = tree.search(x.key);
        assertNotNull(foundX);
        assertEquals(x.key, foundX.key);

        Node foundY = tree.search(y.key);
        assertNotNull(foundY);
        assertEquals(y.key, foundY.key);

        Node foundV = tree.search(v.key);
        assertNotNull(foundV);
        assertEquals(v.key, foundV.key);
    }

    @Test
    void testSingleDelete() {
        RedBlackTree tree = new RedBlackTree();
        Node x = new Node(21.0);
        Node y = new Node(22.0);
        Node z = new Node(99.0);
        Node w = new Node(24.0);
        Node v = new Node(25.0);

        tree.insert(x);
        tree.insert(y);
        tree.insert(z);
        tree.insert(w);
        tree.insert(v);

        tree.delete(y);
        assertNull(tree.search(22.0));
    }

    @Test
    void testMultipleDelete() {
        RedBlackTree tree = new RedBlackTree();
        Node x = new Node(21.0);
        Node y = new Node(22.0);
        Node z = new Node(99.0);
        Node w = new Node(24.0);
        Node v = new Node(25.0);

        tree.insert(x);
        tree.insert(y);
        tree.insert(z);
        tree.insert(w);
        tree.insert(v);

        tree.delete(y);
        assertNull(tree.search(y.key));

        tree.delete(x);
        assertNull(tree.search(x.key));

        tree.delete(v);
        assertNull(tree.search(v.key));

        tree.delete(z);
        assertNull(tree.search(z.key));

        tree.delete(w);
        assertNull(tree.search(w.key));
    }

}