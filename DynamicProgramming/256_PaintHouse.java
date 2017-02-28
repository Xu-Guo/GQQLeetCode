public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n <= 0) return 0;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for (int i=1; i<n; i++) {
            int tmpred = Math.min(blue + costs[i][0], green + costs[i][0]);
            int tmpblue = Math.min(red + costs[i][1], green + costs[i][1]);
            int tmpgreen = Math.min(blue + costs[i][2], red + costs[i][2]);
            red = tmpred;
            blue = tmpblue;
            green = tmpgreen;
        }
        return Math.min(red, Math.min(blue, green));
    }
}