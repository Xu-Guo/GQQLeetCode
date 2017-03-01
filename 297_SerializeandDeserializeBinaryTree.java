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
        if (root == null) return "";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null == node) list.add("null");
            else list.add(String.valueOf(node.val));
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        while(list.size() > 0 && list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode nd = queue.poll();
            String strLeft = nodes[i++];
            if (!strLeft.equals("null")) {
                nd.left = new TreeNode(Integer.parseInt(strLeft));
                queue.offer(nd.left);
            }
            if (i == nodes.length) break;
            String strRight = nodes[i++];
            if (!strRight.equals("null")) {
                nd.right = new TreeNode(Integer.parseInt(strRight));
                queue.offer(nd.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));