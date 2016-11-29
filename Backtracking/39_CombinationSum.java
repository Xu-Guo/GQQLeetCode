public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(lst, new ArrayList<>(), candidates, 0, target, 0);
        return lst;
    }

    private void backtrack(List<List<Integer>> lst, List<Integer> tmplist, int[] nums, int sum, int target, int start) {
        if (sum == target) {
            lst.add(new ArrayList<Integer>(tmplist));
        } else {
            for (int i=start; i<nums.length; i++) {
                tmplist.add(nums[i]);
                sum = tmplist.stream().mapToInt(Integer::intValue).sum();
                if (sum <= target) {
                    backtrack(lst, tmplist, nums, sum, target, i);
                }
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }
}