import queue

class DirectedGraphNode(object):
    def __init__(self, val):
        self.val = val
        self.neighbors = []

class UndirectedGraphNode(object):
    def __init__(self, val):
        self.val = val
        self.neighbors = []

class Solution(object):
    def hasRouteByDFS(graph, start, end):
        visited = set()
        def _dfs(start, end):
            if start == end:
                return True
            else:
                if not start or not end:
                    return False
                visited.add(start)
                for neighbor in start.neighbors:
                    if neighbor in visited:
                        continue
                    if _dfs(neighbor, end):
                        return True

            return False

        return _dfs(start, end)

    def hasRouteByBFS(graph, start, end):
        visited = set()
        q = queue.Queue()
        q.put(start)
        while q:
            node = q.get()
            visited.add(node)
            if node == end:
                return True
            for neighbor in node.neighbors:
                if neighbor not in visited:
                    q.put(neighbor)
        return False

    def connectedComponentsByDFS(nodes):
        results = []
        result = []
        visited = set()
        def _dfs(node):
            result.append(node.val)
            visited.add(node)
            for neighbor in node.neighbor:
                if neighbor in visited:
                    continue
                _dfs(neighbor)

        if not nodes:
            return None
        
        for node in nodes:
            if node in visited:
                continue
            result = []
            _dfs(node, visited)
            sorted(result)
            results.append(result)
        return results

    def connectedComponentsByBFS(nodes):
        results = []
        visited = set()
        def _bfs(node):
            result = []
            q = queue.Queue()
            q.put(node)
            visited.add(node)
            while q:
                current = q.get()
                result.append(current.val)
                for neighbor in current.neighbors:
                    if node in visited:
                        continue
                    q.put(node)
                    visited.add(node)
                
            return result

        if not nodes:
            return None

        for node in nodes:
            if node in visited:
                continue
            result = _bfs(node)
            sorted(result)
            results.append(result)
        return results

    