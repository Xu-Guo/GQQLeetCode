public class Solution {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        Stack<String> stack = new Stack<>();
        s = s.trim();
        int idx = 0;
        while (idx < s.length()) {
            char c1 = s.charAt(idx);
            String c = "";
            if (c1 >= '0' && c1 <= '9') {
                // string
                while (c1 >= '0' && c1 <= '9') {
                    c += c1;
                    if (++idx == s.length()) break;
                    c1 = s.charAt(idx);
                }
            } else if (c1 == ' ') {
                idx++;
                continue;
            } else {
                c = c1 + "";
                idx++;
            }
            
            // System.out.println(c);
            if (c.equals("*") || c.equals("/")) {
                stack.push(c);
            } else if (c.equals("+") || c.equals("-")) {
                if (stack.size() == 3) {
                    int two = Integer.parseInt(stack.pop());
                    String oprater = stack.pop();
                    int one = Integer.parseInt(stack.pop());
                    int res = oprater.equals("+") ? one + two : one - two;
                    stack.push(res + "");
                }
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                String oprater = stack.peek();
                if (oprater.equals("*") || oprater.equals("/")) {
                    stack.pop();
                    int one = Integer.parseInt(stack.pop());
                    int two = Integer.parseInt(c);
                    int res = oprater.equals("*") ? one * two : one / two;
                    stack.push(res + "");
                } else {
                    stack.push(c);
                }
            }
        }
        // System.out.println(stack.size());
        if (stack.size() == 3) {
            int two = Integer.parseInt(stack.pop());
            String oprater = stack.pop();
            int one = Integer.parseInt(stack.pop());
            int res = oprater.equals("+") ? one + two : one - two;
            stack.push(res + "");
        }
        return Integer.parseInt(stack.pop());
    }
}