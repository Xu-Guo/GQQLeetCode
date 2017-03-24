public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        return helper(nums, 0, k, 0);
    }

    public boolean helper(int[] nums, int sum, int k, int start) {
        if (sum % k == 0) return true;
        for (int i = start; i < nums.length; i++) {
            boolean res = helper(nums, sum + nums[start], k, i + 1);
            if (res) return res;
        }
        return false;
    }
}