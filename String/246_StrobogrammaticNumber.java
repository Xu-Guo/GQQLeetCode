public class Solution {
    
    List<Character> list = Arrays.asList('8', '0', '1');
    public boolean isStrobogrammatic(String num) {
        int low = 0, high = num.length() - 1;
        while (low < high) {
            char c1 = num.charAt(low++);
            char c2 = num.charAt(high--);
            if (c1 == c2 && list.contains(c1)) continue;
            if (c1 == '6' && c2 == '9') continue;
            if (c1 == '9' && c2 == '6') continue;
            return false;
        }
        if (low == high) {
            if (!list.contains(num.charAt(low))) {
                return false;
            }
        }
        return true;
    }
}