public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int mtwo = nums[0];
        int mone = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
            int tmp = Math.max(mtwo + nums[i], mone);
            mtwo = mone;
            mone = tmp;
        }
        return mone;
    }
}