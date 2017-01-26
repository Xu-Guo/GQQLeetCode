public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        int n = numbers.length;
        if (n < 2) {
            return result;
        }
        int low = 0, high = n-1;
        for (int i=low; i<high && numbers[i]<target; i++) {
            if (numbers[i] + numbers[high] < target) {
                continue;
            }
            int tp = findIndex(numbers, i+1, high, target-numbers[i]);
            if (tp != -1) {
                result[0] = i + 1;
                result[1] = tp + 1;
                return result;
            }
        }
        return result;
    }

    private int findIndex(int[] numbers, int low, int high, int target) {
        if (numbers[low] > target || numbers[high] < target) {
            return -1;
        }
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (numbers[mid] == target) {
                return mid;
            } else if (target < numbers[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}