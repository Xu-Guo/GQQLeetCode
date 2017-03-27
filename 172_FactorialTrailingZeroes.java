public class Solution {
    public int trailingZeroes(int n) {
        // count the number of 5
        return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}