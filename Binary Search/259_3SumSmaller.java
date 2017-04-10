public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i <= len - 3; i++) {
            int des = target - nums[i];
            // System.out.println("des "+des);
            int low = i + 1, hi = len - 1;
            while (low < hi) {
                int val = nums[low] + nums[hi];
                // System.out.println("val "+val);
                if (val < des) {
                    cnt += (hi - low);
                    low++;
                } else {
                    hi--;
                }
            }
        }
        return cnt;
    }

}