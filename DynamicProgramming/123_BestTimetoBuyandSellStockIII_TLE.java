public class Solution {
    public int maxProfit(int[] prices) {
        int end = prices.length - 1;
        int max = 0;
        for (int i = end; i>=-1; i--) {
            int max1 = getMax(prices, 0, i);
            int max2 = getMax(prices, i+1, end);
            max = Math.max(max, max1+max2);
        }
        return max;
    }

    public int getMax(int[] prices, int start, int end) {
        if (end - start < 1) return 0;
        int minVal = prices[start];
        int max = 0;
        for (int i= start + 1; i <= end; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else {
                max = Math.max(max, prices[i]-minVal);
            }
        }
        return max;
    }
}