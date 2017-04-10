public class Solution {
    public boolean canWin(String s) {
        Map<String, Boolean> cache = new HashMap<>();
        boolean res = helper(s, cache);
        return res;
    }

    public boolean helper(String s, Map<String, Boolean> cache) {
        if (s.length() <= 1) return false;
        if (cache.containsKey(s)) return cache.get(s);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i - 1, '-');
                sb.setCharAt(i, '-');
                String sub = sb.toString();
                boolean pattener = helper(sub, cache);
                if (!pattener) {
                    // System.out.println(s + "  " + i);
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}