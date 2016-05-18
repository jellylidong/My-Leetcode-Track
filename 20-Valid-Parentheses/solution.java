public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char cc = stack.peek();
                if((cc == '(' && c == ')') || (cc == '[' && c == ']') || (cc == '{' && c == '}'))
                    stack.pop();
                else
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}