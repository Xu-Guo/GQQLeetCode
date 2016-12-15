public class Solution {
    int max_v = 0;
    public int findMaxForm(String[] strs, int m, int n) {
        if (m==0 && n==0) {
            return 0;
        }
        return bk(strs, m, n, 0, 0);
    }

    private int bk(String[] strs, int m, int n, int curr, int start) {
        if(strs.length==0 || (m==0 && n==0)) {
            return curr;
        }

        for (int i=start; i<strs.length; i++) {
            String s = strs[i];
            int p = m;
            int q = n;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    --p;
                } else {
                    --q;
                }
                if (p<0 || q<0) {
                    break;
                }
            }
            
            if (p>=0 && q>=0) {
                int val = bk(strs, p, q, curr+1, i+1);
                max_v = Math.max(val, max_v);
            }
        }
        return max_v;
    }
}