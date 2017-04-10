public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        return getNum(xs) + getNum(ys);
    }

    public int getNum(List<Integer> list) {
        Collections.sort(list);
        int low = 0, hi = list.size() - 1;
        int res = 0;
        while (low < hi) {
            res += list.get(hi--) - list.get(low++);
        }
        return res;
    }
}