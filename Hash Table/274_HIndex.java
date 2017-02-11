public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0 || (n == 1 && citations[0] == 0)) return 0;
        int hIndexVal = 0;
        for (int i = 1; i <= n; i++) {
            int bigger = 0, smaller = 0, equals = 0;
            boolean isHIndex = true;
            for (int j = 0; j < n; j++) {
                int val = citations[j];
                if (val > i) {
                    bigger++;
                } else if (val < i) {
                    smaller++;
                } else {
                    equals++;
                }
                if (bigger > i || smaller > n - i) {
                    isHIndex = false;
                    break;
                }
            }
            if (isHIndex) {
                hIndexVal = Math.max(hIndexVal, i);
            }
        }
        return hIndexVal;
    }
}