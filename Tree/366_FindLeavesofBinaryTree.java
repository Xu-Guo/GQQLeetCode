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
        if (root == null) return res;
        while (!isLeaf(root)) {
            List<Integer> leftLeaves = getLeaves(root.left, root, true);
            List<Integer> rightLeaves = getLeaves(root.right, root, false);
            List<Integer> subres = new ArrayList<Integer>();
            if (leftLeaves != null) subres.addAll(leftLeaves);
            if (rightLeaves != null) subres.addAll(rightLeaves);
            res.add(subres);
        }
        res.add(Arrays.asList(root.val));
        return res;
    }

    public List<Integer> getLeaves(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) return null;
        if (isLeaf(root)) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            if (isLeft) parent.left = null;
            else parent.right = null;
            return tmp;
        }
        List<Integer> leftLeaves = getLeaves(root.left, root, true);
        List<Integer> rightLeaves = getLeaves(root.right, root, false);
        List<Integer> subres = new ArrayList<Integer>();
        if (leftLeaves != null) subres.addAll(leftLeaves);
        if (rightLeaves != null) subres.addAll(rightLeaves);
        return subres;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }
}