public class Solution {
    public int firstMissingPositive(int[] nums) {
        // using quick sort method, put all positive data to the left.
        int k = partition(nums);
        int temp = 0;
        // System.out.print(k);
        for (int i=0; i<k; i++) {
            temp = Math.abs(nums[i]);
            if (temp <= k) {
                nums[temp-1] = nums[temp-1] > 0 ? -nums[temp-1] : nums[temp-1];
            }
        }
        // int firstMissingIndex = 0;
        for (int i=0; i<nums.length; i++) {
            // System.out.println(nums[i]);
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return k + 1;
    }

    // you must familar with quick sort.
    public int partition(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            while(low<=high && nums[low] > 0) low++;
            while(low<=high && nums[high] <= 0) high--;
            if (low < high) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                low++;
                high--;
            }
        }
        return low;
    }
}