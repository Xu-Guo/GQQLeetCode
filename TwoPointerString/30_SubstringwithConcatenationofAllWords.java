public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;
        for (String wd : words) {
            if (map.containsKey(wd)) {
                map.put(wd, map.get(wd) + 1);
            } else {
                map.put(wd, 1);
            }
        }
        int m = words.length;
        int n = s.length();
        int wd_len = words[0].length();

        for (int i = 0; i <= n - m * wd_len; i++) {
            String subStr = s.substring(i, m * wd_len + i);
            if (valid(subStr, new HashMap<>(map), m, wd_len)) {
                res.add(i);
            }
        }

        return res;
    }

    public boolean valid(String str, Map<String, Integer> map, int counter, int wd_len) {
        for (int i = 0; i <= str.length() - wd_len; i += wd_len) {
            String sub = str.substring(i, i + wd_len);
            if (!map.containsKey(sub)) {
                return false;
            }
            if (map.get(sub) <= 0) {
                return false;
            }
            map.put(sub, map.get(sub) - 1);
            counter--;
        }
        return counter == 0;
    }
}