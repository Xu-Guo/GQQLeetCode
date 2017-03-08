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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int currCnt = 1;
        int nextCnt = 0;
        queue.offer(root);
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextCnt++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextCnt++;
            }
            tmp.add(node.val);
            if (--currCnt == 0) {
                currCnt = nextCnt;
                nextCnt = 0;
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
            }
        }
        return res;
    }
}