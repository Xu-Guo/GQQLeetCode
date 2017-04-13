public class Solution {
    public List<String> generateAbbreviations(String word) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = helper(word, map);
        List<String> res = new ArrayList<>(set);
        return res;
    }

    public Set<String> helper(String word) {
        Set<String> res = new HashSet<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        if (word.length() == 1) {
            res.add(word);
            res.add("1");
            return res;
        }
        if (map.containsKey(word)) return map.get(word);
        int n = word.length();
        for (int i = 1; i < n; i++) {
            String sub = word.substring(0, i);
            Set<String> substrs = helper(word.substring(i));
            for (String substr : substrs) {
                res.add(sub + substr);
                if (!(substr.charAt(0) <= '9' && substr.charAt(0) >= '0')) {
                    res.add(i + substr);
                }
            }
        }
        res.add(n + "");
        map.put(word, res);
        return res;
    }
}