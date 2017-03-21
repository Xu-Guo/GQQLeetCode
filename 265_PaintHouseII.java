public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int ret = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if (k == j) continue;
                    ret = Math.min(costs[i][j] + costs[i - 1][k], ret);
                }
                costs[i][j] = ret;
            }
        }
        int result = Integer.MAX_VALUE;
        int n = costs.length - 1;
        for (int j = 0; j < costs[0].length; j++) {
            result = Math.min(result, costs[n][j]);
        }
        return result;
    }
}