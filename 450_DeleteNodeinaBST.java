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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val != key) {
            TreeNode parent = root;
            TreeNode keyNode = null;
            boolean leftChild = true;
            while (parent != null) {
                if (key < parent.val) {
                    if (parent.left.val == key) {
                        keyNode = parent.left;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right.val == key) {
                        keyNode = parent.right;
                        leftChild = false;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }

            // 1. isleaf
            if (keyNode.left == null && keyNode.right == null) {
                if (leftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            } else if (keyNode.left != null && keyNode.right == null) {
                // 2. left is no null
                if (leftChild) {
                    parent.left = keyNode.left;
                } else {
                    parent.right = keyNode.left;
                }
            } else if (keyNode.left == null && keyNode.right != null) {
                // 3. right is no null
                if (leftChild) {
                    parent.left = keyNode.right;
                } else {
                    parent.right = keyNode.right;
                }
            } else {
                // 4.left not null, right not null.
                TreeNode newroot = replaceNode(keyNode);
                if (leftChild) {
                    parent.left = newroot;
                } else {
                    parent.right = newroot;
                }
            }
        } else {
            // 1. isleaf
            TreeNode keyNode = root;
            if (keyNode.left == null && keyNode.right == null) {
                return null;
            } else if (keyNode.left != null && keyNode.right == null) {
                // 2. left is no null
                TreeNode newroot = root.left;
                root.left = null;
                return newroot;
            } else if (keyNode.left == null && keyNode.right != null) {
                // 3. right is no null
                return root.right;
            } else {
                // 4.left not null, right not null.
                TreeNode newroot = replaceNode(keyNode);
                return newroot;
            }
        }
    }

    // root has left and right.
    public TreeNode replaceNode(TreeNode root) {
        if (root.left.right == null) {
            root.left.right = root.right;
            return root.left;
        }
        TreeNode p = root.left;
        while (p.right.right != null) p = p.right;
        root.val = p.right.val;
        p.right = p.right.left;
        return root;
    }
}