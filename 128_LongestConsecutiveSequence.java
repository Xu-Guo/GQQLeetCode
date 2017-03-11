public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] visited = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(nums[i], i);
        }
        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, helper(visited, map, nums[i]));
        }
        return max;
    }

    public int helper(int[] visited, Map<Integer, Integer> map, int val) {
        if (!map.containsKey(val)) return 0;
        int i = map.get(val);
        if (visited[i] == 1) return 0;
        
        visited[i] = 1;
        int left = helper(visited, map, val - 1);
        int right = helper(visited, map, val + 1);
        return 1 + left + right;
    }
}