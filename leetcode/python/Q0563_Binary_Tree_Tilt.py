# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
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
        