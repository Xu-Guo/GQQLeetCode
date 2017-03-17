public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", target, num, 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, String path, long target, String num, int pos, long eval, long last) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = pos + 1; i <= num.length(); i++) {
            String sub = num.substring(pos, i);
            if (sub.length() > 1 && sub.startsWith("0")) break;
            long curr = Long.parseLong(sub);
            if (pos == 0) {
                helper(res, path + sub, target, num, i, curr, curr);
            } else {
                helper(res, path + "+" + sub, target, num, i, eval + curr, curr);
                helper(res, path + "-" + sub, target, num, i, eval - curr, -curr);
                helper(res, path + "*" + sub, target, num, i, eval - last + last * curr, curr * last);
            }
        }
    }
}