/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int st, int ed) {
        if (st > ed) return null;
        if (st == ed) return new TreeNode(nums[st]);
        int mid = st + (ed - st) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, st, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, ed);
        return root;
    }
}