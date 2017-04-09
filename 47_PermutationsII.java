public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] == nums[i]) break;
            }
            if (j != -1 && !tmp.contains(j)) continue;

            tmp.add(i);
            helper(nums, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}