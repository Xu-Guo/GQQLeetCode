public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int minIndex = -1, minVal = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            if (costs[0][j] < minVal) {
                minVal = costs[0][j];
                minIndex = j;
            }
        }

        for (int i = 1; i < n; i++) {
            int ret = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (j == minIndex) continue;
                ret = Math.min(ret, costs[i - 1][j] + costs[i][minIndex]);
            }
            costs[i][minIndex] = ret;

            int newMinVal = Integer.MAX_VALUE;
            int newMinIndex = -1;
            for (int j = 0; j < k; j++) {
                if (j == minIndex) continue;
                costs[i][j] += minVal;
                // newMinVal = Math.min(costs[i][j], newMinVal);
                if (costs[i][j] < newMinVal) {
                    newMinVal = costs[i][j];
                    newMinIndex = j;
                }
            }
            
            if (costs[i][minIndex] < newMinVal) {
                minVal = costs[i][minIndex];
            } else {
                minVal = newMinVal;
                minIndex = newMinIndex;
            }
        }

        int result = costs[n - 1][0];
        for (int j = 1; j < k; j++) {
            result = Math.min(result, costs[n - 1][j]);
        }
        return result;
    }
}