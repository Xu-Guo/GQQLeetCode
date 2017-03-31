public class NumMatrix {
    int[][] res = null;
    int m = 0, n = 0;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        res = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i + 1][j + 1] = matrix[i][j] + res[i][j + 1] + res[i + 1][j] - res[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row2 >=m ) return 0;
        if (col1 < 0 || col2 >=n ) return 0;
        return res[row2 + 1][col2 + 1] + res[row1][col1] - res[row2 + 1][col1] - res[row1][col2 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */