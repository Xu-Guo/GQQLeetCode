public class Solution {
    private final String[] dics = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        if(digits.length()==0 || digits.contains("0") || digits.contains("1")) return ret;
        ret.add("");
        for (int i=0; i<digits.length(); i++) {
            int pos = Character.getNumericValue(digits.charAt(i));
            while(i == ret.get(0).length()) {
                cur = ret.remove(0);
                for (char x : dics[pos].toCharArray()) {
                    ret.add(cur + x);
                }
            }
        }
        return ret;
    }
}