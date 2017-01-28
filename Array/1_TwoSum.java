public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int[] result = {map.get(target - nums[i]), i};
                return result;
            } else {
                map.put(nums[i],i);
            }
        }

        int[] error = {-1, -1};
        return error;
    }
}