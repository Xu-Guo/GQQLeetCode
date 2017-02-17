public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        int mid = n / 2;
        list.add(nums[0]);
        int i = 1, j = mid + 1;
        while (i <= m && j < n) {
            list.add(nums[j++]);
            list.add(nums[i++]);
        }

        if (j == n - 1) list.add(nums[j]);
        for (int k = 0; k < list.size(); k++) nums[k++] = list.get(k++);
    }
}