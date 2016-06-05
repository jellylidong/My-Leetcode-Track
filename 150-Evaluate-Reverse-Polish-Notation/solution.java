public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int n1 = 0;
        int n2 = 0;
        for(String s: tokens){
            if(s.equals("+")){
                n1 = stk.pop();
                n2 = stk.pop();
                stk.push(n2+n1);
            }
            else if(s.equals("-")){
                n1 = stk.pop();
                n2 = stk.pop();
                stk.push(n2-n1);
            }
            else if(s.equals("*")){
                n1 = stk.pop();
                n2 = stk.pop();
                stk.push(n2*n1);
            }
            else if(s.equals("/")){
                n1 = stk.pop();
                n2 = stk.pop();
                stk.push(n2/n1);
            }
            else{
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}