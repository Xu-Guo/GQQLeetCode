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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode tn1 = leftQueue.poll();
            TreeNode tn2 = rightQueue.poll();
            if (tn1 != null && tn2 == null) return false;
            if (tn2 != null && tn1 == null) return false;
            if (tn1 != null && tn2 != null) {
                if (tn1.val != tn2.val) return false;
                leftQueue.offer(tn1.left);
                leftQueue.offer(tn1.right);
                rightQueue.offer(tn2.right);
                rightQueue.offer(tn2.left);
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}