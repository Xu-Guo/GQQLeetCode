public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] s = new int[n];
        int max = 0;
        s[0] = nums[0];
        if (s[0] == k) max = 1;
        for (int i=1; i<n; i++) {
            s[i] = s[i-1] + nums[i];
            if (s[i] == k) max = Math.max(max, i+1);
        }
        // System.out.println(Arrays.toString(s));

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                s[j] -= s[i];
                if (s[j] == k) max = Math.max(max, j-i);
            }
            // System.out.println(Arrays.toString(s));
        }
        return max;
    }
}