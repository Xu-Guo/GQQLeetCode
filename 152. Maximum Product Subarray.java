public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int res = max[0];
        for (int i = 1; i < n; i++) {
            int number = nums[i];
            if (number < 0) {
                max[i] = Math.max(number, number * min[i - 1]);
                min[i] = Math.min(number, number * max[i - 1]);
            } else {
                max[i] = Math.max(number, number * max[i - 1]);
                min[i] = Math.min(number, number * min[i - 1]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }

    // just using o(1) space
     // just using o(1) space
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int premax = nums[0], premin = nums[0], res = nums[0];
        int minsofar = 0, maxsofar = 0;
        for (int i = 1; i < n; i++) {
            int number = nums[i];
            if (number < 0) {
                minsofar = Math.min(number, number * premax);
                maxsofar = Math.max(number, number * premin);
            } else {
                minsofar = Math.min(number, number * premin);
                maxsofar = Math.max(number, number * premax);
            }
            res = Math.max(res, maxsofar);
            premin = minsofar;
            premax = maxsofar;
        }
    return res;
}