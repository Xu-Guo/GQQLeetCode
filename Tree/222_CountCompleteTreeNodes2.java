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
    public int height(TreeNode node) {
        return node == null ? 0 : 1 + height(node.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h <= 1) return h;
        int h_r = height(root.right);
        if (h_r + 1 == h) {
            // last node in right subtree
            return (1 << h_r) + countNodes(root.right);
        } else {
            // last node in left. right has hight h_r
            return (1 << h_r) + countNodes(root.left);
        }
    }
}