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
    public int countUnivalSubtrees(TreeNode root) {
        Ans ans = doCount(root);
        return ans.cnt;
    }

    public Ans doCount(TreeNode root) {
        if (root == null) return new Ans(true, 0);
        Ans leftCount = doCount(root.left);
        Ans rightCount = doCount(root.right);
        if (leftCount.isSame && rightCount.isSame && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            return new Ans(true, leftCount.cnt + rightCount.cnt + 1);
        }
        return new Ans(false, leftCount.cnt + rightCount.cnt);
    }
}

class Ans {
    boolean isSame;
    int cnt;
    public Ans(boolean same, int count) {
        isSame = same;
        cnt = count;
    }
}