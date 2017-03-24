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
        if (root == null || root.left == null) return;
        root.next = null;
        int level = 1;
        updateSons(root, root.next);
        TreeLinkNode lnode = root.left;
        while (lnode.left != null) {
            TreeLinkNode p = lnode;
            for (int i = 0; i < Math.pow(2, level); i++) {
                updateSons(p, p.next);
                p = p.next;
            }
            ++level;
            lnode = lnode.left;
        }
    }

    public void updateSons(TreeLinkNode p, TreeLinkNode pnext) {
        p.left.next = p.right;
        if (pnext != null) {
            p.right.next = pnext.left;
        }
    }
}