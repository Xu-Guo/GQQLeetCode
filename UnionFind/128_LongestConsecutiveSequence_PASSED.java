public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(nums[i] + 0l, i);
        }
        boolean[] visited = new boolean[n];
        int max = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            int cnt = 1;
            visited[i] = true;
            // count bigger numbers
            long step = 1l;
            while (map.containsKey(nums[i] + step)) {
                cnt++;
                visited[map.get(nums[i] + step++)] = true;
            }
            // count smaller numbers
            step = -1l;
            while (map.containsKey(nums[i] + step)) {
                cnt++;
                visited[map.get(nums[i] + step--)] = true;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}