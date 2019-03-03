package Q0563_Binary_Tree_Tilt;

 // Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int totalTilt;
    
    public int findTilt(TreeNode root) {
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