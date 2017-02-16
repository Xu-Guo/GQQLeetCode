public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n <= 0) return 0;
        long[] prefixArray = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i - 1];
        }
        return countAndMergeSort(prefixArray, 0, n, lower, upper);
    }

    // thinking we have two soered arrays. left is from low to mid, right is from mid + 1 to high.
    // we just need to use merge sort count and merge the two array to one
    public int countAndMergeSort(long[] prefixArray, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = countAndMergeSort(prefixArray, left, mid, lower, upper) + countAndMergeSort(prefixArray, mid + 1, right, lower, upper);

        int i = left, j = mid + 1, k = mid + 1, p = 0, q = mid + 1;
        long[] mergedArray = new long[right - left + 1];
        // System.out.println("left:"+left+" right:"+right);
        while (i <= mid) {
            while (j <= right && prefixArray[j] - prefixArray[i] < lower) j++;
            while (k <= right && prefixArray[k] - prefixArray[i] <= upper) k++;
            count += (k - j);
            
            while (q <= right && prefixArray[q] < prefixArray[i]) mergedArray[p++] = prefixArray[q++];
            mergedArray[p++] = prefixArray[i++];
        }

        while (q <= right) mergedArray[p++] = prefixArray[q++];

        System.arraycopy(mergedArray, 0, prefixArray, left, right - left + 1);
        return count;
    }
    
}