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
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int s, int e) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (s > e) {
            return nodes;
        }
        if (s == e) {
            TreeNode node = new TreeNode(s);
            nodes.add(node);
            return nodes;
        }

        for (int i=s; i<=e; i++) {
            List<TreeNode> leftNodes = genTrees(s, i-1);
            List<TreeNode> rightNodes = genTrees(i+1, e);
            if (leftNodes.size() > 0) {
                for (TreeNode leftNode : leftNodes) {
                    initTrees(i, leftNode, rightNodes, nodes);
                }
            } else {
                initTrees(i, null, rightNodes, nodes);
            }
        }
        return nodes;
    }

    public void initTrees(int i, TreeNode leftNode, List<TreeNode> rights, List<TreeNode> nodes) {
        if (rights.size() == 0) {
            TreeNode node = new TreeNode(i);
            node.left = leftNode;
            nodes.add(node);
        } else {
            for (TreeNode rightNode : rights) {
                TreeNode node = new TreeNode(i);
                node.left = leftNode;
                node.right = rightNode;
                nodes.add(node);
            }
        }
    }
}