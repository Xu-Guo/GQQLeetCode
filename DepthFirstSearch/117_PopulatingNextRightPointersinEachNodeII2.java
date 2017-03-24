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
        TreeLinkNode lside = root;
        while (lside != null) {
            TreeLinkNode p = lside;
            TreeLinkNode nextCandi = null;
            while (p != null) {
                if (p.left == null && p.right == null) {
                    p = p.next;
                } else {
                    // first assign value next canidate.
                    if (nextCandi == null) {
                        if (p.left != null) nextCandi = p.left;
                        else nextCandi = p.right;
                    }
                    TreeLinkNode q = findHasChildrenAfterP(p);
                    TreeLinkNode nextNode = null;
                    if (q != null) nextNode = q.left == null ? q.right : q.left;
                    if (p.left != null && p.right != null) {
                        p.left.next = p.right;
                        p.right.next = nextNode;
                    } else if (p.left != null) {
                        p.left.next = nextNode;
                    } else {
                        p.right.next = nextNode;
                    }
                    p = q;
                }
            }
            lside = nextCandi;
        }
    }

    public TreeLinkNode findHasChildrenAfterP(TreeLinkNode p) {
        TreeLinkNode q = p.next;
        while (q != null && q.left == null && q.right == null) q = q.next;
        return q;
    }
}