public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        int curMin;
        if(!stack.isEmpty())
            curMin = stack.peek();
        else
            curMin = Integer.MAX_VALUE;
        curMin = Math.min(curMin, x);
        stack.push(x);
        stack.push(curMin);
    }
    
    public void pop() {
        stack.pop();
        stack.pop();
    }
    
    public int top() {
        int n = stack.pop();
        int n2 = stack.peek();
        stack.push(n);
        return n2;
    }
    
    public int getMin() {
        return stack.peek();
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