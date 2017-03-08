public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int high = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String wd = queue.poll();
                if (wd.equals(endWord)) return high;
                
                Set<String> neighbors = getNeighbors(wd, wordSet);
                // if (neighbors.size() == 0) return 0;
                
                for (String nb : neighbors) {
                    queue.offer(nb);
                }
            }
            high++;
        }
        return 0;
    }

    public Set<String> getNeighbors(String s, Set<String> wordSet) {
        Set<String> result = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String word = new String(chars);
                if(wordSet.remove(word)){
                    result.add(word);
                }
            }
        }
        return result;
    }
}