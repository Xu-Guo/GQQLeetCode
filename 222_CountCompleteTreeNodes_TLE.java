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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h1 = 0, h2 = 0;
        TreeNode p = root;
        while (p != null) {
            p = p.left;
            h1++;
        }
        p = root;
        while (p != null) {
            p = p.right;
            h2++;
        }
        if (h1 == h2) {
            // return (1 << h1) - 1;
            // if we use below languages, TLE!!!
            return (int)Math.pow(2, h1) - 1;
        }
        int leftCnt = countNodes(root.left);
        int rightCnt = countNodes(root.right);
        return leftCnt + rightCnt + 1;
    }
}