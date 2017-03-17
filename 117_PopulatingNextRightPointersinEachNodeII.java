/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = queue.poll();
            for (int i = 1; i < size; i++) {
                TreeLinkNode after = queue.poll();
                if (after.left != null) queue.offer(after.left);
                if (after.right != null) queue.offer(after.right);
                pre.next = after;
                pre = after;
            }

        }
    }
}