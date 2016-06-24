public class Solution {
    
    //heading and trailing space
    //number start with 0
    //number start with sign
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0)
            return 0;
            
        long ans = 0;
        int i = 0;
        long sign = 1;
        if(str.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        else if(str.charAt(i) == '-'){
            sign = - 1;
            i++;
        }
        while(i < str.length()){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                ans = 10*ans + (c-'0');
            }
            else
                break;
            if(sign*ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(sign*ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*ans);
    }
    
    // "  -0012a42"
    // "+12"
}