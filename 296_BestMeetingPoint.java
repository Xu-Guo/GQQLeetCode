public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        List<int[]> people = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    people.add(new int[]{i, j});
                }
            }
        }
        if (people.size() <= 2) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dis = 0;
                for (int[] point : people) {
                    dis += Math.abs(point[0] - i) + Math.abs(point[1] - j);
                }
                res = Math.min(res, dis);
            }
        }
        return res;
    }
}