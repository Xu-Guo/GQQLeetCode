public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char chr = t.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int count = t.length();
        int slow = 0, fast = 0, min = Integer.MAX_VALUE, head = 0;
        String res = "";
        while (fast < s.length()) {
            char ele = s.charAt(fast++);
            if (map.containsKey(ele)) {
                int val = map.get(ele);
                if (val-- > 0) count--;
                map.put(ele, val);
            }
            while (count == 0) {
                char pre = s.charAt(slow);
                if (map.containsKey(pre)) {
                    int val = map.get(pre);
                    if (val++ >= 0) count++;
                    map.put(pre, val);
                }
                // substring
                if (fast - slow < min) {
                    head = slow;
                    min = fast - slow;
                }
                slow++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);

    }
}