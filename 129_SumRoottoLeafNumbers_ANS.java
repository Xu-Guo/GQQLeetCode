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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int s) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return s * 10 + root.val;
        }
        return helper(root.left, s * 10 + root.val) + helper(root.right, s * 10 + root.val);
    }


}