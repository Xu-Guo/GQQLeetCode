public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int s0 = 0;
        int b0 = -prices[0];
        int b1 = Math.max(b0, -prices[1]);
        int s1 = Math.max(s0, b0 + prices[1]);
        for (int i=2; i<n; i++) {
            int p = prices[i];
            int buy2 = Math.max(s0 - p, b1);
            int sell2 = Math.max(b1 + p, s1);
            s0 = s1;
            b0 = b1;
            s1 = sell2;
            b1 = buy2;
        }
        return s1;
    }
}