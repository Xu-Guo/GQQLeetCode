public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    helper(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        return cnt;
    }
    public void helper(char[][] grid, int i, int j, int m, int n) {
        if (i <0 || i >= m || j <0 || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        helper(grid, i - 1, j, m, n);
        helper(grid, i + 1, j, m, n);
        helper(grid, i, j - 1, m, n);
        helper(grid, i, j + 1, m, n);
    }
}