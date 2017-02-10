
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rvs = 0;
        int x1 = x;
        while (x1 > 0) {
            int tmpRvs = rvs * 10 + x1 % 10;
            if (rvs != (tmpRvs - x1 % 10) / 10) return false;
            rvs = tmpRvs;
            x1 /= 10;
        }
        return rvs == x;
    }
}