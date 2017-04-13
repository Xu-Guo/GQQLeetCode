public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, 0, "", 0, word);
        return res;
    }

    public void helper(List<String> res, int pos, String curr, int count, String word) {
        if (pos == word.length()) {
            String str = curr + (count == 0 ? "" : count);
            res.add(str);
         } else {
            helper(res, pos + 1, curr, count + 1, word);
            helper(res, pos + 1, curr + (count == 0 ? "" : count) + word.charAt(pos), 0, word);
         }
    }
}