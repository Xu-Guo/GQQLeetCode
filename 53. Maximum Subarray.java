public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxCurr = nums[0], maxSofar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurr = maxCurr >= 0 ? maxCurr + nums[i] : nums[i];
            maxSofar = Math.max(maxSofar, maxCurr);
        }
        return maxSofar;
    }
}