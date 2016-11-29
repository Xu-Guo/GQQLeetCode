public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] is_visited = new boolean[nums.length];
        // 1. if you have used order, be sure use sort.
        Arrays.sort(nums);
        Arrays.fill(is_visited, false);
        backtrack(list, new ArrayList<Integer>(), nums, is_visited);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int[] nums, boolean[] is_visited) {
        if (tmplist.size() == nums.length) {
            // tmplist must a deep copy
            list.add(new ArrayList<Integer>(tmplist));
        } else {
            for (int i=0; i<nums.length; i++) {
                if (is_visited[i] || (i>0 && !is_visited[i-1] && nums[i]==nums[i-1])) {
                    continue;
                }
                tmplist.add(nums[i]);
                is_visited[i] = true;
                backtrack(list, tmplist, nums, is_visited);
                is_visited[i] = false;
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }
}