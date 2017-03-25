public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                helper(nums, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}