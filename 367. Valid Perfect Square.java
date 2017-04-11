public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        long low = 0, hi = num;
        while (low <= hi) {
            long mid = low + (hi - low) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    
}