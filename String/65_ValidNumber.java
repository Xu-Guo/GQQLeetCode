public class Solution {
    public boolean isNumber(String s) {
        // remove spaces
        s = s.trim();
        
        if (s.length() == 0) return false;
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;

        int hasdot = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'e') {
                if (i == 0 || i == n - 1) return false;
                else if (hasdot == 0 && i == 1) return false;
                return isAfterENumber(s.substring(i + 1));
            } else if (c == '.') {
                if (hasdot != -1 || n == 1) return false;
                else hasdot = i;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isAfterENumber(String s) {
        System.out.println(s);
        if (s.length() == 0) return false;
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}