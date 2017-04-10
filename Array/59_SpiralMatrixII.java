public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] board = new int[n][n];

        int k = (int)Math.ceil((double)n / (double)2);
        // System.out.println(k);
        int cnt = 1;
        for (int i = 0; i < k; i++) {
            for (int j = i; j <= n - (i + 1); j++) board[i][j] = cnt++;
            for (int j = i + 1; j <= n - (i + 2); j++) board[j][n - (i + 1)] = cnt++;
            if (n - (i + 1) > i)
                for (int j = n - (i + 1); j >= i; j--) board[n - (i + 1)][j] = cnt++;
            for (int j = n - (i + 2); j >= i + 1; j--) board[j][i] = cnt++;
        }
        return board;
    }
}