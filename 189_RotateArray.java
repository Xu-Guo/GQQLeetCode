public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        for (int i = 0; i< n; i++) nums[i] = res[i];
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k %= n;
        for (int i = 0; i < k; i++) {
            int old = nums[n - 1];
            for (int j = 1; j < n; j++) {
                nums[j] = nums[j - 1]
            }
            nums[0] = old;
        }
    }
}