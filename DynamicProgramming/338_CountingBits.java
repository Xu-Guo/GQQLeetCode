public class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }

        int[] ret = new int[num + 1];
        ret[0] = 0;
        if (num > 0) {
            ret[1] = 1;
            for (int i=2; i<num+1; i++) {
                int d = i/2;
                int r = i%2;
                ret[i] = ret[d] + ret[r];
            }
        }
        return ret;
    }
}