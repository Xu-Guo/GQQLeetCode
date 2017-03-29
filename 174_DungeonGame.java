public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] res = new int[m][n];

        // the pricess room
        res[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        // the right column
        for (int i = m - 2; i >= 0; i--) {
            if (dungeon[i][n - 1] < res[i + 1][n - 1]) {
                res[i][n - 1] = res[i + 1][n - 1] - dungeon[i][n - 1];
            } else {
                res[i][n - 1] = 1;
            }
        }
        // the bottom line
        for (int j = n - 2; j >= 0; j--) {
            if (dungeon[m - 1][j] < res[m - 1][j + 1]) {
                res[m - 1][j] = res[m - 1][j + 1] - dungeon[m - 1][j];
            } else {
                res[m - 1][j] = 1;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int val1, val2;
                if (dungeon[i][j] < res[i + 1][j]) {
                    val1 = res[i + 1][j] - dungeon[i][j];
                } else {
                    val1 = 1;
                }
                if (dungeon[i][j] < res[i][j + 1]) {
                    val2 = res[i][j + 1] - dungeon[i][j];
                } else {
                    val2 = 1;
                }
                res[i][j] = Math.min(val1, val2);
            }
        }
        return res[0][0];
    }
}