public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k-n); i <= Math.min(k, m); i++) {
            // System.out.println(i);
            int[] surarr1 = getMaxSubArr(nums1, i);
            int[] surarr2 = getMaxSubArr(nums2, k-i);
            // System.out.println(Arrays.toString(surarr1));
            // System.out.println(Arrays.toString(surarr2));
            int[] res = merge(surarr1, surarr2);
            if (!greater(ans, 0, res, 0))
                ans = res;
        }
        return ans;
    }

    public int[] getMaxSubArr(int[] nums, int k) {
        int[] res = new int[k];
        int pos = 0;
        for (int i=0; i<nums.length; i++) {
            while ((pos>0) && (k-pos < nums.length-i) && (res[pos-1] < nums[i])) {
                pos--;
            }
            if (pos < k) {
                res[pos++] = nums[i];
            }
        }
        return res;
    }

    public boolean greater(int[] nums1, int pos1, int[] nums2, int pos2) {
        while(pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] > nums2[pos2]) return true;
            if (nums1[pos1] < nums2[pos2]) return false;
            pos1++;
            pos2++;
        }
        return pos1 != nums1.length;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int pos1 = 0, pos2 = 0, pos = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1 + len2];
        while (pos1 < len1 && pos2 < len2) {
            if (greater(nums1, pos1, nums2, pos2)) {
                res[pos++] = nums1[pos1++];
            } else {
                res[pos++] = nums2[pos2++];
            }
        }

        while (pos1 < len1) res[pos++] = nums1[pos1++];
        while (pos2 < len2) res[pos++] = nums2[pos2++];
        return res;
    }

}