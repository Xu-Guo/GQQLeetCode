public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] maxToHere = new int[n];
        int[] maxFromHere = new int[n];
        int minVal = prices[0];
        int maxVal = prices[n - 1];
        for (int i=1; i<n; i++) {
            if (prices[i] <= minVal) {
                minVal = prices[i];
                maxToHere[i] = maxToHere[i - 1];
            } else {
                maxToHere[i] = Math.max(maxToHere[i - 1], prices[i] - minVal);
            }
        }
        
        for (int i = n-2; i>=0; i--) {
            if (prices[i] >= maxVal) {
                maxVal = prices[i];
                maxFromHere[i] = maxFromHere[i + 1];
            } else {
                maxFromHere[i] = Math.max(maxFromHere[i + 1], maxVal - prices[i]);
            }
        }
        int mprofit = maxFromHere[0];
        for (int i=0; i<n-1; i++) {
            mprofit = Math.max(mprofit, maxToHere[i] + maxFromHere[i+1]);
        }
        return mprofit;
    }
}