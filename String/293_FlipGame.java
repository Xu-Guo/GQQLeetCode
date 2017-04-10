public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length <= 1) return res;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i - 1, '-');
                sb.setCharAt(i, '-');
                res.add(sb.toString());
            }
        }
        return res;
    }
}