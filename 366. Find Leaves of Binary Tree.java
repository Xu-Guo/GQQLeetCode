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
        List<List<Integer>> leftLves = findLeaves(root.left);
        List<List<Integer>> rightLves = findLeaves(root.right);

        int i = 0;
        for (; i < leftLves.size() && i < rightLves.size(); i++) {
            List<Integer> newItem = new ArrayList<Integer>(leftLves.get(i));
            newItem.addAll(rightLves.get(i));
            res.add(newItem);
        }

        while (i < leftLves.size()) res.add(new ArrayList<Integer>(leftLves.get(i++)));
        while (i < rightLves.size()) res.add(new ArrayList<Integer>(rightLves.get(i++)));
        res.add(new ArrayList<Integer>() {{ add(root.val);}});
        return res;
    }
}