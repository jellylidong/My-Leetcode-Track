public class Solution {
    //"(1-(3-4))"
    public int calculate(String s) {
       return helper(0, s);
    }
    
    public int helper(int start, String s){
        int ans = 0;
        int sign = 1;
        for(int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                return ans + sign*helper(i+1, s);
            if(c == ')'){
                if(i < s.length()){
                    if(s.charAt(i+1) == '+')
                        return ans + helper(i+2, s);
                    else
                        return ans - helper(i+2, s);
                }
                else    return ans;
            }
            if(c == '+')
                sign = 1;
            if(c == '-')
                sign = -1;
            if(c >= '0' && c <= '9'){
                int j = i+1;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    j++;
                int num = Integer.parseInt(s.substring(i, j));
                ans += sign*num;
            }
        }
        return ans;
    }
}