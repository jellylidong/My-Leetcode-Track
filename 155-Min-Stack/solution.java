public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        min = Math.min(min, x);
        stack.push(x);
        stack.push(min);
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        stack.pop();
        stack.pop();
        min = stack.isEmpty()? Integer.MAX_VALUE: stack.peek();
    }
    
    public int top() {
        
        int tmp = stack.pop();
        int top = stack.peek();
        stack.push(tmp);
        return top;
    }
    
    public int getMin() {
        return min;
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