public class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length() == 0) return 0;

        return helper(s, 0, new HashMap<Integer, Integer>());
    }

    public int helper(String s, int index, Map<Integer, Integer> map) {
        if (index == s.length()) {
            return 1;
        }
        if (map.containsKey(index)) return map.get(index);
        if (s.charAt(index) == '0') return 0;
        int cnt1 = 0;
        if (index == s.length() -1 || s.charAt(index + 1) != '0')
            cnt1 += helper(s, index + 1, map);
        if (index + 2 <= s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            cnt1 += helper(s, index + 2, map);
        }
        map.put(index, cnt1);
        return cnt1;
    }
}