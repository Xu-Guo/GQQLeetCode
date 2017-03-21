public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        int maxlen = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                maxlen = Math.max(i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        
        return maxlen;
    }
}