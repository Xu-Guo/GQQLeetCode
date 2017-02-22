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
        return root ==null ? 0 : dfs(root, 0, root.val);
    }

    private int dfs(TreeNode root, int cnt, int target) {
        if (root == null) return 0;
        if (root.val == target) cnt++;
        else cnt = 1;
        int left = dfs(root.left, cnt, root.val + 1);
        int right = dfs(root.right, cnt, root.val + 1);
        return Math.max(cnt, Math.max(left, right));
    }
}