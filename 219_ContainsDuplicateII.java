public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = map.getOrDefault(nums[i], i);
            if (idx < i && i - idx <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}