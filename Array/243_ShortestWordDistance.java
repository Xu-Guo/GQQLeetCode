public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int n = words.length();
        int dis = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (words[i].equals(word1)) {
                if (idx2 != -1) dis = Math.min(dis, Math.abs(idx2 - idx1));
                idx1 = i;
            } else if (words[i].equals(word2)) {
                if (idx1 != -1) dis = Math.min(dis, Math.abs(idx2 - idx1));
                idx2 = i;
            }
        }
        return dis;
    }
}