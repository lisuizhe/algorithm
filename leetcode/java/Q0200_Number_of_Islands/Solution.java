package Q0200_Number_of_Islands;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                count++;
                dfs(grid, i, j, maxRow, maxCol);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row-1, col, maxRow, maxCol);
        dfs(grid, row, col-1, maxRow, maxCol);
        dfs(grid, row+1, col, maxRow, maxCol);
        dfs(grid, row, col+1, maxRow, maxCol);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(s.numIslands(grid));
    }
}