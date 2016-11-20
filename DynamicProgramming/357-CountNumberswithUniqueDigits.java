public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n < 0 || n >= 11) return 0;
        if(0 == n) return 1;
        int sum = 10;
        int f = 9;
        for(int i=2; i<=n; i++) {
            f *= (11-i);
            sum += f;
        }
        return sum;
    }
}