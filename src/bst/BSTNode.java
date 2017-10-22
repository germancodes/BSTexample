/* CSCI 3343 Analysis of Algorithms Spring 2017
   Chapter 6 Binary Search Tree: Node class */

package bst;

public class BSTNode {
    protected int el;
    protected BSTNode left, right;
    public BSTNode() {
        left = right = null;
    }
    public BSTNode(int el) {
        this(el,null,null);
    }
    public BSTNode(int el, BSTNode lt, BSTNode rt) {
        this.el = el; left = lt; right = rt;
    }
}
