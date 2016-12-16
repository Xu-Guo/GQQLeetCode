public class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ret = new int[n+1];
        Arrays.fill(ret, Integer.MAX_VALUE);
        ret[0] = 0;
        for (int i=1; i<=n; i++) {
            int j = 1;
            while(i - j*j >= 0) {
                ret[i] = Math.min(ret[i], ret[i-j*j]+1);
                ++j;
            }
        }
        return ret[n];
    }
}