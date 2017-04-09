public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            // you must pay attention to size. if you use queue.size() in loop, 
            // the size will change every time when you offer new element.
            for (int i = 0; i < size; i++) {
                String wd = queue.poll();
                // System.out.println(wd);
                Set<String> removed = new HashSet<String>();
                for (String str : set) {
                    if (isOne(wd, str)) {
                        // System.out.println(wd + " " + str);
                        if (str.equals(endWord)) return level;
                        queue.offer(str);
                        // set.remove(str);
                        removed.add(str);
                    }
                }
                set.removeAll(removed);
            }
            // System.out.println();
        }
        return 0;
    }

    public boolean isOne(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char[] chrs = s1.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                chrs[i] = j;
                if (s2.equals(new String(chrs))) {
                    return true;
                }
            }
        }
        return false;
    }
}