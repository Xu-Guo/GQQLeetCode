public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int n = pattern.length();
        if (n != words.length) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] dic = new String[26];
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if (!map.containsKey(s)) {
                if (dic[c - 'a'] == null) {
                    map.put(s, c - 'a');
                    dic[c - 'a'] = s;
                } else {
                    return false;
                }
            } else {
                int pos = map.get(s);
                if (!dic[pos].equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}