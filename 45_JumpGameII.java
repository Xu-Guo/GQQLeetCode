public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, n - 1);
        for (int i = n - 2; n >= 0; n--) {
            int val = n - 1 - i;
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j) - i <= nums[i]) {
                    val = 1 + j;
                }
            }
            map.put(val, i);
            if (i == 0) return val;
        }
        return -1;
    }
}