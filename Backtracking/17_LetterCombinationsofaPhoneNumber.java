public class Solution {
    private final String[][] dic = {{"a","b","c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j","k","l"}, {"m","n","o"}, {"p","q","r", "s"}, {"t","u","v"},{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0 || digits.contains("0") || digits.contains("1")) {
            return res;
        }
        res = getCharacters(digits);
        return res;
    }

    private List<String> getCharacters(String s) {
        List<String> res = new ArrayList<>();
        int n = Character.getNumericValue(s.charAt(0));
        String[] values = dic[n-2];
        if (s.length() == 1) {
            for (String v : values) {
                res.add(v);
            }
            return res;
        }
        for (String v : values) {
            List<String> subRes = getCharacters(s.substring(1, s.length()));
            for (String subv : subRes) {
                res.add(v + subv);
            }
        }
        return res;
    }
}