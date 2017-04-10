public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        int slow = 0, fast = 0;
        int max = 0;
        while (fast < n) {
            char c = s.charAt(fast);
            int val = map.getOrDefault(c, 0);
            if (val == 0) ++counter;
            map.put(c, val + 1);

            if (counter > 2) max = Math.max(max, fast - slow);
            while (counter > 2) {
                char pre = s.charAt(slow++);
                int preVal = map.get(pre);
                if (preVal == 1) counter--;
                map.put(pre, preVal - 1);
            }
            fast++;
        }
        max = Math.max(max, fast - slow);
        return max;
    }
}