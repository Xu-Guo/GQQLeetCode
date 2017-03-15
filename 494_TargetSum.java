public class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        count(nums, 0, S);
        return cnt;
    }
    
    public void count(int[] nums, int start, int S) {
        if (start == nums.length) {
            if (S == 0) cnt++;
            return;
        }
        // for (int i = start; i)
        count(nums, start + 1, S - nums[start]);
        count(nums, start + 1, S + nums[start]);
    }
}