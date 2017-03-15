public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[255];
        int st = 0, ed = 0, counter = 2;
        int res = 0;
        while(ed < s.length()) {
            if (map[s.charAt(ed++)]++ == 0) counter--;
            while(counter < 0) {
                if (--map[s.charAt(st++)] == 0) counter++;
            }
            if (counter == 0) res = Math.max(ed - st, res);
        }
        
        return res == 0 ? s.length() : res;
    }
}