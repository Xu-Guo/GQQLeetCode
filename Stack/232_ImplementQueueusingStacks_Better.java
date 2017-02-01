//  I move elements from input stack to output stack when needed, 
//  i.e., when I need to peek/pop but the output stack is empty. 
//  When that happens, I move all elements from input to output stack, 
//  thereby reversing the order so it's the correct order for peek/pop.

class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}