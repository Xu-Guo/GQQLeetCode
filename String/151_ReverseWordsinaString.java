public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;
        while (start >= 0) {
            if (s.charAt(start) != ' ') start--;
            else {
                if (start == end) {
                    start--;
                    end--;
                } else {
                    sb.append(s.substring(start + 1, end + 1).trim() + " ");
                    end = start;
                }
            }
        }
        sb.append(s.substring(start + 1, end + 1).trim() + " ");
        return sb.toString().trim();
    }
}