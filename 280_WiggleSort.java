public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 2) return;
        int mid = (n - 1) / 2;
        int j = mid % 2 == 0 ? mid + 2 : mid + 1;
        for (int i = 1; i <= mid; i += 2, j += 2) {
            // System.out.println(i);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}