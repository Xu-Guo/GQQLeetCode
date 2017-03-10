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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<String> subleft = binaryTreePaths(root.left);
        List<String> subright =binaryTreePaths(root.right);
        if (subleft.size() == 0 && subright.size() == 0) {
            res.add(root.val + "");
            return res;
        }
        if (subleft.size() > 0) {
            for (String str : subleft) {
                res.add(root.val + "->" + str);
            }
        }
        if (subright.size() > 0) {
            for (String str : subright) {
                res.add(root.val + "->" + str);
            }
        }
        return res;
    }
}