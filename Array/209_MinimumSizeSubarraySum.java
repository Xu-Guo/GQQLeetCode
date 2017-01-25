public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int dis = Integer.MAX_VALUE;
        int sum = nums[left];
        while(right <= nums.length-1 && left <= right) {
            if(sum >= s) {
                dis = Math.min(dis, right-left+1);
                sum -= nums[left++];
            } else {
                if(++right == nums.length) break;
                sum += nums[right];
            }
        }
        return dis != Integer.MAX_VALUE ? dis : 0;
    }
}