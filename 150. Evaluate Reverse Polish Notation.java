public class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operaters = new HashSet<>();
        operaters.add("*");
        operaters.add("/");
        operaters.add("+");
        operaters.add("-");
        Stack<Integer> stack = new Stack<>();
        for (String tk : tokens) {
            if (operaters.contains(tk)) {
                int second = stack.pop();
                int first = stack.pop();
                int res = 0;
                if (tk.equals("+")) {
                    res = first + second;
                } else if (tk.equals("-")) {
                    res = first - second;
                } else if (tk.equals("*")) {
                    res = first * second;
                } else {
                    res = first / second;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tk));
            }
        }
        return stack.pop();
    }
}