public class Solution {
    public void reverseWords(char[] s) {
        if (s == null) return;
        int n = s.length;
        if (n == 0) return;
        // reverse characters
        int i = 0, j = n - 1;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }

        // reverse words.
        int slow = 0, fast = 0;
        while (fast <= n) {
            if (fast == n || s[fast] == ' ') {
                int ii = slow;
                int jj = fast - 1;
                while (ii < jj) {
                    char tmp = s[ii];
                    s[ii++] = s[jj];
                    s[jj--] = tmp;
                }
                slow = fast + 1;
            }
            ++fast;
        }
    }
}