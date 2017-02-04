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
    public List<Integer> postorderTraversal(TreeNode root) {
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while(!stk.isEmpty() || node != null){
            if (node == null) {
                node = stk.pop();
            } else {
                if (node.left != null && !visited.contains(node.left)) {
                    stk.push(node);
                    node = node.left;
                } else if (node.right != null && !visited.contains(node.right)) {
                    stk.push(node);
                    node = node.right;
                } else {
                    results.add(node.val);
                    visited.add(node);
                    node = null;
                }
            }
        }
        return results;
    }
}