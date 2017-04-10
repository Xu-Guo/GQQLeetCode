public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return doVerify(preorder, 0, preorder.length - 1);
    }

    public boolean doVerify(int[] pre, int st, int ed) {
        if (ed - st < 2) return true;
        int root = pre[st];
        int right_start = ed + 1;
        for (int i = st + 1; i <= ed; i++) {
            if (pre[i] > root) {
                right_start = i;
                break;
            }
        }
        for (int i = right_start; i <= ed; i++) {
            if (pre[i] < root) {
                return false;
            }
        }
        boolean left = doVerify(pre, st + 1, right_start - 1);
        boolean right = doVerify(pre, right_start, ed);
        return left && right;
    }
}