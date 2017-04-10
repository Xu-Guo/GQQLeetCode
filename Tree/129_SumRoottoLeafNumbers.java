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
    public int sumNumbers(TreeNode root) {
        List<String> list = getNumbers(root);
        int sum = 0;
        for (String str : list) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    public List<String> getNumbers(TreeNode root) {
        ArrayList<String> res = new  ArrayList<String>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        if (root.left != null) {
            List<String> vals = getNumbers(root.left);
            for (String subval : vals) {
                res.add(root.val + subval);
            }
        }
        if (root.right != null) {
            List<String> vals = getNumbers(root.right);
            for (String subval : vals) {
                res.add(root.val + subval);
            }
        }
        return res;
    }

}