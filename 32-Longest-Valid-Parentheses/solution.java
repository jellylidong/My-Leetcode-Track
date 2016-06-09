public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                stk.push(i);
            else if(c == ')'){
                if(stk.isEmpty() || s.charAt(stk.peek()) == ')'){
                    // max = Math.min(max, i);
                    stk.push(i);
                }
                else if(s.charAt(stk.peek()) == '('){
                    stk.pop();
                    if(stk.isEmpty())
                        max = Math.max(max, i);
                    else
                        max = Math.max(max, i-stk.peek());
                }
            }
        }
        
        return max;
    }
}