public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null) return 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    ++num;
                    pointIslands(grid, i, j, m, n);
                }
            }
        }
        return num;
    }

    public void pointIslands(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '*';
        pointIslands(grid, i - 1, j, m, n);
        pointIslands(grid, i + 1, j, m, n);
        pointIslands(grid, i, j - 1, m, n);
        pointIslands(grid, i, j + 1, m, n);
    }
}