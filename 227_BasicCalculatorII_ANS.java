public class Solution {
    public int calculate(String s) {
        int num = 0;
        int sign = '+';
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // System.out.println(num);
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch(sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int re = 0;
        for (int e : st) {
            re += e;
        }
        return re;
    }
}