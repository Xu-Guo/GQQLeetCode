public class Solution {
    public void sortColors(int[] nums) {
        int rn = 0, wn = 0, bn = 0;
        for (int num : nums) {
            if (num == 0) rn++;
            if (num == 1) wn++;
            if (num == 2) bn++;
        }
        for (int i=0; i<nums.length; i++) {
            if (i < rn) nums[i] = 0;
            else if (i >= rn + wn) nums[i] = 2;
            else nums[i] = 1;
        }
    }

    public void sortColors(int[] nums) {
        // first round, move 0 to left.
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] == 0) i++;
            while (i < j && nums[j] > 0) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[j] == 2) j--;
            while (i < j && nums[i] < 2) i++;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}