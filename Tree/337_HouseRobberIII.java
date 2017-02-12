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
    public int rob(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left && null == root.right) return root.val;
        else if (null == root.left) {
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        } else if (null == root.right) {
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        }
        return Math.max(root.val + rob(root.right.left) + rob(root.right.right) + rob(root.left.left) + rob(root.left.right), rob(root.left) + rob(root.right));
    }
}