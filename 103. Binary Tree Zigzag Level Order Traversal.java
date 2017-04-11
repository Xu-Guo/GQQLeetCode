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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cntent = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.poll();
                if (level % 2 == 0) cntent.add(tn.val);
                else {
                    cntent.add(0, tn.val);
                }
                if (tn.left != null) q.offer(tn.left);
                if (tn.right != null) q.offer(tn.right);
            }
            level++;
            res.add(cntent);
        }
        return res;
    }
}