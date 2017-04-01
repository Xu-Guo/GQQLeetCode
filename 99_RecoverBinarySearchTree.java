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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null || !st.isEmpty()) {
            if (node == null) {
                TreeNode tn = st.pop();
                if (second != null) {
                    if (tn.val < second.val) {
                        second = tn;
                    }
                } else if (pre != null && pre.val > tn.val) {
                    first = pre;
                    second = tn;
                }
                pre = tn;
                node = tn.right;
            } else {
                st.push(node);
                node = node.left;
            }
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}