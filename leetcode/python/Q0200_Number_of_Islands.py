class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        count = 0
        maxRow = len(grid)
        maxCol = len(grid[0])
        for i in range(maxRow):
            for j in range(maxCol):
                if grid[i][j] == '1':
                    self._dfs(grid, i, j, maxRow, maxCol)
                    count += 1
        return count

    def _dfs(self, grid, row, col, maxRow, maxCol):
        if row < 0 or col < 0 or row >= maxRow or col >= maxCol or grid[row][col] != '1':
            return
        grid[row][col] = '0'
        self._dfs(grid, row-1, col, maxRow, maxCol)
        self._dfs(grid, row, col-1, maxRow, maxCol)
        self._dfs(grid, row+1, col, maxRow, maxCol)
        self._dfs(grid, row, col+1, maxRow, maxCol)