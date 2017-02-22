public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return res;
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            int target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum > target) k--;
                else if (sum < target) j++;
                else {
                    // List<Integer> lst = new ArrayList<>();
                    // lst.add(nums[i]);
                    // lst.add(nums[j]);
                    // lst.add(nums[k]);
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) j++;
                    while (j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                }

            }
        }
        return res;
    }

}