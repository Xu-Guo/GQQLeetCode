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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        boolean pl = searchNode(root.left, p);
        boolean ql = searchNode(root.left, q);
        if (pl && ql) return lowestCommonAncestor(root.left, p, q);
        else if (!pl && !ql) return lowestCommonAncestor(root.right, p, q);
        else {
            return root;
        }
    }

    public boolean searchNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        boolean ls = searchNode(root.left, p);
        if (ls) return true;
        boolean rs = searchNode(root.right, p);
        if (rs) return true;
        return false;
    }
}