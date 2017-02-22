public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = {0, 0};
        if (n <= 1) return res;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i=1; i<n; i++) {
            int num = nums[i];
            int require = target - num;
            if (!map.containsKey(require)) {
                map.put(num, i);
            } else {
                res[0] = map.get(require);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}