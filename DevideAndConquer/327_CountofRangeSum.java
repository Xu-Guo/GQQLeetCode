public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        return divideAndSum(nums, 0, nums.lengh-1, lower, upper);
    }

    public int divideAndSum(int[] nums, int start, int end, int lower, int upper) {
        if (start > end) return 0;
        if (start == end) {
            if (nums[start] >= lower && nums[start] <= upper) {
                return 1;
            }
            return 0;
        }
        int mid = start + (end - start) / 2;
        int num1 = divideAndSum(nums, start, mid, lower, upper);
        int num2 = divideAndSum(nums, mid + 1, end, lower, upper);
        return num1 + num2;
    }
}