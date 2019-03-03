package Q1172_Binary_Tree_Tilt;

// Definition of TreeNode:
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    
    private int totalTilt;
    /**
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    public int findTilt(TreeNode root) {
        // Write your code here
        totalTilt = 0;
        getNodeSum(root);
        return totalTilt;
    }
    
    private int getNodeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = getNodeSum(node.left);
        int rightSum = getNodeSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;
        
        return leftSum + rightSum + node.val;
    }
    
}