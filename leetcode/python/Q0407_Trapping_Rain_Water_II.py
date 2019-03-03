from heapq import heappush, heappop

class _Cell(object):
    def __init__(self, row, col, height):
        self.row = row
        self.col = col
        self.height = height

    def __lt__(self, other):
        return self.height < other.height

class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        if not heightMap or len(heightMap) == 0 or len(heightMap[0]) == 0:
            return 0
        q = []
        m = len(heightMap)
        n = len(heightMap[0])
        visited = [[False for i in range(n)] for j in range(m)]
        
        # Initially, add all the Cells which are on borders to the queue.
        for i in range(m):
            visited[i][0] = True
            visited[i][n - 1] = True
            heappush(q, _Cell(i, 0, heightMap[i][0]))
            heappush(q, _Cell(i, n - 1, heightMap[i][n - 1]))
        
        for i in range(n):
            visited[0][i] = True
            visited[m - 1][i] = True
            heappush(q, _Cell(0, i, heightMap[0][i]))
            heappush(q, _Cell(m - 1, i, heightMap[m - 1][i]))

        # from the borders, pick the shortest cell visited and check its neighbors:
        # if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
        # add all its neighbors to the queue.
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        res = 0
        while len(q) != 0:
            cell = heappop(q)
            for dir in dirs:
                row = cell.row + dir[0]
                col = cell.col + dir[1]
                if row >= 0 and row < m and col >= 0 and col < n and not visited[row][col]:
                    visited[row][col] = True
                    res += max(0, cell.height - heightMap[row][col])
                    heappush(q, _Cell(row, col, max(heightMap[row][col], cell.height)))

        return res