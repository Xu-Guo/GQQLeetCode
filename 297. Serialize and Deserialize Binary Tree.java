/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "n";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n,");
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + ",");
            }
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("n")) return null;
        String[] datas = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (i < datas.length && !queue.isEmpty()) {
            TreeNode tn = queue.poll();
            String strleft = datas[i++];
            if (!strleft.equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(strleft));
                tn.left = left;
                queue.offer(left);
            }
            if (i == datas.length) break;
            String strright = datas[i++];
            if (!strright.equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(strright));
                tn.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));