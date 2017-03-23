public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // boolean[] cache = new boolean[s.length()];
        Map<Integer, Boolean> cache = new HashMap<>();
        return helper(s, 0, wordDict, cache);
    }

    public boolean helper(String s, int start, List<String> wordDict, Map<Integer, Boolean> cache) {
        if (start >= s.length()) return true;
        if (cache.containsKey(start)) return cache.get(start);
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                boolean res = helper(s, i, wordDict, cache);
                if (res) {
                    cache.put(start, true);
                    return true;
                }
            }
        }
        cache.put(start, false);
        return false;
    }
}