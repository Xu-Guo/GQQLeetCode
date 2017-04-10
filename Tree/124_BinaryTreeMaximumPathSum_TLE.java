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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int max_left = maxPathSum(root.left);
        int max_right = maxPathSum(root.right);
        int left_val = getOneBranch(root.left);
        int right_val = getOneBranch(root.right);
        // int root_val = root.val;
        // root_val += left_val > 0 ? left_val : 0;
        // root_val += right_val > 0 ? right_val : 0;
        return Math.max(Math.max(max_left, max_right), root.val + left_val + right_val);
    }

    public int getOneBranch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Math.max(root.val, 0);
        }
        int res = root.val;
        int left = getOneBranch(root.left);
        int right = getOneBranch(root.right);
        int max = Math.max(left, right);
        if (max > 0) res += max;
        return Math.max(0, res);
    }
}