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
    int left = 0, right = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        res.add(new ArrayList<>());
        Queue<LevelTreeNode> queue = new LinkedList<>();
        queue.offer(new LevelTreeNode(0, root));
        while (!queue.isEmpty()) {
            LevelTreeNode ltn = queue.poll();
            if (ltn.level < left) {
                List<Integer> lst = new ArrayList<>();
                lst.add(ltn.node.val);
                res.add(0, lst);
                left = ltn.level;
            } else if (ltn.level > right) {
                List<Integer> lst = new ArrayList<>();
                lst.add(ltn.node.val);
                res.add(lst);
                right = ltn.level;
            } else {
                res.get(ltn.level - left).add(ltn.node.val);
            }
            
            if (ltn.node.left != null)
                queue.offer(new LevelTreeNode(ltn.level - 1, ltn.node.left));
                
            if (ltn.node.right != null)
                queue.offer(new LevelTreeNode(ltn.level + 1, ltn.node.right));
        }
        return res;
    }
}

class LevelTreeNode {
    public LevelTreeNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
    int level;
    TreeNode node;
}