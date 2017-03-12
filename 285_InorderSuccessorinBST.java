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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) return null;
        TreeNode node = p.right;
        if (node != null) {
                while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (root.val < p.val) root = root.right;
        if (p == root) return null;
        TreeNode parent = inorderSuccessor(root.left, p);
        return parent != null ? parent : root;
    }

    // no recursion
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) return null;
        TreeNode node = p.right;
        if (node != null) {
                while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (root.val < p.val) root = root.right;
        if (p == root) return null;
        TreeNode parent = root;
        while (root != p) {
            if (root.val > p.val) {
                // if (root.left == p) return root;
                parent = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return parent;
    }
}