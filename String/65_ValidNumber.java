public class Solution {
    public boolean isNumber(String s) {
        // remove spaces
        s = s.trim();
        
        if (s.length() == 0) return false;
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;

        int eIndex = -1;
        int dotIndex = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'e') {
                if (i == 0 || i == n - 1 || eIndex != -1) return false;
                else if (dotIndex == i - 1) return false;
                else eIndex = i;
            } else if (c == '.') {
                if (i == 0 || i == n - 1 || dotIndex != -1 || eIndex != -1) return false;
                else dotIndex = i;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}