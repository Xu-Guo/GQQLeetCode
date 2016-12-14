public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int c_idx = 0;
        char curr = s.charAt(c_idx);
        for (int i=0; i<t.length(); i++) {
            if (curr == t.charAt(i)) {
                if (++c_idx == s.length()) {
                    return true;
                }
                curr = s.charAt(c_idx);
            }
        }
        return false;
    }
}