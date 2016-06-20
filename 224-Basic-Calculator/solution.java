public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int sign = 1;
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(c == '(')
                stack.push("(");
            else if(c == '+')
                sign = 1;
            else if(c == '-')
                sign = -1;
            else if(c == ')'){
                String tmp = stack.pop();
                stack.pop();
                stack.push(tmp);
            }
            else if(c >= '0' && c <= '9'){
                int j = i+1;
                while(j < s.length() && sb.charAt(j) >= '0' && sb.charAt(j) <= '9')
                    j++;
                int num = Integer.parseInt(sb.substring(i, j));
                if(stack.isEmpty() || stack.peek().equals("("))
                    stack.push(sign == 1? num+"": "-"+num);
                else{
                    int num2 = Integer.parseInt(stack.pop());
                    num = sign*num + num2;
                    stack.push(""+num);
                }
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty()){
            ans += Integer.parseInt(stack.pop());
        }
        return ans;
    }
}