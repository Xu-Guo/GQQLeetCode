/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    this method using recurrsion.
    i as root, [0:i] as left, and [i+1, n] as right.
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<TreeNode>();
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int s, int e) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (s > e) {
            // TreeNode node = null;
            nodes.add(null);
            return nodes;
        }

        for (int i=s; i<=e; i++) {
            List<TreeNode> leftNodes = genTrees(s, i-1);
            List<TreeNode> rightNodes = genTrees(i+1, e);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }
}