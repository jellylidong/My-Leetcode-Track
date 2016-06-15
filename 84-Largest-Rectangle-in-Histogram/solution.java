public class Solution {
    //the comment is kind of mess, re-think!!!!!!!
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i);
            else{
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    // stack.pop();
                    //after the while loop, all height > heights[i] is popped
                    int left = stack.pop();
                    int len = 0;
                    if(stack.isEmpty())
                        len = i - 1 - (-1+1) + 1;
                    else
                        len = i - 1 -stack.peek()-1 + 1;
                    int area = len * heights[left];
                    max = Math.max(max, area);
                }
                //note the area here does not include two boundaries, ie does not include i and stack.peek()
                //if stack is empty, it means all heights int (left, i) and (0, left) both exclusive is >= heights[left]
                //then the length is (i-1) - (-1+1) + 1 = i
                //if stack is not empty, the peek of stack is heights[stack.peek()] > heights[i]
                //then the length is (i-1) - (stack.peek()+1) + 1 = i - stack.peek() - 1
                
                
                
                stack.push(i);
            }
        }
        
        
        
        //after loop ends, if stack is not empty, it means
        //the heights are in ascending order and i are consecutive!!!
        //prove: if the heights are not consecutive, 
        //for example we have stack peek(5,3)bottom, it means heights[4] is < heights[3]
        //but if so, we have to pop 3 before push 5, then the stack is impossile like peek(5,3)bottom
        //so the stack must be consecutive
        
        while(!stack.isEmpty()){
            int left = stack.pop();
            int len = 0;
            if(stack.isEmpty())
                len = heights.length - 1 - (-1+1) + 1;
            else
                len = heights.length - 1 -stack.peek() - 1 + 1;
            int area = len * heights[left];
            max = Math.max(max, area);
        }
        
        return max;
        
    }
}