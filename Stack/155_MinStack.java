public class MinStack {
    LinkedList<Integer> stack = null;
    LinkedList<Integer> minValues = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minValues = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        int minV = x;
        Integer nowMinV = minValues.peek();
        if(nowMinV != null && nowMinV < x) {
            minV = nowMinV;
        }
        minValues.push(minV);
    }
    
    public void pop() {
        stack.pop();
        minValues.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValues.peek();
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