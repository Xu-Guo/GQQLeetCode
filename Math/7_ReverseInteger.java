public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int remain = Math.abs(x);
        long newVal = 0;
        while (remain > 0) {
            newVal = newVal * 10 + remain % 10;
            if (newVal >= Integer.MAX_VALUE) return 0;
            remain /= 10;
        }
        return x >= 0 ? (int)newVal : -1 * (int)newVal;
    }
}