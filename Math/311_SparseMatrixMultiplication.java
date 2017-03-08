public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length;
        int n = A[0].length;
        int cols = B[0].length;
        int[][] res = new int[rows][cols];
        Set<Integer> allZeroRows = new HashSet<>();
        Set<Integer> allZeroCols = new HashSet<>();

        for (int i=0; i<rows; i++) {
            int j = 0;
            while(j < n && A[i][j] == 0) j++;
            if (j == n) allZeroRows.add(i);
        }

        for (int j=0; j<cols; j++) {
            int i = 0;
            while(i < n && B[i][j] == 0) i++;
            if (i == n) allZeroCols.add(j);
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (!allZeroRows.contains(i) && !allZeroCols.contains(j)) {
                    int sum = 0;
                    for (int k=0; k<n; k++) {
                        sum += A[i][k] * B[k][j];
                    }
                    res[i][j] = sum;
                }
            }
        }
        return res;
    }
}