public class Solution {
    public int maxProfit(int[] prices) {
        int val = 0, min = 0, max = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
                max = i;
            } else if (prices[i] > prices[max]) {
                max = i;
            }
            val = Math.max(val, prices[max] - prices[min]);
        }
        return val;
    }

}

// Maximum subarray problem
// Kadane's algorithm[edit]

public class Solution {
    public int maxProfit(int[] prices) {
        int maxSofar = 0, maxCurr = 0;
        for (int i=1; i<prices.length; i++) {
            maxCurr = Math.max(maxCurr+prices[i] - prices[i-1], prices[i] - prices[i-1]);
            maxSofar = Math.max(maxSofar, maxCurr);
        }
        return maxSofar;
    }
}