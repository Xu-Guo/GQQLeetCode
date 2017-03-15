public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() == 0 || s.length() < p.length()) return res;
        int[] map = new int[26];
        int np = p.length();
        int ns = s.length();
        for (int i = 0; i < np; i++) {
            map[p.charAt(i) - 'a']++;
        }
        for (int i=0; i <= ns - np; i++) {
            int[] newmap = new int[26];
            for (int k=0; k<26; k++) {
                newmap[k] = map[k];
            }
            for (int j = i; j < i + np; j++) {
                newmap[s.charAt(j) - 'a']--;
            }
            boolean istrue = true;
            for (int k=0; k<26; k++) {
                if (newmap[k] != 0) {
                    istrue = false;
                    break;
                }
            }
            if (istrue) res.add(i);
        }
        return res;
    }
}