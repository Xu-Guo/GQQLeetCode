public class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        if (n <= 0) return 0;
        if (n == 1) {
            char c = str.charAt(0);
            if (c < '0' || c > '9') return 0;
            return c - '0';
        }
        boolean isMinus = false;
        int start = 0;
        int end = n - 1;
        while (start < n && (str.charAt(start) == ' ')) start++;
        // str.charAt(start) == ' ')
        if (str.charAt(start) == '-') {
            isMinus = true;
            start += 1;
        }
        else if (str.charAt(start) == '+') start += 1;
        while (start < n && (str.charAt(start) == '0')) start++;
        while (end > start && str.charAt(end) == ' ') end--;
        String s = str.substring(start, end + 1);
        long num = 0;
        int n1 = s.length();
        for (int i = 0; i < n1; i++) {
            char c = s.charAt(i);
            
            if (c < '0' || c > '9') break;
            int d = c - '0';
            num = num * 10 + d;
            if (num - 1 >= Integer.MAX_VALUE) {
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isMinus ? (-1) * (int)num : (int)num;
    }
}