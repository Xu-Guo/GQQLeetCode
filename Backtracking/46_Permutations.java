public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtract(list, new ArrayList<Integer>(), nums);
        return list;
    }

    public void backtract(List<List<Integer>> list, List<Integer> tmplist, int[] nums) {
        if (tmplist.size() == nums.length) {
            list.add(new ArrayList<Integer>(tmplist));
        } else {
            for (int i=0; i<nums.length; i++) {
                if (tmplist.contains(nums[i])) {
                    continue;
                }
                tmplist.add(nums[i]);
                backtract(list, tmplist, nums);
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }
}