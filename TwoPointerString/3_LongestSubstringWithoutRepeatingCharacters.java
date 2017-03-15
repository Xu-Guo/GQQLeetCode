public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[255];
        int longest = 0;
        int st = 0, ed = 0;
        while(ed < s.length() && map[s.charAt(ed++)]++ > 0) {
            longest = Math.max(longest, ed - st);
            while (st < ed && map[s.charAt(st++)]-- > 1);
        }
    }
}