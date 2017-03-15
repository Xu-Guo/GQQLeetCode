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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left;
        while (p != null) {
            if (p.val >= root.val) return false;
            p = p.right;
        }
        TreeNode q = root.right;
        while (q != null) {
            if (q.val <= root.val) return false;
            q = q.left;
        }
        // if (root.right != null && root.right.val <= root.val) return false;
        boolean l = isValidBST(root.left);
        boolean r = isValidBST(root.right);
        return l && r;
    }
}

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
    // using inorder travesal.
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode node = root.left;
        long min = Integer.MIN_VALUE - 1l;
        while (!s.isEmpty() || node != null) {
            if (node == null) {
                TreeNode tn = s.pop();
                if (tn.val <= min) return false;
                min = tn.val;
                node = tn.right;
            } else {
                s.push(node);
                node = node.left;
            }
        }
        return true;
    }
}