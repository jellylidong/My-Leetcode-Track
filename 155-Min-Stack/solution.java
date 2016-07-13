public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = x;
        if(!stack.isEmpty())
            min = Math.min(min, stack.peek());
        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int res = stack.peek();
        stack.push(min);
        return res;
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