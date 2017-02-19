public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> lst = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int idx = getCurrentIndex(nums, i, n - 1);
            lst.addFirst(idx - i);
        }
        return lst;
    }

    private int getCurrentIndex(int[] nums, int left , int right) {
        int p = left + 1;
        int curr = nums[left];
        while (p <= right && nums[p] < curr) p++;
        p--;
        for (int i = left; i < p; i++) {
            nums[i] = nums[i+1];
        }
        nums[p] = curr;
        return p;
    }
}