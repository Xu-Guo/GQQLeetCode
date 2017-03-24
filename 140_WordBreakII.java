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
        return res[0];
    }
}