public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return searchMaxNumber(nums1, 0, nums2, 0, k, nums1.length, nums2.length);
    }

    public int[] searchMaxNumber(int[] nums1, int left1, int[] nums2, int left2, int k, int m, int n) {
        int[] res = new int[k];
        
        int right1 = Math.min(m - 1, m + n - left2 - k);
        int right2 = Math.min(n - 1, m + n - left1 - k);
        int mIdex1 = findMaxIndex(nums1, left1, right1);
        int mIdex2 = findMaxIndex(nums2, left2, right2);
        int value1 = Integer.MIN_VALUE, value2 = Integer.MIN_VALUE;
        if (mIdex1 > -1) value1 = nums1[mIdex1];
        if (mIdex2 > -1) value2 = nums2[mIdex2];
        if (k == 1) {
            res[0] = Math.max(value1, value2);
            return res;
        }
        if (value1 > value2) {
            int[] subres = searchMaxNumber(nums1, mIdex1 + 1, nums2, left2, k - 1, m, n);
            res[0] = value1;
            System.arraycopy(subres, 0, res, 1, k - 1);
        } else if (value2 > value1) {
            int[] subres = searchMaxNumber(nums1, left1, nums2, mIdex2 + 1, k - 1, m, n);
            res[0] = value2;
            System.arraycopy(subres, 0, res, 1, k - 1);
        } else {
            res[0] = value1;
            int[] subres1 = searchMaxNumber(nums1, mIdex1 + 1, nums2, left2, k - 1, m, n);
            int[] subres2 = searchMaxNumber(nums1, left1, nums2, mIdex2 + 1, k - 1, m, n);
            if (compareArray(subres1, subres2) >= 0) {
                System.arraycopy(subres1, 0, res, 1, k - 1);
            } else {
                System.arraycopy(subres2, 0, res, 1, k - 1);
            }
        }

        return res;
    }

    public int compareArray(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                return 1;
            } else if (nums1[i] < nums2[i]) {
                return -1;
            }
        }
        return 0;
    }

    public int findMaxIndex(int[] nums, int left, int right) {
        if (left > right) return -1;
        int maxValue = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }
}