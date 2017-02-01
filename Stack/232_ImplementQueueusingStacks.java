public class MyQueue {
    Stack<Integer> s;
    Stack<Integer> q;
    /** Initialize your data structure here. */
    public MyQueue() {
        s = new Stack<Integer>();
        q = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        copyFromQtoS();
        q.push(x);
        copyFromStoQ();
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return q.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return q.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

    private void copyFromStoQ() {
        // q.clear();
        while(!s.isEmpty()) {
            q.push(s.pop());
        }
    }

    private void copyFromQtoS() {
        // s.clear();
        while(!q.isEmpty()) {
            s.push(q.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */