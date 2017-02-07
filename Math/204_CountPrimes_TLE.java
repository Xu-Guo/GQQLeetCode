public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] tbl = new boolean[n];
        tbl[0] = tbl[1] = true;
        for (int j = 3; j < n; j++) {
            if (j % 2 == 0) tbl[j] = true;
        }

        for (int i=3; i*i < n; i++) {
            if(!tbl[i]) {
                for (int j=i+1; j<n; j++) {
                    if(!tbl[i] && j % i == 0) tbl[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i=2; i<n; i++) {
            if(!tbl[i]) cnt++;
        }
        return cnt;
    }
}