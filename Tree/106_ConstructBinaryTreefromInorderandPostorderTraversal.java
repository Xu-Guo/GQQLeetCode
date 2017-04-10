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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        if (s2 == e2) return new TreeNode(postorder[e2]);
        TreeNode root = new TreeNode(postorder[e2]);
        int idx = -1;
        for (int i = s1; i <= e1; i++) {
            if (inorder[i] == postorder[e2]) {
                idx = i;
                break;
            }
        }
        // System.out.println(idx);
        root.left = buildTree(inorder, postorder, s1, idx - 1, s2, idx - 1 -s1 + s2);
        root.right = buildTree(inorder, postorder, idx + 1, e1, idx - s1 + s2, e2 - 1);
        return root;
    }
}