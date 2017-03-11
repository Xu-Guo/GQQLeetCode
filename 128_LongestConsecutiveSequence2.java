public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Long> set = new HashSet<>();
        Arrays.stream().forEach(x -> set.add(x + 0l));
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num + 0l)) continue;
            int cnt = 1;
            set.remove(num);
            // bigger count
            long step = 1l;
            while(set.contains(num + step)) {
                cnt++;
                set.remove(num + step);
                step++;
            }
            // smaller count
            step = 1l;
            while(set.contains(num - step)) {
                cnt++;
                set.remove(num - step);
                step++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}