public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> first = new ArrayList<String>() {{ add(beginWord); }};
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        res.add(first);
        List<List<String>> temp = new ArrayList<>();
        List<List<String>> finalRes = new ArrayList<>();
        Set<String> deleted = new HashSet<>();
        boolean needReturn = false;
        while (res.size() > 0) {
            // if (res.size() <= 0) break;
            for (List<String> list : res) {
                // System.out.println(list);
                // get the last word
                String wd = list.get(list.size() - 1);
                if (wd.equals(endWord)) {
                    needReturn = true;
                }
                if (!needReturn) {
                    List<String> neibors = getNeibors(wd, dict);
                    for (String nb : neibors) {
                        List<String> newlist = new ArrayList<String>(list);
                        newlist.add(nb);
                        temp.add(newlist);
                        deleted.add(nb);
                    }
                } else {
                    if (wd.equals(endWord)) {
                        List<String> newlist = new ArrayList<String>(list);
                        finalRes.add(newlist);
                    }
                }
            }
            if (needReturn) return finalRes;
            dict.removeAll(deleted);
            // res = temp;
            res.clear();
            for (List<String> lst : temp) {
                res.add(lst);
            }
            temp.clear();
        }
        res.clear();
        return res;
    }

    public List<String> getNeibors(String word, Set<String> set) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chrs = word.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                chrs[i] = j;
                String newStr = new String(chrs);
                if (set.contains(newStr)) {
                    list.add(newStr);
                }
            }
        }
        return list;
    }
}