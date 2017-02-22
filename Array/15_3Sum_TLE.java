public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        if (n < 3) return res;
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                int target = -(nums[i] + nums[j]);
                if (isTargetExist(nums, j+1, n-1, target)) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(target);
                    set.add(lst);
                }
            }
        }
        res = new ArrayList(set);
        return res;
    }

    private boolean isTargetExist(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e-s)/2;
            if(nums[mid] == target) return true;
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}