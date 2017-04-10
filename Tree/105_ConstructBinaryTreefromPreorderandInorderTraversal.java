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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        if (s1 == e1) {
            TreeNode tn = new TreeNode(preorder[s1]);
            return tn;
        }
        TreeNode root = new TreeNode(preorder[s1]);
        int idx = -1;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                idx = i;
                break;
            }
        }

        root.left = buildTree(preorder, inorder, s1 + 1, idx - s2 + s1, s2, idx - 1);
        root.right = buildTree(preorder, inorder, idx - s2 + s1 + 1, e1, idx + 1, e2);
        return root;
    }
}