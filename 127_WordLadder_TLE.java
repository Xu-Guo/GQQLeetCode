public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] used = new int[wordList.size()];
        return helper(beginWord, endWord, wordList, used, new HashMap<String, Integer>());
    }

    public int helper(String begin, String end, List<String> wordList, int[] used, Map<String, Integer> cache) {
        String key = Arrays.toString(used);
        if (cache.containsKey(key)) return cache.get(key);
        if (begin.equals(end)) {
            cache.put(key, 1);
            return 1;
        }
        int minLength = Integer.MAX_VALUE;
       
        for (int i=0; i < wordList.size(); i++) {
            if (used[i] == 0) {
                if (isadjecent(begin, wordList.get(i))) {
                    used[i] = 1;
                    int dis = helper(wordList.get(i), end, wordList, used, cache);
                    used[i] = 0;
                    if (dis != 0) {
                        minLength = Math.min(minLength, dis + 1);
                    }
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) minLength = 0;
        cache.put(key, minLength);
        return minLength;
    }

    public boolean isadjecent(String word1, String word2) {
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();
        int cnt = 0;
        for (int i=0; i < chrs1.length; i++) {
            if (chrs1[i] != chrs2[i]) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}