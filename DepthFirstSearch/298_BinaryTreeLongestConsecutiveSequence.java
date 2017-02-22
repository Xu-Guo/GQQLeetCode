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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, Integer> cache = new HashMap<>();
        int longest = 1;
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> node = queue.poll();
            longest = Math.max(longest, getLength(node, cache));
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return longest;
    }

    public int getLength(TreeNode node, Map<TreeNode, Integer> cache) {
        if (node == null) return 0;
        if (cache.containsKey(node)) return cache.get(node);
        int maxDeep = 1;
        if (node.left != null && node.left.val == node.val + 1) {
            maxDeep = Math.max(maxDeep, getLength(node.left) + 1);
        }
        if (node.right != null && node.right.val == node.val + 1) {
            maxDeep = Math.max(maxDeep, getLength(node.right) + 1);
        }
        cache.put(node, maxDeep);
        return maxDeep;
    }
}