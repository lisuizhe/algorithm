import queue
# Definition for a Node.
class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        visited = dict()

        def dfs(target):
            if not target:
                return None
            cloned = Node(target.val, [])
            for neighbor in target.neighbors:
                if neighbor.val in visited:
                    cloned.neighbors.append(visited[neighbor.val])
                else:
                    cloned.neighbors.append(dfs(neighbor))
            return cloned

        return dfs(node)