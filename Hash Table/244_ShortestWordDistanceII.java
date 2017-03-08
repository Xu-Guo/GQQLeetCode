public class WordDistance {

    Map<String, List<Integer>> positions;
    public WordDistance(String[] words) {
        positions = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            String key = words[i];
            if (!positions.containsKey(key)) {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                positions.put(key, lst);
            } else {
                positions.get(key).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = positions.get(word1);
        List<Integer> list2 = positions.get(word2);
        int dis = Integer.MAX_VALUE;
        int m = list1.size(), n = list2.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            while (i < m && list1.get(i) < list2.get(j)) i++;
            if (i > 0) dis = Math.min(dis, Math.abs(list1.get(i-1) - list2.get(j)));
            if (i == m) break;
            while (j < n && list2.get(j) < list1.get(i)) j++;
            if (j > 0) dis = Math.min(dis, Math.abs(list1.get(i) - list2.get(j-1)));
        }
        return dis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */