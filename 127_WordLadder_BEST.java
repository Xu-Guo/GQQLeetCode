public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        Set<String> beginSet = new HashSet<String>() {{ add(beginWord);}};
        if (!dict.contains(endWord)) return 0;
        Set<String> endSet = new HashSet<String>() {{ add(endWord);}};
        Set<String> visited = new HashSet<String>();
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> temp = new HashSet<>();
            for (String wd : beginSet) {
                char[] chrwd = wd.toCharArray();
                for (int i = 0; i < chrwd.length; i++) {
                    char old = chrwd[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chrwd[i] = c;
                        String newStr = String.valueOf(chrwd);
                        // if in endSet, return.
                        if (endSet.contains(newStr)) return len + 1;

                        if (!visited.contains(newStr) && dict.contains(newStr)) {
                            temp.add(newStr);
                            visited.add(newStr);
                        }
                    }
                    chrwd[i] = old;
                }
            }

            beginSet = temp;
            len++;
        }
        return 0;
    }
}