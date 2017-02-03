public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        char[] chrs = s.toCharArray();
        for (char c : chrs ) {
            cnt[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < chrs.length; i++) {
            char c = chrs[i];
            if(c < chrs[pos]) pos = i;
            if(--cnt[c - 'a'] == 0) break;
        }
        return s.equals("") ? "" : chrs[pos] + removeDuplicateLetters(s.substring(pos).replaceAll(chrs[pos] + "", ""));
    }
}