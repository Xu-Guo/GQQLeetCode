public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int low = 0, high = 0;

        while (high < n){
            while (high + 1 < n && nums[high] + 1 == nums[high + 1]) ++high;
            StringBuilder sb = new StringBuilder();
            if (low < high) sb.append(nums[low] + "->");
            sb.append(nums[high]);
            res.add(sb.toString());
            low = ++high;
        }
        return res;
    }
}