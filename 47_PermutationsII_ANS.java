public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            // res.add(new ArrayList<Integer>(tmp));
            List<Integer> values = new ArrayList<>();
            tmp.forEach(idx -> values.add(nums[idx]));
            res.add(values);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(i)) continue;
            if (i - 1 >= 0 && nums[i - 1] == nums[i] && !tmp.contains(i - 1)) continue;

            tmp.add(i);
            helper(nums, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}