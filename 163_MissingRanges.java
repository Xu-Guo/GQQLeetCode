public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            // res.add(getMissing(lower, upper));
            String miss = getMissing(lower, upper);
            if (miss.length() > 0) res.add(miss);
            return res;
        }

        String pre = getMissing(lower, nums[0] - 1l);
        if (pre.length() > 0) res.add(pre);
        for (int i = 0; i < n - 1; i++) {
            String miss = getMissing(nums[i] + 1l, nums[i + 1] - 1l);
            if (miss.length() > 0) res.add(miss);
        }
        String tail = getMissing(nums[n - 1] + 1l, upper);
        if (tail.length() > 0) res.add(tail);
        return res;
    }

    public String getMissing(long low, long hi) {
        if (low < hi) {
            return low + "->" + hi;
        } else if (low == hi) {
            return low + "";
        }
        return "";
    }
}