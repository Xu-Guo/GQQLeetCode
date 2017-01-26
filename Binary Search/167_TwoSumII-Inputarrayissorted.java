public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        int n = numbers.length;
        if (n < 2) {
            return result;
        }
        int low = 0, high = n - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (target - numbers[mid] < numbers[mid]) {
                if (target == numbers[low] + numbers[mid]) {
                    result[0] = low;
                    result[1] = mid;
                    return result;
                }
                high = mid;
            } else if(target - numbers[mid] > numbers[mid]) {
                if (target == numbers[low] + numbers[mid]) {
                    result[0] = low;
                    result[1] = mid;
                    return result;
                }
                high = mid;
            }
        }
    }
}