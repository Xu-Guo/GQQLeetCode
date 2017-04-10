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
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    // }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                res.add(tmp);
            }
            return res;
        }

        if (root.left != null) {
            List<List<Integer>> vals = pathSum(root.left, sum - root.val);
            for (List<Integer> val : vals) {
                // System.out.println(val);
                List<Integer> sub = new ArrayList<Integer>(val);
                sub.add(0, root.val);
                res.add(sub);
            }
        }

        if (root.right != null) {
            List<List<Integer>> vals = pathSum(root.right, sum - root.val);
            for (List<Integer> val : vals) {
                List<Integer> sub = new ArrayList<Integer>(val);
                sub.add(0, root.val);
                res.add(sub);
            }
        }
        return res;

    }
}