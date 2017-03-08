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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    public int height(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int h = 1 + Math.max(height(node.left, res), height(node.right, res));
        if (res.size() <= h) {
            res.add(new ArrayList<Integer>());
        }
        res.get(h).add(node.val);
        return h;
    }
}