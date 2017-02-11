public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int len = Math.max(m, n) + 1;
        int[] r = new int[len];
        int i = 1;
        while (m - i >= 0 && n - i >= 0) {
            int aVal = a.charAt(m - i) - '0';
            int bVal = b.charAt(n - i) - '0';
            if (r[len - i] + aVal + bVal >= 2) {
                r[len - i - 1] += 1;
            }
            r[len - i] ^= aVal ^ bVal;
            i++;
        }

        while (m - i >= 0) {
            int aVal = a.charAt(m - i) - '0';
            r[len - i - 1] += aVal * r[len - i];
            r[len - i] ^= aVal;
            i++;
        }

        while (n - i >= 0) {
            int bVal = b.charAt(n - i) - '0';
            r[len - i - 1] += bVal * r[len - i];
            r[len - i] ^= bVal;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int val : r) {
            if (sb.length() == 0 && val == 0) {
                continue;
            }
            sb.append(val);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}