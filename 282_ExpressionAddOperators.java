public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", target, num);
        return res;
    }

    public void helper(List<String> res, String temp, int target, String num) {
        if (num.equals("")) {
            return;
        }
        char num0= num.charAt(0);
        String str1 = num.substring(1);
        if (target.equals(num0 + "") && str1.equals("")) res.add(temp + num0);
        else {
            helper(res, temp + num0 + "+", target - Integer.parseInt(num0 + ""), str1);
            helper(res, temp + num0 + "-", Integer.parseInt(num0 + "") - target, str1);
        }
        for (int i=1; i<num.length(); i++) {
            String pre = num.substring(0, i + 1);
            String sub = num.substring(i + 1);
            if (target.equals(Integer.parseInt(pre)) && sub.equals("")) res.add(temp + pre);
            else{
                helper(res, temp + pre + "+", target - Integer.parseInt(pre), sub);
                helper(res, temp + pre + "-", Integer.parseInt(pre) - target, sub);
            }
            int val = Integer.parseInt(num.charAt(0) + "");
            String operators = num.charAt(0) + "*";
            for (int j=1; j<=i; j++) {
                operators += num.charAt(j) + "*";
                val *= Integer.parseInt(num.charAt(j) + "");
                if (target.equals(val) && sub.equals("")) res.add(temp + operators.substring(0, operators.length()-1));
                else {
                    helper(res, temp + operators.substring(0, operators.length()-1) + "+", target - val, sub);
                    helper(res, temp + operators.substring(0, operators.length()-1) + "-", val - target, sub);
                }
            }
        }
    }
}