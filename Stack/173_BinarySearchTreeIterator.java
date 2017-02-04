/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private ArrayList<TreeNode> lst;
    private int index;
    public BSTIterator(TreeNode root) {
        lst = new ArrayList<>();
        index = 0;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while(!stk.isEmpty() || node != null) {
            if (node == null) {
                node = stk.pop();
                lst.add(node);
                node = node.right;
            } else {
                stk.push(node);
                node = node.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < lst.size()) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return lst.get(index++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */