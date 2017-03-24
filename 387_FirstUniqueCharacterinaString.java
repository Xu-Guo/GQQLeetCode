public class Solution {
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for (int i = 0; i < 26; i++) {
            table[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table[c - 'a'] == -1) {
                table[c - 'a'] = i;
            } else if (table[c - 'a'] >= 0) {
                table[c - 'a'] = -2;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(table[i] >= 0) min = Math.min(table[i], min);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}