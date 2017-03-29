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
    boolean isok = false;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        findError(root, true, Integer.MIN_VAL);
        // findError(root.right, true, root.val);
    }

    public TreeNode findError(TreeNode root, boolean isBigger, int pVal) {
        if (isok) return null;
        if (root == null) return null;
        if (isBigger) {
            if (root.val < pVal) return root;
        }
        if (!isBigger) {
            if (root.val > pVal) return root;
        }
        TreeNode leftErr = findError(root.left, false, root.val);
        TreeNode rightErr = findError(root.right, true, root.val);
        if (leftErr != null && rightErr != null) {
            int temp = leftErr.val;
            leftErr.val = rightErr.val;
            rightErr.val = temp;
            isok = true;
        } else if (leftErr != null) {
            int temp = leftErr.val;
            leftErr.val = root.val;
            root.val = temp;
            isok = true;
        } else if (rightErr != null) {
            int temp = rightErr.val;
            rightErr.val = root.val;
            root.val = temp;
            isok = true;
        }
    }
}