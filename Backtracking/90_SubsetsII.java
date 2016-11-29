public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmpRet = new ArrayList<Integer>();
        backtract(ret, tmpRet, nums, 0);
        return ret;
    }

    public void backtract(List<List<Integer>> ret, List<Integer> tmpRet, int[] nums, int start, int dup) {
        ret.add(new ArrayList<>(tmpRet));
        for (int i=start; i<nums.length; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                tmpRet.add(nums[i]);
                // take care about i+1, it is not start+1
                backtract(ret, tmpRet, nums, i+1);
                tmpRet.remove(tmpRet.size()-1);
            }
        }
    }
}

