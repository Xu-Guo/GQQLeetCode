public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for (String neib : getNeibors(word, wordSet)) {
                    queue.offer(neib);
                }
            }
            level++;
        }
        return 0;
    }

    public Set<String> getNeibors(String word, Set<String> set) {
        Set<String> res = new HashSet<>();
        char[] chrWord = word.toCharArray();
        for (int i = 0; i < chrWord.length; i++) {
            char c = chrWord[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == c) continue;
                chrWord[i] = j;
                String tmp = new String(chrWord);
                if (set.remove(tmp)) res.add(tmp);
            }
            chrWord[i] = c;
        }
        return res;
    }
}