public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int start = 0, end = 0, counter = t.length();
        String res = "";
        int minWindow = s.length();
        while (end < s.length()) {
            char curr = s.charAt(end++);
            if (map.containsKey(curr)) {
                int cnt = map.get(curr) - 1;
                if (cnt >= 0) counter--;
                map.put(curr, cnt);
            }

            while (counter == 0) {
                if (end - start <= minWindow) {
                    minWindow = end - start;
                    res = s.substring(start, end);
                }
                char pre = s.charAt(start++);
                if (map.containsKey(pre)) {
                    int cnt = map.get(pre) + 1;
                    if (cnt > 0) counter++;
                    map.put(pre, cnt);
                }
            }
        }
        return res;
    }
}