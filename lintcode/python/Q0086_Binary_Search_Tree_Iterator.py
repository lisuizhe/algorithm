"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

Example of iterate a tree:
iterator = BSTIterator(root)
while iterator.hasNext():
    node = iterator.next()
    do something for node 
"""


class BSTIterator:
    """
    @param: root: The root of binary tree.
    """
    def __init__(self, root):
        # do intialization if necessary
        self.stack = []
        self._pushLeftTree(root)

    """
    @return: True if there has next node, or false
    """
    def hasNext(self, ):
        # write your code here
        return len(self.stack) != 0

    """
    @return: return next node
    """
    def next(self, ):
        # write your code here
        node = self.stack.pop()
        self._pushLeftTree(node.right)
        return node
        
    def _pushLeftTree(self, node):
        currentNode = node
        while currentNode:
            self.stack.append(currentNode)
            currentNode = currentNode.left
