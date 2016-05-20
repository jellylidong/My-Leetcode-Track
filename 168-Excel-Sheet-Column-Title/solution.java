public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        while(n != 0){
            int cur = n%26;
            if(cur == 0)
                ans += 'Z' + ans;
            else
                ans = (char)('A'-1+cur) + ans;
            if(n > 26)
                n /= 26;
            else if(n == 26){
                break;
            }
        }
        
        return ans;
    }
}