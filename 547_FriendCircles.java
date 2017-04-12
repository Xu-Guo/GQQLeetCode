public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0 || n == 1) return n;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int pi = parents[i];
                    int pj = parents[j];
                    if (pi != pj) {
                        // union pi,pj
                        for (int k = 0; k < n; k++) {
                            if (parents[k] == pi) parents[k] = pj;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(parents));
        Set<Integer> set = new HashSet<>();
        for (int p : parents) set.add(p);
        return set.size();
    }
}