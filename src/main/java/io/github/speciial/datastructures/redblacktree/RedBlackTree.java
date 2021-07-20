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
        while (x != nil && key != x.key) {
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // To be consistent with the Binary Search Tree, if a key is
        // not found, return null
        if (x == nil) {
            x = null;
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
        insertFixup(z);
    }

    public void delete(Node z) {
        Node y = z;
        Color yOriginalColor = y.color;
        Node x;
        if (z.left == nil) {
            x = z.left;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == Color.BLACK) {
            deleteFixup(x);
        }
    }

    public Node maximum(Node x) {
        while (x.right != nil) {
            x = x.right;
        }
        return x;
    }

    public Node minimum(Node x) {
        while (x.left != nil) {
            x = x.left;
        }
        return x;
    }

    public Node successor(Node x) {
        if (x.right != nil) {
            return minimum(x.right);
        }
        Node y = x.parent;
        while (y != nil && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public Node predecessor(Node x) {
        if (x.left != nil) {
            return maximum(x);
        }
        Node y = x.parent;
        while (y != nil && x == y.left) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    private void insertFixup(Node z) {
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
                if (y.color == Color.RED) {                         // uncle is red
                    z.parent.color = Color.BLACK;                   // turn parent black: fixes rule 4, breaks rule 5
                    y.color = Color.BLACK;                          // turn uncle black: fixes rule 4, break rule 5
                    z.parent.parent.color = Color.RED;              // turn grandparent red: fixes rule 5
                    z = z.parent.parent;                            // move z up 2 levels to check violation of rule 4
                } else {
                    // if z.parent is a right child
                    // this needs to be inverted completely meaning
                    // case 2 (z is a right child) becomes case 3 (z is
                    // a left child) and vice versa
                    if (z == z.parent.left) {
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

    private void deleteFixup(Node x) {
        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;                            // sibling of x
                // case 1
                if (w.color == Color.RED) {                         // if sibling is red, convert to 2, 3 or 4
                    w.color = Color.BLACK;                          // turn sibling black
                    x.parent.color = Color.RED;                     // turn parent red
                    leftRotate(x.parent);                           // rotate around parent
                    w = x.parent.right;                             // set correct sibling
                }
                // case 2
                if (w.left.color == Color.BLACK                     // if both of the children of the sibling
                        && w.right.color == Color.BLACK) {          // are black remove "one" black
                    w.color = Color.RED;                            // turn the sibling red
                    x = x.parent;
                } else {
                    // case 3
                    if (w.right.color == Color.BLACK) {             // if right of w is black and left is red
                        w.left.color = Color.BLACK;                 // turn left of sibling black
                        w.color = Color.RED;                        // turn sibling red
                        rightRotate(w);                             // rotate around sibling
                        w = x.parent.right;                         // adjust w to be sibling of x -> create case 4
                    }
                    // case 4
                    w.color = x.parent.color;                       // set siblings color to parents color
                    x.parent.color = Color.BLACK;                   // turn parent black
                    w.right.color = Color.BLACK;                    // turn right of sibling black
                    leftRotate(x.parent);                           // rotate around parent
                    x = root;                                       // set x to root to terminate the loop
                }
            } else {
                Node w = x.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.left.color == Color.BLACK
                        && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                } else {
                    if (w.left.color == Color.BLACK) {
                        w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private void transplant(Node u, Node v) {
        if (u.parent == nil) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
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
