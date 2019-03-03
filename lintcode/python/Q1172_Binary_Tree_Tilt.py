"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root
    @return: the tilt of the whole tree
    """
    def findTilt(self, root):
        # Write your code here
        self.totalTilt = 0
        self.getNodeSum(root)
        return self.totalTilt
        
    def getNodeSum(self, node):
        if not node:
            return 0
            
        leftSum = self.getNodeSum(node.left)
        rightSum = self.getNodeSum(node.right)
        tilt = abs(leftSum - rightSum)
        self.totalTilt += tilt
        
        return leftSum + rightSum + node.val