public class Solution {
    public int maximalRectangle(char[][] m) {
        //this is similar to 84. Largest Rectangle in Histogram
        //we use a height[] array to update heights[i]
        //ie go through rwo by rwo and update heights meanwhile
        //after each row scanned, the hegiht array is new hisogram
        if(m.length == 0 || m[0].length == 0)
            return 0;
            
        int max = 0;
        int[] heights = new int[m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            
            max = Math.max(max, solveHistogram(heights));
        }
        return max;
    }
    
    public int solveHistogram(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i);
            else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    int left = stack.pop();
                    int len = 0;
                    if(stack.isEmpty())
                        len = i;
                    else
                        len = i - stack.peek() - 1;
                    int area = len * heights[left];
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int left = stack.pop();
            int len = 0;
            if(stack.isEmpty())
                len = heights.length;
            else
                len = heights.length - stack.peek() - 1;
            int area = len * heights[left];
            max = Math.max(max, area);
        }
        
        return max;
    }
}