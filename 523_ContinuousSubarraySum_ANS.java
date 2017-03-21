public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(){{ put(0, -1) ;}}
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i];
            if (k != 0) sums %= k;
            if (map.containsKey(sums) && i - map.get(sums) > 1) return true;
            if (!map.containsKey(sums))
                map.put(sums, i);
        }
        return false;
    }
}