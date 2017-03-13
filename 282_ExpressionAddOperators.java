public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", target, num);
        return res;
    }

    public void helper(List<String> res, String temp, int target, String num) {
        if (num.equals("")) {
            if (target == 0)
                res.add(temp.substring(0, temp.length() - 1));
            return;
        }
        helper(res, temp + num.charAt(0) + "+", target - Integer.parseInt(num.charAt(0) + ""), num.substring(1));
        helper(res, temp + num.charAt(0) + "-", target + Integer.parseInt(num.charAt(0) + ""), num.substring(1));
        for (int i=1; i<num.length(); i++) {
            String pre = num.substring(0, i + 1);
            String sub = num.substring(i + 1);
            helper(res, temp + pre + "+", target - Integer.parseInt(pre), sub);
            helper(res, temp + pre + "-", target + Integer.parseInt(pre), sub);
            int val = Integer.parseInt(num.charAt(0) + "");
            String operators = num.charAt(0) + "*";
            for (int j=1; j<=i; j++) {
                operators += num.charAt(j) + "*";
                val *= Integer.parseInt(num.charAt(j) + "");
                helper(res, temp + operators.substring(0, operators.length()-1), target - val, sub);
                helper(res, temp - operators.substring(0, operators.length()-1), target + val, sub);
            }
        }
    }
}