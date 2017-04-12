public class Solution {
    int[] arr1 = {-1, 0, 1, 0};
    int[] arr2 = {0, -1, 0, 1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0) return res;
        int[][] grid = new int[m + 2][n + 2];
        int cnt = 0;
        int st = 0;
        for (int[] pos : positions) {
            int x = pos[0] + 1;
            int y = pos[1] + 1;
            Set<Integer> set = new HashSet<>();
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 4; k++) {
                int i = x + arr1[k];
                int j = y + arr2[k];
                int val = grid[i][j];
                if (val != 0) {
                    set.add(val);
                    min = Math.min(min, val);
                }
            }
            if (min != Integer.MAX_VALUE) {
                cnt = cnt + 1 - set.size();
                grid[x][y] = min;
                for (int k = 0; k < 4; k++) {
                    int i = x + arr1[k];
                    int j = y + arr2[k];
                    if (grid[i][j] != min) {
                        union(grid, grid[i][j], min, i, j);
                    }
                }
            } else {
                grid[x][y] = ++st;
                ++cnt;
            }
            res.add(cnt);
        }
        return res;
    }

    public void union(int[][] grid, int src, int des, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        if (grid[i][j] != src) return;
        grid[i][j] = des;
        union(grid, src, des, i - 1, j);
        union(grid, src, des, i + 1, j);
        union(grid, src, des, i, j - 1);
        union(grid, src, des, i, j + 1);
    }
}