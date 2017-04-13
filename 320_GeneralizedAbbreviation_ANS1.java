public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word.lenth() == 0) {
            res.add("");
            return res;
        }
        res.add(word.lenth());
        for (int i = 0; i < word.lenth(); i++) {
            List<String> substrs = generateAbbreviations(word.substring(i + 1));
            String left = i == 0 ? "" : String.valueOf(i);
            for (String sub : substrs) {
                res.add(left + word.substring(i, i + 1) + right);
            }
        }
        return res;
    }
}