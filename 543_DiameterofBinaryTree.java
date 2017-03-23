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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int through_root = getHight(root.left) + getHight(root.right);
        return Math.max(Math.max(left, right), through_root);
    }

    public int getHight(TreeNode node) {
        if (node == null) return 0;
        int left = getHight(node.left);
        int right = getHight(node.right);
        return Math.max(left, right) + 1;
    }
}