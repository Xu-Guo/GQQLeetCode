public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;
        Arrays.sort(nums);
        for (int i=0; i<n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int newtarget = target - (nums[i] + nums[j]);
                int start = j+1, end = n-1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum > newtarget) end--;
                    else if (sum < newtarget) start++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start + 1] == nums[start]) start++;
                        while (start < end && nums[end - 1] == nums[end]) end--;
                        start++;
                        end--;
                    }

                }
            }
        }
        return res;
    }
}