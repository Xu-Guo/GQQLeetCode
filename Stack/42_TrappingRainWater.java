public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i=0; i < n; i++) {
            if (stack.size() == 0 || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else {
                while(stack.size() > 0 && height[stack.peek()] <= height[i]) {
                    int midIndex = stack.pop();
                    if (stack.peek() != null) {
                        area += (Math.min(height[stack.peek()], height[i]) - height[midIndex]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return area;
    }
}

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int area = 0;
        // we want to combine the two loop into one loop.
        // so we don't use for, but use while instead.
        int i = 0;
        while (i < n) {
            if (stack.size() == 0 || height[stack.peek()] > height[i]) {
                // if this filter, i plus one else we could not increase i.
                stack.push(i++);
            } else {
                int midIndex = stack.pop();
                if (stack.peek() != null) {
                    area += (Math.min(height[stack.peek()], height[i]) - height[midIndex]) * (i - stack.peek() - 1);
                }
            }
        }
        return area;
    }
}