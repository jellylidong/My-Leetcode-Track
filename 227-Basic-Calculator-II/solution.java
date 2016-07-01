public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; //sign before num
        int num = 0;
        s = s + "+0"; //this can help avoid case like "1", this case the 1 won't be pushed to stack, so it won't be eavlueated
        //by add "+0", we can avoid this case
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num + (c-'0');
            }
            else{
                //if not a digit, then current char can only be a sign
                //so we need to update sign
                //before update sign, we need to evaluate current number and current sign
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop()*num);
                else if(sign == '/')
                    stack.push(stack.pop()/num);
                    
                //update sign and begin to compose another num
                sign = c;
                num = 0;
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty())
            ans += stack.pop();
            
        return ans;
    }
}