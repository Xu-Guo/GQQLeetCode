public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        int n = s.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean isover = false;
        HashSet<String> set = new HashSet<>();

        while (!queue.isEmpty() && !isover) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    if (!isover) isover = true;
                    res.add(str);
                }
                if (!isover) {
                    for (int j=0; j<str.length(); j++) {
                        if (str.charAt(j) == '(' || str.charAt(j) == ')') {
                            String substr = str.substring(0, j) + str.substring(j+1, str.length());
                            if (!set.contains(substr)) {
                                queue.offer(substr);
                                set.add(substr);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(c);
            if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}