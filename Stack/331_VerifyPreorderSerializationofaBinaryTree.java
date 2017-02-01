public class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        String[] orders = preorder.split(",");
        int n = orders.length;
        for(int i=0; i<n; i++) {
            String c = orders[i];
            if (c.equals("#")) {
                if (stack.isEmpty()) {
                    return i == n-1 ? true : false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return false;
    }
}