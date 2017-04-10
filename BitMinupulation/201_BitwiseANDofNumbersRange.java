public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int len = n - m + 1;
        int start = (int)(Math.ceil(Math.log(len) / Math.log(2)));
        int res = 0;
        for (int i = start; i < 32; i++) {
            int hi = (m >> i & 1) & (n >> i & 1);
            res = (hi << i) | res;
        }
        return res;
    }
}