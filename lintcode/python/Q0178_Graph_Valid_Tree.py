class Solution:
    """
    @param n: An integer
    @param edges: a list of undirected edges
    @return: true if it's a valid tree, or false
    """
    def validTree(self, n, edges):
        # write your code here
        if n <= 0:
            return False
        if len(edges) != n-1:
            return False

        def initializeGraph(n, edges):
            graph = dict()
            for i in range(n):
                graph[i] = set()
            for edge in edges:
                u = edge[0]
                v = edge[1]
                graph[u].add(v)
                graph[v].add(u)
            return graph
        
        graph = initializeGraph(n, edges)
        visited = set()
        q = []
        visited.add(0)
        q.append(0)
        while(q):
            node = q.pop(0)
            for neighbor in graph[node]:
                if neighbor in visited:
                    continue
                visited.add(neighbor)
                q.append(neighbor)
        return len(visited) == n