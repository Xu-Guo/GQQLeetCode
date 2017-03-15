public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[255];
        int st = 0, ed = 0, counter = 0;
        int longest = 0;
        while (ed < s.length()) {
            char curr = s.charAt(ed++);
            if (map[curr]++ == 0) counter++;

            while (counter > k) {
                if(--map[s.charAt(st++)] == 0) counter--;
            }

            // last - front
            longest = Math.max(longest, ed - st);
        }
        return longest;
    }
}