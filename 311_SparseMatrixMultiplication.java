public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int cols = A[0].length;
        int n = B[0].length;
        int[][] res = new int[m][n];

        for (int i=0; i<m; i++) {
             for (int k=0; k<cols; k++) {
                 if (A[i][k] != 0) {
                     for (int j=0; j<n; j++) {
                         if (B[k][j] != 0) {
                             res[i][j] += A[i][k] * B[k][j];
                         }
                     }
                 }
             }
         }
         return res; 
    }
}