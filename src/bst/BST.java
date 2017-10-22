/* CSCI 3343 Analysis of Algorithms Spring 2017
   Chapter 6 Binary Search Tree Implementation */
  
package bst;

public class BST {
    protected BSTNode root = null;
    protected int intIterations;
  
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int newel) {
        BSTNode p = root, prev = null;
        while (p != null) {  // find a place for inserting new node;
            prev = p;
            if (p.el < newel)
                 p = p.right;
            else p = p.left;
        }
        if (root == null)    // tree is empty;
             root = new BSTNode(newel);
        else if (prev.el < newel)
             prev.right = new BSTNode(newel);
        else prev.left  = new BSTNode(newel);
    }
    
    public BSTNode search(BSTNode p, int el){
        intIterations = 0;
        while (p != null) {
            if (el == p.el){
                intIterations++;
                return p;
            } else if (el < p.el){
                intIterations++;
                p = p.left;
            } else {
                intIterations++;
                p = p.right;
            }
        }
        return null;
    }
    
    public int getSearchIterations(){
        return intIterations;
    }
}
