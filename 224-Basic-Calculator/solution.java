public class Solution {
    //"(1-(3-4))"
    //"(7)-(0)+(4)"
    public int calculate(String s) {
       Stack<Integer> stack = new Stack<>();
       int ans = 0;
       int sign = 1;
       int num = 0;
       
       for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(c == '('){
               stack.push(ans);
               stack.push(sign);
               ans = 0;
               sign = 1;
               num = 0;
           }
           if(c == ')'){
               ans += sign*num;
               ans *= stack.pop();
               ans += stack.pop();
               num = 0;
           }
           if(c == '-'){
                ans += sign*num;
                num = 0;
                sign = -1;
           }
           if(c == '+'){
                ans += sign*num;
                num = 0;
                sign = 1;
           }
           if(c >= '0' && c <= '9'){
               num = 10*num + (c - '0');
           }
       }
       
       ans += sign*num;
       return ans;
    }
    
    
}