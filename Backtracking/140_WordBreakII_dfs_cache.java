public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> DFS(String s, List<String> wordDict, Map<String, List<String>> cache){
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new LinkedList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, cache);
                for (String sub : sublist) {
                    result.add(word + (sub.length() == 0 ? sub : " " + sub));
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}