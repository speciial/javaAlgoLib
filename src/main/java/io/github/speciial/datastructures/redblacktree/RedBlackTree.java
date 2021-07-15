package io.github.speciial.datastructures.redblacktree;

import io.github.speciial.datastructures.redblacktree.RedBlackTree.Node.Color;

public class RedBlackTree {

    private final Node nil;

    private Node root;

    public RedBlackTree() {
        nil = new Node(Double.NaN);
        nil.color = Color.BLACK;

        root = nil;
    }

    public Node search(double key) {
        Node x = root;
        while (x != null && key != x.key) {
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public void insert(Node z) {
        Node y = nil;
        Node x = root;

        while (x != nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == nil) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        z.color = Color.RED;
        fixup(z);
    }

    private void fixup(Node z) {
        while (z.parent.color == Color.RED) {                       // breaks rule 4
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;                     // y = uncle
                if (y.color == Color.RED) {                         // uncle is red: case 1
                    z.parent.color = Color.BLACK;                   // turn parent black: fixes rule 4, breaks rule 5
                    y.color = Color.BLACK;                          // turn uncle black: fixes rule 4, breaks rule 5
                    z.parent.parent.color = Color.RED;              // turn grandparent red: fixes rule 5
                    z = z.parent.parent;                            // move z up 2 levels to check violation of rule 4
                } else {
                    if (z == z.parent.right) {                      // if z is right child: case 2
                        z = z.parent;                               // move z up
                        leftRotate(z);                              // rotate around z to create case 3
                    }
                                                                    // z is left child: case 3
                    z.parent.color = Color.BLACK;                   // turn parent black: fixes rule 4, break rule 5
                    z.parent.parent.color = Color.RED;              // turn grandparent red
                    rightRotate(z.parent.parent);                   // and rotate: fix rule 5;
                }
            } else {
                Node y = z.parent.parent.left;                      // y = uncle
                if(y.color == Color.RED) {                          // uncle is red
                    z.parent.color = Color.BLACK;                   // turn parent black: fixes rule 4, breaks rule 5
                    y.color = Color.BLACK;                          // turn uncle black: fixes rule 4, break rule 5
                    z.parent.parent.color = Color.RED;              // turn grandparent red: fixes rule 5
                    z = z.parent.parent;                            // move z up 2 levels to check violation of rule 4
                } else {
                                                                    // if z.parent is a right child
                                                                    // this needs to be inverted completely meaning
                                                                    // case 2 (z is a right child) becomes case 3 (z is
                                                                    // a left child) and vice versa
                    if(z == z.parent.left) {
                        z = z.parent;                               // move z up
                        rightRotate(z);                             // rotate around z to create opposite case
                    }
                    z.parent.color = Color.BLACK;                   // turn parent black: fixes rule 4, breaks rule 5
                    z.parent.parent.color = Color.RED;              // turn grandparent red
                    leftRotate(z.parent.parent);                    // and rotate: fixes rule 5
                }
            }
        }
        root.color = Color.BLACK;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    public static class Node {
        enum Color {
            RED, BLACK
        }

        Node left = null;
        Node right = null;
        Node parent = null;

        Color color;

        double key;

        public Node(double key) {
            this.key = key;
            this.color = Color.RED;
        }
    }

}
