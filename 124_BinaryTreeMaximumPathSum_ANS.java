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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return max;
        }
        getMax(root);
        return max;
    }

    public int getMax(TreeNode root) {
        if (root == null) return 0;
        int left_val = Math.max(0, getMax(root.left));
        int right_val = Math.max(getMax(root.right), 0);
        max = Math.max(max, root.val + left_val + right_val);
        return Math.max(0, Math.max(root.val + right_val, root.val + left_val));
    }
}