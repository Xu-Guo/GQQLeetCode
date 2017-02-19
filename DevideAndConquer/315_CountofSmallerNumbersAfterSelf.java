public class Solution {
    class TreeNode {
        TreeNode left, right;
        int dup, val, sum;
        public TreeNode(int val) {
            this.val = val;
            dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        if (n == 0) return res;
        res.add(0);
        TreeNode head = new TreeNode(nums[n - 1]);
        for (int i = n-2; i>=0; i--) {
            res.addFirst(doCaculation(nums[i], head));
        }
        return res;
    }

    public int doCaculation(int num, TreeNode head) {
        TreeNode p = head;
        TreeNode pre = head;
        int res = 0;
        while (p != null) {
            if (num < p.val) {
                // insert to left, p.sum++
                p.sum++;
                pre = p;
                p = p.left;
            } else if (num > p.val) {
                // insert to right, res + dup + sum.
                res += (p.dup + p.sum);
                pre = p;
                p = p.right;
            } else {
                // equal. dup++;
                res += p.sum;
                p.dup++;
                pre = p;
                break;
            }
        }
        if (num < pre.val) {
            // insert to left
            pre.left = new TreeNode(num);
        } else if (num > pre.val) {
            pre.right = new TreeNode(num);
        }
        return res;
    }
}