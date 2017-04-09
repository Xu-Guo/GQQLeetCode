public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // you must pay attention to size. if you use queue.size() in loop, 
            // the size will change every time when you offer new element.
            for (int i = 0; i < size; i++) {
                String wd = queue.poll();
                // System.out.println(wd);
                if (wd.equals(endWord)) return level;
                
                for (String nb : getNeibors(wd, set)) {
                    queue.offer(nb);
                }
            }
            level++;
            // System.out.println();
        }
        return 0;
    }

    public List<String> getNeibors(String word, Set<String> set) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chrs = word.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                chrs[i] = j;
                String newStr = new String(chrs);
                if (set.remove(newStr)) {
                    list.add(newStr);
                }
            }
        }
        return list;
    }
}