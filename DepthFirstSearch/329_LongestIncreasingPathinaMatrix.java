public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int longest = 1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                longest = Math.max(longest, getLongest(matrix, i, j, Integer.MIN_VALUE, cache));
            }
        }
        return longest;
    }

    public int getLongest(int[][] matrix, int i, int j, int pre, int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int longest = 1;
        longest = Math.max(longest, 1 + getLongest(matrix, i - 1, j, matrix[i][j], cache));
        longest = Math.max(longest, 1 + getLongest(matrix, i + 1, j, matrix[i][j], cache));
        longest = Math.max(longest, 1 + getLongest(matrix, i, j - 1, matrix[i][j], cache));
        longest = Math.max(longest, 1 + getLongest(matrix, i, j + 1, matrix[i][j], cache));
        cache[i][j] = longest;
        return longest;
    }
}