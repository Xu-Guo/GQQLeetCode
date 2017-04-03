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

    public int height(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int hi = 1 + Math.max(height(root.left, res), height(root.right, res));
        if (res.size() <= hi) {
            res.add(new ArrayList<Integer>() {{ add(root.val); }});
        } else {
            res.get(hi).add(root.val);
        }
        return hi;
    }
}