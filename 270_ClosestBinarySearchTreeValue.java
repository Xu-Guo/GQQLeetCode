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
    public int closestValue(TreeNode root, double target) {
        if (root.left == null && root.right == null) return root.val;
        if ((double)root.val == target) return root.val;
        int val = root.val;
        if (target < (double)root.val) {
            if (root.left != null)
                val = closestValue(root.left, target);
        } else {
            if (root.right != null)
                val = closestValue(root.right, target);
        }
        if (Math.abs(val - target) < Math.abs(root.val - target)) {
            return val;
        }
        return root.val;
    }

}