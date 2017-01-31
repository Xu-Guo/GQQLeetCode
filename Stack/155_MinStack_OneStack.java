public class MinStack {

    /** initialize your data structure here. */
    LinkedList<Long> stack;
    long min;
    public MinStack() {
        stack = new LinkedList<Long>();
    }
    
    public void push(int x) {
        if (stack.size() == 0) {
            min = x;
            stack.push((long)0);
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }
    
    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        long gap = stack.pop();
        if (gap < 0) {
            min -= gap;
        }
    }
    
    public int top() {
        if (stack.peek() > 0) {
            return (int)(min + stack.peek());
        }
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */