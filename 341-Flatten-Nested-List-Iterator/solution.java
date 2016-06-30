/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> list) {
        stack = new Stack<>();
        for(int i = list.size()-1; i >= 0; i--)
            stack.push(list.get(i));
    }

    @Override
    public Integer next() {
        //next() is only called after we check hasNext()
        //ie if hasNext, the top of stack must be an integer
        //so don't have to worry about it here
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(cur.isInteger())
                return true;
            else{
                stack.pop();
                for(int i = cur.getList().size()-1; i >= 0; i--){
                    stack.push(cur.getList().get(i));
                }
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */