public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) {
            return 0;
        }

        int colNum = matrix[0].length;
        int[] hight = new int[colNum];
        int[] left = new int[colNum];
        int[] right = new int[colNum];
        for (int i=0; i<colNum; i++) {
            right[i] = colNum;
        }

        int maxV = 0;
        for (int i=0; i<matrix.length; i++) {
            // heigh
            for (int j=0; j<colNum; j++) {
                if (matrix[i][j] == '1') {
                    hight[j] += 1;
                } else {
                    hight[j] = 0;
                }
            }

            // left
            int curr = 0;
            for (int j=0; j<colNum; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curr);
                } else {
                    left[j] = 0;
                    curr = j+1;
                }
            }

            // right
            curr = colNum;
            for (int j=colNum-1; j>=0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curr);
                } else {
                    right[j] = colNum;
                    curr = j;
                }
            }

            for (int j=colNum-1; j>=0; j--) {
                maxV = Math.max((right[j] - left[j]) * hight[j], maxV);
            }
        }
        return maxV;
    }
}