public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        doSearch(nums, target, res, 0, nums.length - 1);
        return res;
    }

    public void doSearch(int[] nums, int target, int[] res, int st, int ed) {
        if (st > ed) return;
        int mid = st + (ed - st) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] < target) res[0] = mid;
            else {
                doSearch(nums, target, res, st, mid - 1);
            }
            if (mid == nums.length - 1 || nums[mid + 1] > target) res[1] = mid;
            else {
                doSearch(nums, target, res, mid + 1, ed);
            }
        } else if (nums[mid] > target) {
            doSearch(nums, target, res, st, mid - 1);
        } else {
            doSearch(nums, target, res, mid + 1, ed);
        }
    }
}