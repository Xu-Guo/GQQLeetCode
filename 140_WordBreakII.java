public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> cache = new HashMap<>();
        List<String> res = new ArrayList<String>();
        helper2(s, wordDict, "", res, 0, cache);
        return res;
    }

    public List<String> helper(String s, List<String> wordDict, int start, Map<Integer, List<String>> cache) {
        if (cache.containsKey(start)) return cache.get(start);
        List<String> res = new ArrayList<String>();
        for (int i = start + 1; i <= s.length(); i++) {
            String pre = s.substring(start, i);
            if (wordDict.contains(pre)) {
                if (i == s.length()) {
                    res.add(pre);
                } else {
                    List<String> subStrs = helper(s, wordDict, i, cache);
                    for (String sub : subStrs) {
                        res.add(pre + " " + sub);
                    }
                }
            }
        }
        cache.put(start, res);
        return res;
    }

    public void helper2(String s, List<String> wordDict, String tmp, List<String> res, int start, Map<Integer, List<String>> cache) {
        if (start == s.length()) {
            res.add(tmp.trim());
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String pre = s.substring(start, i);
            if (wordDict.contains(pre)) {
                helper2(s, wordDict, tmp + pre + " ", res, i, cache);
            }
        }
    }
}