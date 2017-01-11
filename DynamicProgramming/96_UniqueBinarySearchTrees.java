public class Solution {
    public int numTrees(int n) {
        int[] r = new int[n+1];
        r[0] = 1;
        for (int i=1; i<n+1; i++) {
            for (int j=0; j<i; j++) {
                r[i] += r[j] * r[i-j-1];
            }
        }
        return r[n];
    }
}