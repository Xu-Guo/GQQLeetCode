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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Map<TreeNode, Integer> levels = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        levels.put(root, 0);
        parents.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                levels.put(node.left, levels.get(node) + 1);
                parents.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                levels.put(node.right, levels.get(node) + 1);
                parents.put(node.right, node);   
            }
        }

        Set<TreeNode> pset = new HashSet<>();
        pset.add(p);
        TreeNode h = parents.get(p);
        while (h != null) {
            pset.add(h);
            h = parents.get(h);
        }

        Set<TreeNode> qset = new HashSet<>();
        qset.add(q);
        h = parents.get(q);
        while (h != null) {
            qset.add(h);
            h = parents.get(h);
        }

        pset.retainAll(qset);
        TreeNode common = root;
        for (TreeNode n : pset) {
            if (levels.get(n) > levels.get(common)) {
                common = n;
            }
        }
        return common;
    }
}