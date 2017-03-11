public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Long> set = new HashSet<>();
        Set<Long> visited = new HashSet<>();
        // Arrays.stream().forEach(x -> set.add(x + 0l));
        for (int i=0; i < n; i++) {
            set.add(nums[i] + 0l);
        }
        int max = 0;
        for (int num : nums) {
            if (visited.contains(num + 0l)) continue;
            int cnt = 1;
            visited.add(num + 0l);
            // bigger count
            long step = 1l;
            while(set.contains(num + step)) {
                cnt++;
                visited.add(num + step);
                step++;
            }
            // smaller count
            step = 1l;
            while(set.contains(num - step)) {
                cnt++;
                visited.add(num - step);
                step++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}