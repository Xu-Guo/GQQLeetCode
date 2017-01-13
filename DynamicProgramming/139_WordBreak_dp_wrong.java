public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<int[]> lst = new ArrayList<>();
        // init list
        for (String word : wordDict) {
            int start = 0;
            while(start < s.length()) {
                int index = s.indexOf(word, start);
                if (-1 == index) {
                    break;
                } else {
                    int[] r = {index, index+word.length()};
                    lst.add(r);
                    start = index + 1;
                }
            }
            
        }

        List<List<int[]>> res = new ArrayList<>();
        List<int[]> firstRow = new ArrayList<>(lst);
        res.add(firstRow);
        int leng = lst.size();
        for (int i=0; i<leng; i++) {
            int[] rowVal = lst.get(i);
            List<int[]> nowRow = res.get(i);
            List<int[]> newRow = new ArrayList<>();
            for (int j=0; j<leng; j++) {
                int[] colVal = nowRow.get(j);
                int[] newVal = {colVal[0], colVal[1]};
                if (rowVal[1] == colVal[0]) {
                    newVal[0] = rowVal[0];
                    newVal[1] = colVal[1];
                }
                if (rowVal[0] == colVal[1]) {
                    newVal[0] = colVal[0];
                    newVal[1] = rowVal[1];
                }
                if (newVal[0] == 0 && newVal[1] == leng) {
                    return true;
                }
                newRow.add(newVal);
            }
        }
        return false;
    }
}