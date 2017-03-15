public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            set.add(p.charAt(i));
        }
        int st = 0, ed = 0, counter = p.length();
        while (ed < s.length()) {
            char curr = s.charAt(ed++);
            if (set.contains(curr) && map[curr - 'a']-- > 0) counter--;

            while (counter == 0) {
                if (ed - st == p.length()) {
                    res.add(st);
                }
                char pre = s.charAt(st++);
                if (set.contains(pre) && map[pre - 'a']++ >= 0) counter++;
            }
        }
        return res;
    }
}