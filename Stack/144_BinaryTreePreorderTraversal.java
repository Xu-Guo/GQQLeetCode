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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        // stack.push(root);
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                results.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tn = stack.pop();
                node = tn.right;
            }
        }
        return results;
    }
}