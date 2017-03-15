public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        Set<Charecter> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            set.add(p.charAt(i));
        }
        int st = 0, ed = 0, counter = p.length();
        while (ed < s.length()) {
            char curr = s.charAt(ed++);
            if (set.contains(curr)) {
                if(map[curr - 'a']-- > 0) counter--;
            }

            if (counter == 0) {
                
            }
        }
    }
}