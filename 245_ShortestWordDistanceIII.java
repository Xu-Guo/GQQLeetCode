public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2)) {
                    if (idx1 <= idx2) idx1 = i;
                    else idx2 = i;
                } else {
                    idx1 = i;
                }
            } else if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) shortest = Math.min(shortest, Math.abs(idx1 - idx2));
        }
        return shortest;
    }
}