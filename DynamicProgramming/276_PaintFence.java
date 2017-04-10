public class Solution {
    public int numWays(int n, int k) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                res[i] = k;
            } else if (i == 2) {
                res[i] = k * k;
            } else if (i == 3) {
                res[i] = k * (k - 1) + k * (k - 1) * k;
            } else {
                res[i] = (res[i - 1] - (k - 1) * res[i - 3]) * k + res[i - 3] * (k - 1) * (k - 1);
            }
        }
        return res[n];
    }
}

public class Solution {
    public int numWays(int n, int k) {
        int res1 = 0, res2 = 0, res3 = 0, res = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                res1 = k;
                res = res1;
            } else if (i == 2) {
                res2 = k*k;
                res = res2;
            } else if (i == 3) {
                res3 = k * (k - 1) + k * (k - 1) * k;
                res = res3;
            } else {
                res = (res3 - (k - 1) * res1) * k + res1 * (k - 1) * (k - 1);
                res1 = res2;
                res2 = res3;
                res3 = res;
            }
        }
        return res;
    }
}