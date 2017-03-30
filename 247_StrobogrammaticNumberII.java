public class Solution {
    public List<String> findStrobogrammatic(int n) {
        int[] nums = {0, 9, 6, 1, 8};
        int[] mids = {0, 1, 8};
        List<String> res = new ArrayList<>();
        if (n == 1) {
            for (int mid : mids) {
                res.add(mid + "");
            }
            return res;
        }
        List<String> subres = new ArrayList<>();
        helper(subres, new StringBuilder(), nums, n / 2);
        if (n % 2 == 1) {
            for (int mid : mids) {
                for (String sub : subres) {
                    res.add(mkString(sub, mid + ""));
                }
            }
        } else {
            for (String sub : subres) {
                res.add(mkString(sub, ""));
            }
        }
        return res;
    }

    public String mkString(String sub, String mid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == '6') sb.append("9");
            else if (sub.charAt(i) == '9') sb.append("6");
            else sb.append(sub.charAt(i));
        }
        return sub + mid + sb.reverse().toString();
    }

    public void helper(List<String> res, StringBuilder sb, int[] nums, int n) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number == 0 && sb.length() == 0) continue;
            sb.append(number);
            helper(res, sb, nums, n);
            sb.setLength(sb.length() - 1);
        }
    }
}