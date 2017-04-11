public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        if (m == 0 || n == 0) return new ArrayList<String>();
        ArrayList<String>[] res = new ArrayList[n + 1];
        for (int i = 0; i < n+ 1; i++) {
            res[i] = new ArrayList<String>();
        }

        for (int i = n - 1; i >= 0; i--) {
            String sub = s.substring(i);
            for (String word : wordDict) {
                if (sub.equals(word)) {
                    res[i].add(word);
                } else if (sub.startsWith(word)) {
                    List<String> preStrings = res[i + word.length()];
                    for (String pre : preStrings) {
                        res[i].add(word + " " + pre);
                    }
                }
            }
        }
        cache.put(start, res);
        return res;
    }

    public void helper2(String s, List<String> wordDict, String tmp, List<String> res, int start, Map<Integer, List<String>> cache) {
        if (cache.containsKey(start)) {
            res = cache.get(start);
            return;
        }
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
        cache.put(start, res);
        return res[0];
    }
}