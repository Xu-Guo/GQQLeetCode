public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int old = nums[0];
        int curr1 = old;
        for (int i=2; i<nums.length-1; i++) {
            int nowM = Math.max(old+nums[i], curr1);
            old = curr1;
            curr1 = nowM;
        }
        old = nums[1];
        int curr2 = Math.max(old, nums[2]);
        for (int i=3; i<nums.length; i++) {
            int nowM = Math.max(old+nums[i], curr2);
            old = curr2;
            curr2 = nowM;
        }

        return Math.max(curr1, curr2);
    }
}