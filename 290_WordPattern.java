public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] dict = new String[26];
        Map<String, Integer> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i=0; i < pattern.length(); i++) {
            if (dict[pattern.charAt(i) - 'a'] == null) {
                if (map.containsKey(strs[i])) return false;
                else {
                    dict[pattern.charAt(i) - 'a'] = strs[i];
                    map.put(strs[i], pattern.charAt(i) - 'a');
                }
            } else {
                if (!strs[i].equals(dict[pattern.charAt(i) - 'a'])) return false;
            }
        }
        return true;
    }
}