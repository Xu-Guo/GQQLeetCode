public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 0..n-k-1, n-k,n-1
        int low = 0, hi = n - k - 1;
        while (low < hi) {
            swap(nums, low++, hi--);
        }
        low = n - k;
        hi = n - 1;
        while (low < hi) {
            swap(nums, low++, hi--);
        }
        low = 0;
        hi = n - 1;
        while (low < hi) {
            swap(nums, low++, hi--);
        }
    }

    public void swap(int[] nums, int low, int hi) {
        int tmp = nums[low];
        nums[low] = nums[hi];
        nums[hi] = tmp;
    }
}