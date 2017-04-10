public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return -1;
        int res = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        int total  = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) total++;
        if (total == 0) return -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int dis = doCaculation(deepCopy(grid), i, j, m, n, total);
                    if (dis > 0) {
                        res = Math.min(dis, res);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int[][] deepCopy(int[][] source) {
        int[][] des = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            des[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return des;
    }

    public boolean getDis(int[][] grid, int p, int q, Queue<int[]> queue) {
        if (p >= 0 && p < grid.length && q >= 0 && q < grid[0].length) {
            if (grid[p][q] == 1) {
                grid[p][q] = -1;
                return true;
            } else if (grid[p][q] == 0) {
                grid[p][q] = -1;
                queue.offer(new int[]{p, q});
            } else {
                grid[p][q] = -1;
            }
        }
        return false;
    }

    public int doCaculation(int[][] grid, int i0, int j0, int m, int n, int total) {
        int level = 0;
        int dis = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i0, j0});
        grid[i0][j0] = -1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // System.out.println(size);
            level++;
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                int i = point[0], j = point[1];
                if(getDis(grid, i - 1, j, queue)) {
                    cnt++;
                    dis += level;
                }
                if(getDis(grid, i + 1, j, queue)) {
                    cnt++;
                    dis += level;
                }
                if(getDis(grid, i, j + 1, queue)) {
                    cnt++;
                    dis += level;
                }
                if(getDis(grid, i, j - 1, queue)) {
                    cnt++;
                    dis += level;
                }
            }
        }
        return cnt == total ? dis : -1;
    }
}