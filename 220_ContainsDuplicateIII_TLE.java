public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < i + 1 + k && j < nums.length; j++) {
                if (Math.abs((long)nums[j] - (long)nums[i]) <= (long)t) return true;
            }
        }
        return false;
    }
}