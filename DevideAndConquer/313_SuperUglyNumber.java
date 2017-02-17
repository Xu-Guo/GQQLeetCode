public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexs = new int[primes.length];
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1; i < n; i++) {
            ret[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ret[i] = Math.min(ret[i], primes[j] * ret[indexs[j]]);
            }

            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ret[indexs[j]] == ret[i]) indexs[j]++;
            }
        }
        return ret[n - 1];
    }
}