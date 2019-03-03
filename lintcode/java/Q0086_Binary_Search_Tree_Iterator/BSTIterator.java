package Q0086_Binary_Search_Tree_Iterator;

import java.util.Stack;

// Definition of TreeNode:
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
 }

 /*
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


class BSTIterator {
    private Stack<TreeNode> stack;
        
    /*
    * @param root: The root of binary tree.
    */
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stack = new Stack<>();
        pushLeftTree(root);
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        pushLeftTree(node.right);
        return node;
    }
    
    private void pushLeftTree(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}